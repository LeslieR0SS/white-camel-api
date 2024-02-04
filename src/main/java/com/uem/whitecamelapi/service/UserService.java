package com.uem.whitecamelapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.uem.whitecamelapi.model.User;

/* Aquí defeniremos todos los métodos que tendremos en nuestra lógica de negocio y las operaciones CRUD */

public interface UserService {

    // CREATE + UPDATE 
    User save(User user);


    // READ 
    List<User> findAll();

    Optional<User> findById (Long id);

    Optional  <User> findByUsername (String username);

    Optional <User> findByRegistrationDate (Date signUpDate);
    

    // DELELTE
    void deleteById(Long id);
    void deleteAll();

    
}
