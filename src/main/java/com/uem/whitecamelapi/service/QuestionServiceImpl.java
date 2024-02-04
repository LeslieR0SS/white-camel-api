package com.uem.whitecamelapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uem.whitecamelapi.model.Question;
import com.uem.whitecamelapi.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    // constructor dónde inyectamos las dependencias
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        Objects.requireNonNull(id);
        return questionRepository.findById(id);
    }

    @Override
    public Optional<Question> findByTopic(String topic) {
        Objects.requireNonNull(topic);
        return questionRepository.findByTopic(topic);
    }

    @Override
    public Optional<Question> findByDifficultyLevel(Question.DifficultyLevel difficultyLevel){
        Objects.requireNonNull(difficultyLevel);
        return questionRepository.findByDifficultyLevel(difficultyLevel);
    }


    // DELETE
    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void deleteByTopic(String topic) {
        Objects.requireNonNull(topic);
        questionRepository.deleteByTopic(topic);
    }


    @Override
    public void deleteAll() {
        questionRepository.deleteAll();
    }




}
