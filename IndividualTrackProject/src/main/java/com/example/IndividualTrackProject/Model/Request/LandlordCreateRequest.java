package com.example.IndividualTrackProject.Model.Request;

import lombok.Data;

@Data
public class LandlordCreateRequest {
    private String name;
    private String email;
    private String mobilePhone;
    private String verificationCode;


}
