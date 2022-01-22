package com.example.IndividualTrackProject.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="payment")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String IBAN;
    private Date date;
    private double wholeReservationPrice;
    private Boolean paymentComplete=false;

    /*@OneToOne
    private User user;
    @OneToOne
    private House house;
    @OneToOne
    private Landlord landlord;*/
}
