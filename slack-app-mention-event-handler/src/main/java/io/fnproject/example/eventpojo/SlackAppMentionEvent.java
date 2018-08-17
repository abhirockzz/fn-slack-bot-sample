package io.fnproject.example.eventpojo;

import java.util.List;

/**
 * see https://api.slack.com/events/app_mention for payload
 */
public class SlackAppMentionEvent {

    private String token;
    private String team_id;
    private String api_app_id;
    private Event event;
    private String type;
    private String event_id;
    private String event_time;
    private List<String> authed_users;
    
    public SlackAppMentionEvent() {
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public List<String> getAuthed_users() {
        return authed_users;
    }

    public void setAuthed_users(List<String> authed_users) {
        this.authed_users = authed_users;
    }

    
    public String getApi_app_id() {
        return api_app_id;
    }

    public void setApi_app_id(String api_app_id) {
        this.api_app_id = api_app_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SlackAppMentionHandlerEvent{" + "token=" + token + ", team_id=" + team_id + ", api_app_id=" + api_app_id + ", event=" + event + ", type=" + type + ", event_id=" + event_id + ", event_time=" + event_time + ", authed_users=" + authed_users + '}';
    }

    
    
}
