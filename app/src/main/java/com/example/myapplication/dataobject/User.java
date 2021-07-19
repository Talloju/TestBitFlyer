package com.example.myapplication.dataobject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private int id;
    @SerializedName("node_id")
    private String node_id;
    @SerializedName("avatar_url")
    private String avatar_url;
    @SerializedName("gravatar_id")
    private String gravatar_id;
    @SerializedName("url")
    private String url;
    @SerializedName("html_url")
    private String html_url;
    @SerializedName("followers_url")
    private String followers_url;
    @SerializedName("following_url")
    private String following_url;
    @SerializedName("gists_url")
    private String gists_url;
    @SerializedName("starred_url")
    private String starred_url;
    @SerializedName("subscriptions_url")
    private String subscriptions_url;
    @SerializedName("organizations_url")
    private String organizations_url;
    @SerializedName("repos_url")
    private String repos_url;
    @SerializedName("events_url")
    private String events_url;
    @SerializedName("received_events_url")
    private String received_events_url;
    @SerializedName("type")
    private String type;
    @SerializedName("site_admin")
    private boolean site_admin;

    public User(String login, String capital) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String getType() {
        return type;
    }

    public boolean getSite_admin() {
        return site_admin;
    }
}
