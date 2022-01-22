package com.example.IndividualTrackProject.Model.DTOs.houseDTO;

import lombok.Data;

@Data
public class housesDTO {

    private long id;
    private String address;
    private String description;
    private boolean accessible;
    private double pricePerNight;
    private Long landlordId;
    private String landlordName;
    private String landlordPhone;
    private String landlordEmail;


    public housesDTO(long Id, String address,String description,boolean accessible,double pricePerNight,long landlordId,String landlordName,String landlordPhone,String landlordEmail){
        this.id=Id;
        this.address=address;
        this.description=description;
        this.accessible=accessible;
        this.pricePerNight=pricePerNight;
        this.landlordId=landlordId;
        this.landlordName=landlordName;
        this.landlordPhone=landlordPhone;
        this.landlordEmail=landlordEmail;
    }

    public housesDTO(long Id, String address,String description,double pricePerNight,long landlordId){
        this.id=Id;
        this.address=address;
        this.description=description;
        this.pricePerNight=pricePerNight;
        this.landlordId=landlordId;
    }

}
