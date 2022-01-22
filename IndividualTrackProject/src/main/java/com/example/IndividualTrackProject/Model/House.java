package com.example.IndividualTrackProject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String address;
    private String description;
    private boolean accessible;
    private double pricePerNight;



   private Long landlordId;
   private String landlordName;
   private String landlordPhone;
   private String landlordEmail;

   //@OneToOne
   //private Booking currentBooking;



}
