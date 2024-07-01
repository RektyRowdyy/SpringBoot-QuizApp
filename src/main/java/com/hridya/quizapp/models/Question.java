package com.hridya.quizapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//@Data from the library lombok helps us to avoid writing all getters and setters for each field
@Data
@Entity
public class Question {

    //@Id to specify that it is a primary key
    //@GeneratedValue to make it auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String difficultylevel;
    private String category;
    private String questiontitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightanswer;

}
