package com.example.IndividualTrackProject.Model.DTOs.userDTO;

import lombok.Data;

@Data
public class UsersDTO {
    private Long id;
    private String email;
    private String username;

    public UsersDTO(Long id, String email,String username){
        this.id=id;
        this.email=email;
        this.username=username;
    }
}
