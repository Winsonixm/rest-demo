package com.example.controller;

import com.example.exceptions.DataIntegrityViolationException;
import com.example.exceptions.NotFoundException;
import com.example.models.User;
import com.example.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            throw new NotFoundException("No users found");
        }
         
        return users;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") String id) {
        logger.info("Fetching User with id {}", id);
        Optional<User> user = userService.findById(id) ;
        if (!user.isPresent()) {
            logger.error("User with id {} not found.", id) ;
            throw new NotFoundException(String.format("User %s not found  ", id));
        }

        return user.get();
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        logger.info("Creating User : {}", user);

        if (userService.isUserExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getName());
            throw new DataIntegrityViolationException("User already exist");
        }
        userService.saveUser(user);
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id") String id, @RequestBody User user) {
        logger.info("Updating User with id {}", id);

        Optional<User> currentUserOpt = userService.findById(id);

        if (!currentUserOpt.isPresent()) {
            logger.error("Unable to update. User with id {} not found.", id);
            throw new NotFoundException(String.format("User %s not found", id));
        }

        User currentUser = currentUserOpt.get();
        currentUser.setName(user.getName());
        currentUser.setAge(user.getAge());
        currentUser.setSalary(user.getSalary());

        userService.updateUser(currentUser);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) {
        logger.info("Fetching & Deleting User with id {}", id);

        Optional<User> currentUserOpt = userService.findById(id);
        if (!currentUserOpt.isPresent()) {
            logger.error("Unable to delete. User with id {} not found.", id);
            throw new NotFoundException(String.format("User %s not found", id));
        }
        userService.deleteUserById(id);
    }


    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public void deleteAllUsers() {
        logger.info("Deleting All Users");

        userService.deleteAllUsers();
    }

}
