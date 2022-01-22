package com.example.IndividualTrackProject.Repository;

import com.example.IndividualTrackProject.DataAccessInterfaces.IBookingDataAccess;
import com.example.IndividualTrackProject.Model.*;
import com.example.IndividualTrackProject.Repository.Interfaces.IBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDataAccessJPA implements IBookingDataAccess {

    @Autowired
    IBookingRepo bookRepo;

    //
    @Override
    public Booking getBooking(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    //
    @Override
    public List<Booking> getAllBookings() {
        return bookRepo.findAll();
    }

    @Override
    public Boolean createBooking(Booking booking) {
        bookRepo.save(booking);
        return true;
    }

    @Override
    public Boolean updateBooking(Booking booking) {
        return null;
    }

    @Override
    public Boolean deleteBooking(Booking booking) {
        return null;
    }

    @Override
    public Boolean endReservation(Long id){
        Booking booking=this.getBooking(id);
        if(booking!=null){
            booking.setCustomerLeft(true);
            bookRepo.save(booking);
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public Boolean giveFeedbackForBooking(Feedback feedback) {
        return null;
    }

    @Override
    public Boolean accommodateUser(User user, House house) {
        return null;
    }

    @Override
    public Boolean userIsOut(User user, House house) {
        return null;
    }
}
