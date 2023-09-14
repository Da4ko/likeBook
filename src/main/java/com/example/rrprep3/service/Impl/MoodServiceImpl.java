package com.example.rrprep3.service.Impl;

import com.example.rrprep3.model.entity.Mood;
import com.example.rrprep3.model.entity.enums.MoodName;
import com.example.rrprep3.repository.MoodRepository;
import com.example.rrprep3.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {
    private final MoodRepository moodRepository;

    public  MoodServiceImpl( MoodRepository moodRepository) {
        this.moodRepository =  moodRepository;
    }

    @Override
    public void initMoods() {
        if(moodRepository.count() == 0) {
            Arrays.stream(MoodName.values())
                    .forEach(moodName -> {
                        Mood mood = new Mood(moodName,
                                "Description for " + moodName.name());

                        moodRepository.save(mood);
                    });
        }
    }

    @Override
    public Mood findByName(MoodName moodName) {
        return moodRepository.findByMoodName(moodName).orElse(null);
    }
}
