package com.uem.whitecamelapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.uem.whitecamelapi.model.Question;
import com.uem.whitecamelapi.model.User;
import com.uem.whitecamelapi.repository.QuestionRepository;
import com.uem.whitecamelapi.repository.UserRepository;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context, UserRepository userRepository,
            QuestionRepository questionRepository) {
        return args -> {
            // Aquí puedes acceder a los beans y métodos de UserRepository
            // Ejemplo de usuario:
            User user = new User(null, "admin", "admin", new Date());
            userRepository.save(user);

            // Poblamos la bbdd con las preguntas varias
            // Leer el archivo JSON desde el classpath
            InputStream inputStream = getClass().getResourceAsStream("/json-files/questions.json");

            // si hay un error
            if (inputStream == null) {
                System.err.println("Error: No se pudo cargar el archivo JSON");
                return;
            }

            // Mapear el JSON a una lista de objetos Question
            ObjectMapper objectMapper = new ObjectMapper();
            List<Question> questions = objectMapper.readValue(inputStream,
                    TypeFactory.defaultInstance().constructCollectionType(List.class, Question.class));

            System.out.println("Número de preguntas cargadas: " + questions.size());

            // Guardar las preguntas en la base de datos
            questionRepository.saveAll(questions);
        };
    }

    @Configuration
    @EnableWebMvc
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Habilita CORS para todas las rutas
                    .allowedOriginPatterns("*")// Agrega los orígenes permitidos, en este caso son todos
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Agrega los métodos permitidos
                    .allowedHeaders("*") // Permite todos los encabezados
                    .allowCredentials(true); // Permite el envío de credenciales (por ejemplo, cookies)
        }
    }

}
