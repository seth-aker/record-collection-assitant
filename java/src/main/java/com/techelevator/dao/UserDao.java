package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    String getUserNameById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);
    boolean findUserPremiumStatus(int userId);

    boolean create(String username, String password, String role, boolean premium);
}
