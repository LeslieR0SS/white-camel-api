package com.uem.whitecamelapi.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("question")

public class Question {
    
    @Id
    private String Id;
    
    private String statement;
    private Object options;
    private String correctAnswer;
    private Enum difficultyLevel;
    private String topic;
    private String media;
}
