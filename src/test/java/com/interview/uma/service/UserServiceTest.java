package com.interview.uma.service;


import com.interview.uma.entity.User;
import com.interview.uma.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
//Not really good way to test because of the in memory database, gets populated in the runtime scope
class UserServiceTest {

    @Mock
    private UserService userService;

    @Before
    public void init(){
        userService = Mockito.mock(UserService.class);
    }

    @Test
    public void getAllUsers(){
        Mockito.when(userService.getAllUsers()).thenReturn(new ArrayList<>());
        List<User> userList = this.userService.getAllUsers();
        Assert.assertEquals(new ArrayList<>(), userList);
    }

    @Test
    public void checkCredentials(){
        Mockito.when(userService.checkCredentials("username","password")).thenReturn(false);
        boolean b = this.userService.checkCredentials("username","password");
        Assert.assertEquals(false, b);
    }

    @Test
    public void getUser(){
        Mockito.when(userService.getUser(1L)).thenReturn(new User());
        User user = this.userService.getUser(1L);
        Assert.assertEquals(new User(), user);
    }

    @Test
    public void addUser(){
        User addedUser = new User();
        addedUser.setId(1L);
        addedUser.setName("test");
        addedUser.setPassword("test");
        this.userService.addUser(addedUser);
        User user = this.userService.getUser(1L);
        Assert.assertNotNull(user);
    }

    @Test
    public void updateUser(){
        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setName("test");
        updatedUser.setPassword("test");
        User user = this.userService.getUser(1L);
        this.userService.updateUser(updatedUser);
        Assert.assertNotEquals(user, this.userService.getUser(1L));
    }

    @Test
    public void deleteUser(){
        User deletedUser = new User();
        deletedUser.setId(1L);
        deletedUser.setName("test");
        deletedUser.setPassword("test");
        this.userService.deleteUser(deletedUser);
        User user = this.userService.getUser(1L);
        Assert.assertNull(user);
    }

}
