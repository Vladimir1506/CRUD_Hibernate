package com.vladimir1506.crud_hibernate.controller;

import com.vladimir1506.crud_hibernate.model.Post;
import com.vladimir1506.crud_hibernate.model.Region;
import com.vladimir1506.crud_hibernate.model.Role;
import com.vladimir1506.crud_hibernate.model.User;
import com.vladimir1506.crud_hibernate.repository.UserRepository;
import com.vladimir1506.crud_hibernate.repository.implementation.DBUserRepositoryImpl;


import java.util.List;

public class UserController {
    private final UserRepository userRepository;

    public UserController() {
        this.userRepository = new DBUserRepositoryImpl();
    }

    public User createUser(String firstName, String lastName, List<Post> posts, Region region, Role role) {
        User user = new User(firstName, lastName, region, role);

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    public void updateUser(Long id, String firstName, String lastName, Region region, Role role) {
        User updatedUser = new User(firstName, lastName, region, role);
        updatedUser.setId(id);
        userRepository.update(updatedUser);
    }
}
