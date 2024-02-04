package com.uem.whitecamelapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uem.whitecamelapi.model.User;

@Repository // Anotación indicando que esta interfaz es un repositorio gestionado por Spring
public interface UserRepository extends JpaRepository <User, Long>{
    // La interfaz extiende JpaRepository, proporcionando operaciones CRUD estándar para la entidad User
    List<User> findById(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByRegistrationDate(Date signUpDate);
}
