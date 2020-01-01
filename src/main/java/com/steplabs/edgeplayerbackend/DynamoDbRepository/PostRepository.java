package com.steplabs.edgeplayerbackend.DynamoDbRepository;

import com.steplabs.edgeplayerbackend.DynamoDBModels.Post;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PostRepository extends CrudRepository<Post,String> {

}
