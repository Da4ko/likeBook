package com.example.rrprep3.repository;

import com.example.rrprep3.model.entity.Mood;
import com.example.rrprep3.model.entity.enums.MoodName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, String> {
    Optional<Mood> findByMoodName(MoodName moodName);
}
