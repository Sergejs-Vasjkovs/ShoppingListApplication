package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.HibernateUserRepository;
import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.service.validation.user.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final HibernateUserRepository repository;
    private final UserValidationService userValidationService;

    @Autowired
    public UserService(HibernateUserRepository repository, UserValidationService userValidationService) {
        this.repository = repository;
        this.userValidationService = userValidationService;
    }

    @Transactional
    public void save(User user) {
        userValidationService.validate(user);
        repository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = repository.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with " + id + " not found"));
        repository.delete(user);
    }

    public User findUserByID(Long id) {
        return repository.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with " + id + " not found"));
    }

    public void deleteUserByName(String name) {
        User user = repository.findUserByName(name)
                .orElseThrow(() -> new IllegalArgumentException("User " + name + " not found"));
        repository.delete(user);
    }

    public User findUserByName(String name) {
        User user = repository.findUserByName(name)
                .orElseThrow(() -> new IllegalArgumentException("User " + name + " not found"));
        repository.delete(user);
        return user;
    }

    public void updateUserById(Long id, String name) {
        User user = repository.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with " + id + " not found"));
        user.setName(name);
        repository.update(user);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

}
