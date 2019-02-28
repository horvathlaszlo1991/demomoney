package com.example.demo.ui.user;

import com.example.demo.bl.user.UserService;
import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    @RequestMapping(value = "/users/active", method = RequestMethod.GET)
    public List<User> listActiveUsers() {
        return userService.listActiveUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getLoggedInUser(Authentication authentication) {
        if (authentication == null) {
            return new User();
        } else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userName = userDetails.getUsername();
            return userService.findUserByUsername(userName).get();
        }
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
    public Optional<User> getUserById(@PathVariable long userid) {
        return userService.findUserById(userid);
    }

    @RequestMapping(value = "/user/delete/{userid}", method = RequestMethod.DELETE)
    public Response deleteUserById(@PathVariable long userid) {
        return userService.deleteUserById(userid);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Response updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
