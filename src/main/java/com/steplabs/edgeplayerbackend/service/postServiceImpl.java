package com.steplabs.edgeplayerbackend.service;

import com.steplabs.edgeplayerbackend.DynamoDBModels.Post;
import com.steplabs.edgeplayerbackend.DynamoDbRepository.PostRepository;

import com.steplabs.edgeplayerbackend.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class postServiceImpl implements PostService {


   @Autowired
   private PostRepository postrepository;



    @Override
    public Post createPost(Post post){

        return postrepository.save(post);

    }

    @Override
    public Optional<Post> readPost(String postId){

         return postrepository.findById(postId);

    }

    @Override
    public Post updatePost(Post post){
        return postrepository.save(post);
    }

    @Override
    public void deletePost(String postId) throws CustomException{
        Optional<Post> postRet= postrepository.findById(postId);
        if(postRet.isPresent())
        {
            postrepository.delete(postRet.get());
        }
        else
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"Post not found to delete");

    }






}
