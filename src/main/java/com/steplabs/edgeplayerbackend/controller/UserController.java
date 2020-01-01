package com.steplabs.edgeplayerbackend.controller;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.steplabs.edgeplayerbackend.model.User;
import com.steplabs.edgeplayerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            User response = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            //TODO i need to figure out the right status code for the internal errors
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/user/{userId}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity fetchUser(@RequestBody Long userId) {
        try {
            Optional<User> response = userService.getUser(userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(response.get());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/user/delete", produces = {"application/json"}, method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody User user) {
        try {
            User response = userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/user/{userId}", produces = {"application/json"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestBody Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.status(HttpStatus.CREATED).body("User  Deleted ");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}
