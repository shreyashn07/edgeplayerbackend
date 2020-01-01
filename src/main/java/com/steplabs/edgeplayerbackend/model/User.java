package com.steplabs.edgeplayerbackend.model;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name="user")
public class User extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    @Size(max=30)
    private String userName;

    @NonNull
    @Size(max=30)
    private String emailId;

    @NonNull
    @Size(max=250)
    private String profilePic;

    @NonNull
    @Size(max=100)
    private String spotifyId;



}
