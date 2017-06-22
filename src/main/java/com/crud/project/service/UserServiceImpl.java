package com.crud.project.service;

import com.crud.project.dao.UserDao;
import com.crud.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }

    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
