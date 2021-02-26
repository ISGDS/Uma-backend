package com.interview.uma.service;

import com.interview.uma.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUser(Long id);

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    void deleteUserById(Long id);

    void updateUser(User updatedUser);

    boolean checkCredentials(String username, String password);
}
