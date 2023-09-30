package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

<<<<<<< HEAD
    public String getUserNameById(int userId);
=======
    String getUsernameById(int userId);
>>>>>>> c254d948537aa70ea2681a1791b591f122ea6c80

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);
}
