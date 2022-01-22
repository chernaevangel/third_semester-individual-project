package com.example.IndividualTrackProject.Controller.Booking;

import com.example.IndividualTrackProject.Model.*;
import com.example.IndividualTrackProject.Service.Interfaces.IBookingService;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceMock implements IBookingService {

    List<Booking> bookingList=new ArrayList<>();

    @Override
    public Boolean createBooking(Booking booking) {
        if(bookingList.add(booking)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean updateBooking(Booking booking) {
        return null;
    }

    @Override
    public Boolean deleteBooking(Long id) {
        if(id==1){
            return true;
        }
        return false;
    }

    @Override
    public Booking getBooking(Long id) {
        if(id==1){
            return new Booking();
        }
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        bookingList.add(new Booking());
        bookingList.add(new Booking());
        return bookingList;
    }

    @Override
    public List<Booking> getBookingsPerUser(Long userId) {
        List<Booking> bookingList1=new ArrayList<>();
        User user=new User(userId,"sasho@gmail.com","sash123","sasho12");
        bookingList.add(new Booking(1L,new House(),new Landlord(),new User(1L,"sasho@gmail.com","sash123","sasho12"),
                null,null,null,232.0,0.0,0,null,false,false,false));
        for(Booking booking: bookingList){
            if(booking.getUser().equals(user)){
                bookingList1.add(booking);

            }
        }
        return bookingList1;
    }

    @Override
    public List<Booking> getAllNotEndedBookings() {
        return null;
    }

    @Override
    public List<Booking> getAllEndedBookings() {
        return null;
    }

    @Override
    public List<Booking> getEndedBookingsPerUser(Long userId) {
        List<Booking> bookingList1=new ArrayList<>();
        User user=new User(userId,"sasho@gmail.com","sash123","sasho12");
        bookingList.add(new Booking(1L,new House(),new Landlord(),new User(1L,"sasho@gmail.com","sash123","sasho12"),
                null,null,null,232.0,0.0,0,null,false,false,true));
        for(Booking booking:bookingList){
            if(booking.isCustomerLeft()==true && booking.getUser().equals(userId)){
                bookingList1.add(booking);

            }
        }
        return bookingList1;
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

    @Override
    public Boolean endBooking(Long id) {
        return null;
    }
}
