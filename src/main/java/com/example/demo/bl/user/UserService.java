package com.example.demo.bl.user;

import com.example.demo.db.user.UserDao;
import com.example.demo.model.Response;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Response createUser(User user) {
        return userDao.createUser(user);
    }

    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    public List<User> listActiveUsers() {
        return userDao.listActiveUsers();
    }

    public Response deleteUserById(long id) {
        return userDao.deleteUserById(id);
    }

    public Response updateUser(User user) {
        return userDao.updateUser(user);
    }

    public Optional<User> findUserById(long id) {
        return userDao.findUserById(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }


}
