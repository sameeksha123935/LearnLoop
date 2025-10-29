package com.learnloop.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.learnloop.backend.model.QuizScore;
import com.learnloop.backend.repository.QuizScoreRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizScoreRepository quizRepo;

    @PostMapping("/save")
    public ResponseEntity<String> saveScore(@RequestBody QuizScore score) {
        quizRepo.save(score);
        return ResponseEntity.ok("✅ Score saved successfully!");
    }

    @GetMapping("/all")
    public List<QuizScore> getAllScores() {
        return quizRepo.findAll();
    }
}
