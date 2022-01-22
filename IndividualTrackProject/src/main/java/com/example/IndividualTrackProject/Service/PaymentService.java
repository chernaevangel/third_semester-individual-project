package com.example.IndividualTrackProject.Service;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Payment;
import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Service.Interfaces.IPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PaymentService implements IPaymentService {


    //private final IPaymentDataAccess paymentDataAccess;

    @Override
    public Boolean createPayment(User user, House house) {
        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        return null;
    }

    @Override
    public Payment getPayment(Payment payment) {
        return null;
    }
}
