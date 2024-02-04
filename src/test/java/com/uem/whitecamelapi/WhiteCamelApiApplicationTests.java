package com.uem.whitecamelapi;

import com.uem.whitecamelapi.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = App.class)
class WhiteCamelApiApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
		// Verificar que la aplicación se carga correctamente
	}

	@Test
	void questionsLoadedSuccessfully() {
		// Verificar que se hayan cargado algunas preguntas en la base de datos
		long questionCount = questionRepository.count();
		assertEquals(16, questionCount, "Se esperan 16 preguntas en la base de datos");
	}
}
