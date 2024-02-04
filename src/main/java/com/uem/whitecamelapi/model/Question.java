package com.uem.whitecamelapi.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // con @Entity y @Table creamos una entidad que se va a almacenar en bbdd
@Table(name = "questions")
public class Question {

    // con @Id definieremos la PK y con @GeneratedValue para los ID se
    // autoincrementen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statement;
    private Map<OptionEnum, String> options;
    private OptionEnum correctAnswer;
    private DifficultyLevel difficultyLevel;
    private String topic;
    private String media;

    public Question() {
    }

    public Question(Long id, String statement, Map<OptionEnum, String> options, OptionEnum correctAnswer,
            DifficultyLevel difficultyLevel, String topic, String media) {
        this.id = id;
        this.statement = statement;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficultyLevel = difficultyLevel;
        this.topic = topic;
        this.media = media;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Map<OptionEnum, String> getOptions() {
        return options;
    }

    public void setOptions(Map<OptionEnum, String> options) {
        if (options != null) {
            this.options = options;
        } else {
            // Manejo del caso de opciones nulas
            throw new IllegalArgumentException("El mapa de opciones no puede ser nulo");
        }
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    // Enums

    public enum OptionEnum {
        A, B, C
    }

    public enum DifficultyLevel {
        EASY, MEDIUM, HARD, EPIC
    }

    // To String

    @Override
    public String toString() {
        return "Question [id=" + id +
                ", statement=" + statement +
                ", options=" + options +
                ", correctAnswer=" + correctAnswer +
                ", difficultyLevel=" + difficultyLevel +
                ", topic=" + topic +
                ", media=" + media
                + "]";
    }

}
