package com.example.rrprep3.Init;

import com.example.rrprep3.service.MoodService;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInitializer implements CommandLineRunner {
    private final MoodService moodService;

    public DataBaseInitializer(MoodService moodService) {
        this.moodService = moodService;

    }
    @Override
    public void run(String...args) throws Exception{
        moodService.initMoods();
    }
}
