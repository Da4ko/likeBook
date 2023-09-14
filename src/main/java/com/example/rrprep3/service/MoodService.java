package com.example.rrprep3.service;

import com.example.rrprep3.model.entity.Mood;
import com.example.rrprep3.model.entity.enums.MoodName;

public interface MoodService {
    void initMoods();

    Mood findByName(MoodName moodName);
}
