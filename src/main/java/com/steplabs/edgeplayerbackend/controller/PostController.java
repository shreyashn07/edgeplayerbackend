package com.steplabs.edgeplayerbackend.controller;


import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.steplabs.edgeplayerbackend.DynamoDBModels.Post;
import com.steplabs.edgeplayerbackend.exception.CustomException;
import com.steplabs.edgeplayerbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity createPost(@RequestBody Post post) {
        try {
            Post response = postService.createPost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }


    @RequestMapping(value = "/posts/{postId}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity readPost(@PathVariable String postId) {
        try {
            Optional<Post> response = postService.readPost(postId);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/posts/update", produces = {"application/json"}, method = RequestMethod.PUT)
    public ResponseEntity updatePost(@RequestBody Post post) {
        try {
            Post response = postService.updatePost(post);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/posts/delete/{postId}", produces = {"application/json"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable String postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (CustomException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage(), e);
        }
    }



}
