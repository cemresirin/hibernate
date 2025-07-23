package com.cemre.service;

import com.cemre.dao.UserDao;
import com.cemre.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
