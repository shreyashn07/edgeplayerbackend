package com.steplabs.edgeplayerbackend.service;

import com.steplabs.edgeplayerbackend.model.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUser(Long id);
    User updateUser(User user) throws Exception;
    void deleteUser(Long userId) throws Exception;


}
