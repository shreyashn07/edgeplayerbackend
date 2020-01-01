package com.steplabs.edgeplayerbackend.service;

import com.steplabs.edgeplayerbackend.exception.CustomException;
import com.steplabs.edgeplayerbackend.model.User;
import com.steplabs.edgeplayerbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user){

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);


    }

    @Override
    public User updateUser(User user) throws Exception{
       Optional<User> userRet= userRepository.findById(user.getUserId());
       if(userRet.isPresent())
       {
           return userRepository.save(user);
       }
       else
           throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"User not found");
       }

    @Override
    public void deleteUser(Long userId) throws Exception{
        Optional<User> userRet= userRepository.findById(userId);
        if(userRet.isPresent()){
            userRepository.delete(userRet.get());
        }
        else
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"User not found");



    }




}
