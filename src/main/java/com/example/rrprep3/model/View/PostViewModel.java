package com.example.rrprep3.model.View;

import com.example.rrprep3.model.entity.Mood;
import com.example.rrprep3.model.entity.User;

import java.util.List;

public class PostViewModel {

    private String id;
    private String content;
    private String username;
    private int likes;
    private String moodName;

    public PostViewModel() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }
}
