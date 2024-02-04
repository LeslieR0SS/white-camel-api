package com.uem.whitecamelapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uem.whitecamelapi.model.Question;

@Repository // Anotación indicando que esta interfaz es un repositorio gestionado por Spring
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> findById(Long id);

    Optional<Question> findByTopic(String topic);

    Optional<Question> findByDifficultyLevel(Question.DifficultyLevel difficultyLevel);
    
    void deleteByTopic(String topic);

}
