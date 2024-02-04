package com.uem.whitecamelapi;

import com.uem.whitecamelapi.model.User;
import com.uem.whitecamelapi.repository.UserRepository;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context, UserRepository userRepository) {
        return args -> {
            // Aquí puedes acceder a los beans y métodos de UserRepository
            // Ejemplo:
            User user = new User(null, "admin", "admin", new Date());
            userRepository.save(user);
        };
    }
}
