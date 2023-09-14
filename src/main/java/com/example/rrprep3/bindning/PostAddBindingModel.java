package com.example.rrprep3.bindning;

import com.example.rrprep3.model.entity.enums.MoodName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostAddBindingModel {
    private String Content;
    private MoodName mood;

    public PostAddBindingModel() {
    }
    @Size(min = 5, max=150, message = "PostContent must be between 5 and 150 characters")
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
    @NotNull(message = "You must select mood")
    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }
}

