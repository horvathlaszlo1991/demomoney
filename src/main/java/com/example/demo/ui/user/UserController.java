package com.example.demo.ui.user;

import com.example.demo.bl.user.UserService;
import com.example.demo.model.Response;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    @RequestMapping("/")
    public String welcome() {
        return "Hello World!";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public Response createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
    public String getUserById(@PathVariable long userid) {
        if (userService.findUserById(userid).isPresent()) {
            return userService.findUserById(userid).get().toString();
        } else {
            return "User Not found";
        }
    }

}
