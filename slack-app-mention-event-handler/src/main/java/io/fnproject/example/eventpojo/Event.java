package io.fnproject.example.eventpojo;

public class Event {

    private String type;
    private String user;
    private String text;
    private String client_msg_id;
    private String ts;
    private String channel;
    private String event_ts;

    public Event() {
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getClient_msg_id() {
        return client_msg_id;
    }

    public void setClient_msg_id(String client_msg_id) {
        this.client_msg_id = client_msg_id;
    }
    
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getEvent_ts() {
        return event_ts;
    }

    public void setEvent_ts(String event_ts) {
        this.event_ts = event_ts;
    }
}
