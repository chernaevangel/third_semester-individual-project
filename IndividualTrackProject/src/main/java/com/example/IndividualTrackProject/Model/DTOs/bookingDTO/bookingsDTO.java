package com.example.IndividualTrackProject.Model.DTOs.bookingDTO;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.User;
import lombok.Data;

import java.util.Date;

@Data
public class
bookingsDTO {

    private long id;
    private House house;
    private Landlord landlord;
    private User user;
    private Date accommodationDate;
    private Date leavingDate;
    private String reservationCode;
    private double pricePerNight;
    private double wholePrice;
    private int bookingDays;
    private String feedbackFromCustomer;


    public bookingsDTO(long id,House house,Landlord landlord,User user,
                       Date accommodationDate,Date leavingDate,String reservationCode,
                       double pricePerNight,double wholePrice,int bookingDays,String feedbackFromCustomer){
        this.id=id;
        this.house=house;
        this.landlord=landlord;
        this.user=user;
        this.accommodationDate=accommodationDate;
        this.leavingDate=leavingDate;
        this.reservationCode=reservationCode;
        this.pricePerNight=pricePerNight;
        this.wholePrice=wholePrice;
        this.bookingDays=bookingDays;
        this.feedbackFromCustomer=feedbackFromCustomer;
    }
}
