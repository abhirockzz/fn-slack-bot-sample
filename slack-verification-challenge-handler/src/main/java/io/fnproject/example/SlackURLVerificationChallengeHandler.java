package io.fnproject.example;

public class SlackURLVerificationChallengeHandler {

    /**
     * just following orders ! see - https://api.slack.com/events-api#request_url_configuration__amp__verification
     */
    public String handleVerificationChallenge(SlackTokenChallenge urlVerificationTokenChallenge) {
        System.err.println("Got challenge token " + urlVerificationTokenChallenge);

        return urlVerificationTokenChallenge.getChallenge();
    }

    static class SlackTokenChallenge {

        private String token;
        private String challenge;
        private String type;

        public SlackTokenChallenge() {
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getChallenge() {
            return challenge;
        }

        public void setChallenge(String challenge) {
            this.challenge = challenge;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "SlackTokenChallenge{" + "token=" + token + ", challenge=" + challenge + ", type=" + type + '}';
        }

    }

}
