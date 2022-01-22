package com.example.IndividualTrackProject.DataAccessInterfaces;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Payment;
import com.example.IndividualTrackProject.Model.User;

import java.util.List;

public interface IPaymentDataAccess {
    Boolean createPayment(User user, House house);
    List<Payment> getAllPayments();
    Payment getPayment(Payment payment);
}
