package com.example.IndividualTrackProject.Service.Booking;

import com.example.IndividualTrackProject.DataAccessInterfaces.IBookingDataAccess;
import com.example.IndividualTrackProject.Model.*;

import java.util.ArrayList;
import java.util.List;

public class BookingDALMock implements IBookingDataAccess {

    List<Booking> bookingList=new ArrayList<>();


    @Override
    public Booking getBooking(Long id) {
        if(id==1){
            return new Booking();
        }
        else {
            return null;
        }
    }

    @Override
    public List<Booking> getAllBookings() {
        bookingList.add(new Booking());
        return bookingList;
    }

    @Override
    public Boolean updateBooking(Booking booking) {
        if(booking!=null){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public Boolean deleteBooking(Booking booking) {
        if(booking!=null)
        {
            return true;
        }
        else {
            return false;
        }
    }




    @Override
    public Boolean createBooking(Booking booking) {
        if(booking!=null)
        {
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public Boolean giveFeedbackForBooking(Feedback feedback) {
        if(feedback!=null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean accommodateUser(User user, House house) {
        return null;
    }

    @Override
    public Boolean userIsOut(User user, House house) {
        return null;
    }

    @Override
    public Boolean endReservation(Long id) {
        if(id==1){
            return true;
        }
        else {
            return false;
        }
    }
}
