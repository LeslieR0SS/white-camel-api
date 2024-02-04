package com.uem.whitecamelapi.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.uem.whitecamelapi.model.User;
import com.uem.whitecamelapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    // Constructor para inyección de dependencias
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        Objects.requireNonNull(id); // para en caso que el id no sea válido, dar un error
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByRegistrationDate(Date signUpDate) {
        return userRepository.findByRegistrationDate(signUpDate);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}

