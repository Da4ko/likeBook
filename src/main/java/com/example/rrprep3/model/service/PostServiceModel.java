package com.example.rrprep3.model.service;

import com.example.rrprep3.model.entity.Mood;
import com.example.rrprep3.model.entity.User;
import com.example.rrprep3.model.entity.enums.MoodName;

import java.util.List;

public class PostServiceModel {

    private String id;
    private String content;
    private User user;
    private List<User> userLikes;
    private MoodName mood;

    public PostServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }

    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }
}
