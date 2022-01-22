package com.example.IndividualTrackProject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="landlord")
@AllArgsConstructor
@NoArgsConstructor
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String mobilePhone;
    private String verificationCode;

    public Landlord(String name,String email,String mobilePhone,String verificationCode){
        this.name=name;
        this.email=email;
        this.mobilePhone=mobilePhone;
        this.verificationCode=verificationCode;
    }

}
