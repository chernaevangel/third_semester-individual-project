package com.example.IndividualTrackProject.Model.DTOs.userDTO;

import lombok.Data;

@Data
public class userAuthenticationDTO {
    private Long id;
    private String email;
    private String username;
    private String password;

    public userAuthenticationDTO(Long id, String email,String username,String password){
        this.id=id;
        this.email=email;
        this.username=username;
        this.password=password;
    }

    public userAuthenticationDTO(String username,String password){

        this.username=username;
        this.password=password;
    }
}
