package com.example.IndividualTrackProject.Model.Request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String password;
    private String email;
}
