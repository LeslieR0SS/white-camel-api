package com.uem.whitecamelapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.uem.whitecamelapi.model.Question;
import com.uem.whitecamelapi.service.QuestionService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class QuestionController {

    private QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> findAll() {
        List<Question> questions = service.findAll();

        if (questions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(questions);
    }

    @GetMapping("/questions/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Question> questionOptional = service.findById(id);

        if (questionOptional.isEmpty()) {
            String message = "Pregunta con ID " + id + " no encontrada.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        Question question = questionOptional.get();
        return ResponseEntity.ok(question);
    }

    @GetMapping("questions/topic/{topic}")
    public ResponseEntity<?> findByTopic(@PathVariable String topic) {
        Optional<Question> questionOptional = service.findByTopic(topic);

        if (questionOptional.isPresent()) {
            return ResponseEntity.ok(questionOptional.get());
        } else {
            String message = "Pregunta con tema '" + topic + "' no encontrada.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    // REVISARRRRRRR, A VECES VA BIEN Y OTRAS MAL. DA 500
    @GetMapping("/questions/difficultyLevel/{difficultyLevel}")
    public ResponseEntity<?> findByDifficultyLevel(@PathVariable String difficultyLevel) {
        try {
            Question.DifficultyLevel level = Question.DifficultyLevel.valueOf(difficultyLevel.toUpperCase());
            Optional<Question> questionOptional = service.findByDifficultyLevel(level);

            if (questionOptional.isPresent()) {
                return ResponseEntity.ok(questionOptional.get());
            } else {
                String message = "Pregunta con nivel de dificultad '" + difficultyLevel + "' no encontrada.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
            }
        } catch (IllegalArgumentException e) {
            String message = "Nivel de dificultad '" + difficultyLevel + "' no válido.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }

    /* GET http://localhost:8080/api/questions */
    @PostMapping("questions")
    public ResponseEntity<Question> save(@RequestBody Question question) {
        Question newQuestion = service.save(question);
        return ResponseEntity.ok(newQuestion);
    }

    @PutMapping("questions/{id}")
    public ResponseEntity<Question> update(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> existingQuestion = service.findById(id);

        if (existingQuestion.isPresent()) {
            Question foundQuestion = existingQuestion.get();
            foundQuestion.setStatement(question.getStatement());
            foundQuestion.setOptions(question.getOptions());
            foundQuestion.setCorrectAnswer(question.getCorrectAnswer());
            foundQuestion.setDifficultyLevel(question.getDifficultyLevel());
            foundQuestion.setTopic(question.getTopic());
            foundQuestion.setMedia(question.getMedia());

            Question updatedQuestion = service.save(foundQuestion);
            return ResponseEntity.ok(updatedQuestion);
        } else {
            throw new RuntimeException("Question con ID " + question.getId() + " no encontrado");
        }
    }

    @DeleteMapping("questions/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pregunta con ID " + id + " eliminada correctamente");
    }

    @DeleteMapping("/topic/{topic}")
    public ResponseEntity<String> deleteByTopic(@PathVariable String topic) {
        service.deleteByTopic(topic);
        return ResponseEntity.status(HttpStatus.OK).body("Preguntas con tema '" + topic + "' eliminadas correctamente");
    }

    @DeleteMapping("questions")
    public ResponseEntity<String> deleteAll() {
        service.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Todas las preguntas eliminadas correctamente");
    }
}
