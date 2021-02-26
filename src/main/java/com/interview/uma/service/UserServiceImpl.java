package com.interview.uma.service;

import com.interview.uma.entity.User;
import com.interview.uma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
//User service which handles the user logic and connects user controller and user repository
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }


    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void deleteUserById(Long id){
        userRepository.delete(userRepository.findById(id).get());
    }

    public void updateUser(User updatedUser){
        User user = userRepository.findById(updatedUser.getId()).get();
        user.setDate(updatedUser.getDate());
        user.setEmail(updatedUser.getEmail());
        user.setName(updatedUser.getName());
        user.setSurename(updatedUser.getSurename());
        user.setPhone(updatedUser.getPhone());
        userRepository.save(user);
    }

    public boolean checkCredentials(String username, String password){
        return !userRepository.findByNameAndPassword(username, password).equals(null);
    }
}