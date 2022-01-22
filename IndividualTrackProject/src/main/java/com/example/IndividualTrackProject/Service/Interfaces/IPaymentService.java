package com.example.IndividualTrackProject.Service.Interfaces;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Payment;
import com.example.IndividualTrackProject.Model.User;

import java.util.List;

public interface IPaymentService {
    Boolean createPayment(User user, House house);
    List<Payment> getAllPayments();
    Payment getPayment(Payment payment);
}
