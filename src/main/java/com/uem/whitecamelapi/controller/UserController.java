package com.uem.whitecamelapi.controller;

import com.uem.whitecamelapi.model.User;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.uem.whitecamelapi.service.UserService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /* GET http://localhost:8080/api */
    @GetMapping
    public ResponseEntity<String> welcomeMessage() {
        String welcomeMessage = "¡Bienvenido/a a la API de White Camel!";
        return ResponseEntity.ok(welcomeMessage);
    }




    /* GET http://localhost:8080/api/users */
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = this.service.findAll();
        
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(users);
    }

    /* GET http://localhost:8080/api/users */
    @GetMapping("/users/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        // Llamada al servicio para buscar un usuario por su ID
        Optional<User> userOptional = this.service.findById(id);
    
        // Verificar si el usuario fue encontrado
        if (userOptional.isEmpty()) {
            String mensaje = "Usuario con ID " + id + " no encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    
        // Extraer el usuario del Optional
        User user = userOptional.get();
    
        return ResponseEntity.ok(user);
    }
    

    /* GET http://localhost:8080/api/users */
    @GetMapping("/users/username/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
        // Llamada al servicio para buscar un usuario por su nombre de usuario
        Optional<User> userOptional = this.service.findByUsername(username);
    
        // Verificar si el usuario fue encontrado en base al Optional
        if (userOptional.isPresent()) {
            // Si el usuario está, responder con un código 200 OK y el usuario encontrado
            return ResponseEntity.ok(userOptional.get());
        } else {
            // Si el usuario no está, responder con un código 404 Not Found y un mensaje personalizado
            String mensaje = "Usuario con nombre de usuario '" + username + "' no encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }
    

    /* GET http://localhost:8080/api/users */
    /*                                                        TO REFACTOR *****
    @GetMapping("/users/dates/{registrationDate}")
    public ResponseEntity<User> findByRegistrationDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date registrationDate) {
        // Llamada al servicio para buscar un usuario por su fecha de registro. Ej ISO date /api/users/2022-03-01
        Optional<User> userOptional = this.service.findByRegistrationDate(registrationDate);

        // Verificar si el usuario fue encontrado en base al Optional
        if (userOptional.isPresent()) {
            // Si el usuario está presente, responder con un código 200 OK y el usuario encontrado
            return ResponseEntity.ok(userOptional.get());
        } else {
            // Si el usuario no está presente, responder con un código 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
    */
    /* GET http://localhost:8080/api/users */
    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody User user) {
        // Establecer registrationDate antes de guardar
        if (user.getRegistrationDate() == null) {
            user.setRegistrationDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }

        // Guardar el usuario
        User newUser = service.save(user);

        // Responder con el usuario guardado
        return ResponseEntity.ok(newUser);
    }

    /* GET http://localhost:8080/api/users */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        // Buscar el usuario existente por ID
        Optional<User> existingUser = service.findById(id);
        
        // Verificar si el usuario existe
        if (existingUser.isPresent()) {
            User foundUser = existingUser.get();
    
            // Verificar si se está intentando cambiar el nombre de usuario
            if (user.getUsername() != null) {
                // Verificar si el nuevo nombre de usuario ya existe en la base de datos
                if (service.findByUsername(user.getUsername()).isPresent() &&
                        !foundUser.getUsername().equals(user.getUsername())) {
                    throw new RuntimeException("No se permite cambiar el nombre de usuario porque ya existe otro.");
                }
            }
    
            // Actualizar el usuario con la información proporcionada
            foundUser.save(user);
    
            // Guardar el usuario actualizado
            User savedUser = service.save(foundUser);
    
            return ResponseEntity.ok(savedUser);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @DeleteMapping("/users/{id}")
        public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario con el ID " + id + " eliminado correctamente");
        }

}
