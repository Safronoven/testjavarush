package com.crud.project.dao;

import com.crud.project.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
    User getUser(int id);
    List<User> getUsersByName(String name);
}
