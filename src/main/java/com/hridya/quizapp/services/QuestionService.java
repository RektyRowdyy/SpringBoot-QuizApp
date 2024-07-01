package com.hridya.quizapp.services;

import com.hridya.quizapp.models.Question;
import com.hridya.quizapp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepository.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("request failed", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestion(int id) {

        try {
            Optional<Question> exists =  questionRepository.findById(id);
            if(exists.isPresent()) {
                questionRepository.deleteById(id);
                return new ResponseEntity<>("Question deleted successfully",HttpStatus.OK);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Question not found",HttpStatus.BAD_REQUEST);
    }
}
