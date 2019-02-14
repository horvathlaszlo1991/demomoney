package com.example.demo.bl.user;

import com.example.demo.db.user.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


}
