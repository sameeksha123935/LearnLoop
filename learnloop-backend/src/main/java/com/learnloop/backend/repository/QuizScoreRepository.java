package com.learnloop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learnloop.backend.model.QuizScore;

public interface QuizScoreRepository extends JpaRepository<QuizScore, Long> {
}
