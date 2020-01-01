package com.steplabs.edgeplayerbackend.service;

import com.steplabs.edgeplayerbackend.DynamoDBModels.Post;
import com.steplabs.edgeplayerbackend.exception.CustomException;

import java.util.Optional;

public interface PostService {
     Post createPost(Post post);
     Optional<Post> readPost(String postId);
     Post updatePost(Post post);
     void deletePost(String postId) throws CustomException;


}
