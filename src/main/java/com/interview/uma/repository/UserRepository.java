package com.interview.uma.repository;

import com.interview.uma.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//User repository which handles all the database operations for the user table
public interface UserRepository extends CrudRepository<User, Long> {
    User findByNameAndPassword(String username, String Password);
}
