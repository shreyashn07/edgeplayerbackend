package com.steplabs.edgeplayerbackend.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.config.EnableDynamoDBAuditing;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBAuditing
@EnableDynamoDBRepositories
        (basePackages = "com.steplabs.edgeplayerbackend.DynamoDbRepository")
public class DynamoDbConfig {
    @Value("${amazon.dynamodb.endpoint}")
    private String dynamoDbEndpoint;

    @Value("${amazon.aws.accessKey}")
    private String awsAccessKey;

    @Value("${amazon.aws.secretKey}")
    private String awsSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAJOVF7LY7MSJZY4QA", "2WA4i2Tgbxb38AVjQeuoeAictwwWFAENyGm/XnJA")))
                .withRegion(Regions.US_EAST_1)
                .build();

        return client;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }

}
