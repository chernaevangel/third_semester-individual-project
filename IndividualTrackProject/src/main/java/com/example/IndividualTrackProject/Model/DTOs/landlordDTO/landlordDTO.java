package com.example.IndividualTrackProject.Model.DTOs.landlordDTO;

import lombok.Data;

@Data
public class landlordDTO {
    private Long id;
    private String name;
    private String email;
    private String mobilePhone;
    private String verificationCode;

    public landlordDTO(Long id, String name, String email,String mobilePhone,String verificationCode){
        this.id=id;
        this.name=name;
        this.email=email;
        this.mobilePhone=mobilePhone;
        this.verificationCode=verificationCode;
    }
}
