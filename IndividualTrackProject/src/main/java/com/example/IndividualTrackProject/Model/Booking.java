package com.example.IndividualTrackProject.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private House house;

    @OneToOne
    private Landlord landlord;

    @OneToOne
    private User user;
    private Date accommodationDate;
    private Date leavingDate;
    private String reservationCode;
    private double pricePerNight;
    private double wholePrice;
    private int bookingDays;
    private String feedbackFromCustomer;
    //private String generatedBookingCode;

    private boolean reservationPaid=false;
    private boolean isAccommodated=false;
    private boolean customerLeft=false;

}
