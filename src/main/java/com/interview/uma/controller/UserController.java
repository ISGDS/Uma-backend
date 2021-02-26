package com.interview.uma.controller;

import com.interview.uma.entity.User;
import com.interview.uma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
//User controller which serves the requests of the application to the angular frontend
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/getUser")
    public User getUser(){
        return userService.getUser(1L);
    }

    @PutMapping(value = "/updateUser/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(user);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @PostMapping(value = "/addUser",produces = "text/json")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    //Login doesn't look good and should be done with spring security and handled separate, but the implementation took me longer ( same as in angular, got stuck with CORS problems) than i thought, so in the end wanted to just make it work
    @PostMapping(value = "/login",produces = "application/json")
    public User loginUser(@RequestBody User user){
        userService.checkCredentials(user.getName(),user.getPassword());
        return user;
    }

}
