package com.crud.project.dao;

import com.crud.project.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;


    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void deleteUser(int id) {
        sessionFactory.getCurrentSession().delete(id);
    }

    public List<User> getAllUsers() {
        User user = new User();
        return sessionFactory.getCurrentSession().createQuery(" FROM " + user.getName()).list();
    }

    public List<User> getUsersByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE USER_NAME = :name");
        query.setParameter("name", name);
        List<User> users = query.list();
        return users;
    }

    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class,id);
    }
}
