package io.fnproject.example;

import com.google.gson.Gson;

import io.fnproject.example.eventpojo.SlackAppMentionEvent;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class FnSlackBot {

    Client client = null;
    static final String ENDPOINT = "https://slack.com/api/chat.postMessage";

    public FnSlackBot() {
        TrustManager[] customTrustManager = new TrustManager[]{
            new X509TrustManager() {

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };

        try {
            SSLContext sc = SSLContext.getInstance("ssl");
            sc.init(null, customTrustManager, null);

            client = ClientBuilder
                    .newBuilder()
                    .sslContext(sc) //javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
                    .hostnameVerifier((a, b) -> true) //javax.net.ssl.SSLHandshakeException: java.security.cert.CertificateException: No subject alternative names present
                    .build();

        } catch (Throwable e) {
            System.err.println("Error - " + e.getMessage());
        }
    }

    public void handleEvent(SlackAppMentionEvent appMentionEvent) throws IOException {
        System.out.println("Got event from slack...\n" + appMentionEvent);

        String verificationToken = System.getenv().getOrDefault("SLACK_VERIFICATION_TOKEN", "invalid slack verification token");
        String botOAuthToken = System.getenv().getOrDefault("SLACK_BOT_OAUTH_TOKEN", "invalid bot oauth token");

        if (!verificationToken.equals(appMentionEvent.getToken())) {
            System.err.println("Tokens dont match... message not sent by Slack");
            return;
        }
        WebTarget target = null;

        String respStatus = null;
        String channel = appMentionEvent.getEvent().getChannel();
        try {

            target = client.target(ENDPOINT);

            respStatus = target.request()
                    .header("Authorization", "Bearer " + botOAuthToken)
                    .post(Entity.entity(new Gson().toJson(new BotResponse(channel, "Good times! " + new Date())), MediaType.APPLICATION_JSON)).readEntity(String.class);

        } catch (Exception se) {
            System.err.println("Unable to post to slack " + se.getMessage());
        }

        System.out.println("RESULT === " + respStatus);
    }

    public static class BotResponse {

        String channel;
        String text;

        public BotResponse() {
        }

        public BotResponse(String channel, String text) {
            this.channel = channel;
            this.text = text;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }
}
