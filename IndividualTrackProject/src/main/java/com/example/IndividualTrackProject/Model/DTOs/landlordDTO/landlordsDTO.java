package com.example.IndividualTrackProject.Model.DTOs.landlordDTO;

import lombok.Data;

@Data
public class landlordsDTO {
    private Long id;
    private String name;
    private String email;
    private String mobilePhone;


    public landlordsDTO(Long id, String name, String email,String mobilePhone){
        this.id=id;
        this.name=name;
        this.email=email;
        this.mobilePhone=mobilePhone;
    }
}
