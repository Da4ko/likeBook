package com.example.rrprep3.model.entity;

import com.example.rrprep3.model.entity.BaseEntity;
import com.example.rrprep3.model.entity.enums.MoodName;
import jakarta.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity {
    private MoodName moodName;
    private String description;

    public Mood() {
    }

    public Mood(MoodName moodName, String description) {
        this.moodName = moodName;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public MoodName getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodName moodName) {
        this.moodName = moodName;
    }
    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
