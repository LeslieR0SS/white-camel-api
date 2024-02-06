package com.uem.whitecamelapi.service;

import java.util.List;
import java.util.Optional;

import com.uem.whitecamelapi.model.Question;

public interface QuestionService {

    // CREATE + UPDATE
    Question save(Question question);

    // READ

    List<Question> findAll();

    Optional<Question> findById(Long id);

    Optional<Question> findByTopic(String topic);

    Optional<Question> findByDifficultyLevel(Question.DifficultyLevel difficultyLevel);

    // DELETE
    void deleteById(Long id);

    void deleteByTopic(String topic);

    void deleteAll();

}
