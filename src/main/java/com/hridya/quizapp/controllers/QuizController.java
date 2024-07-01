package com.hridya.quizapp.controllers;

import com.hridya.quizapp.models.Question;
import com.hridya.quizapp.models.QuestionWrapper;
import com.hridya.quizapp.models.Response;
import com.hridya.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping(path = "create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numOfQuestions, @RequestParam String title) {
        return quizService.createQuiz(category, numOfQuestions, title);
    }

    @GetMapping(path = "get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") Integer id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping(path = "submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id,responses);
    }

}
