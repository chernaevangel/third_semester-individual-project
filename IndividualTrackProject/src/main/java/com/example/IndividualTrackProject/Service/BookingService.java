package com.example.IndividualTrackProject.Service;

import com.example.IndividualTrackProject.DataAccessInterfaces.IBookingDataAccess;
import com.example.IndividualTrackProject.Model.*;
import com.example.IndividualTrackProject.Service.Interfaces.IBookingService;
import com.example.IndividualTrackProject.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookingService implements IBookingService {

    IBookingDataAccess bookingDataAccess;
    private final IUserService userService;

    //should consider adding user info for most of the methods, because we crate reservations from users

    @Autowired
    public BookingService(IBookingDataAccess bookingDataAccess,IUserService userService){
        this.bookingDataAccess=bookingDataAccess;
        this.userService=userService;
    }


    @Override
    public Booking getBooking(Long id) {
        return bookingDataAccess.getBooking(id);
    }


    @Override
    public List<Booking> getBookingsPerUser(Long userId){
        List<Booking> bookingsPerUser=new ArrayList<Booking>();
       for(Booking booking:getAllNotEndedBookings()){
               if(booking.getUser()==userService.getUser(userId)){
                   bookingsPerUser.add(booking);

               }
        }
           return bookingsPerUser;
    }

    @Override
    public List<Booking> getEndedBookingsPerUser(Long userId){
        List<Booking> bookingsEndedPerUser=new ArrayList<Booking>();
        for(Booking booking:getAllEndedBookings()){
            if(booking.getUser()==userService.getUser(userId)){
                bookingsEndedPerUser.add(booking);

            }
        }
        return bookingsEndedPerUser;
    }

   @Override
    public  List<Booking> getAllNotEndedBookings(){
       List<Booking> bookingsNotEnded=new ArrayList<Booking>();
        for (Booking booking:getAllBookings()){
            if (booking.isCustomerLeft()==false){
                bookingsNotEnded.add(booking);
            }
        }
        return bookingsNotEnded;
    }

    @Override
    public  List<Booking> getAllEndedBookings(){
        List<Booking> bookingsEnded=new ArrayList<Booking>();
        for (Booking booking:getAllBookings()){
            if (booking.isCustomerLeft()==true){
                bookingsEnded.add(booking);
            }
        }
        return bookingsEnded;
    }

    //
    @Override
    public List<Booking> getAllBookings() {
        return bookingDataAccess.getAllBookings();
    }


    @Override
    public Boolean createBooking(Booking booking)
    {
        return bookingDataAccess.createBooking(booking);
    }

    @Override
    public Boolean endBooking(Long id){
        return bookingDataAccess.endReservation(id);
    }

    @Override
    public Boolean updateBooking(Booking booking) {
        return null;
    }

    @Override
    public Boolean deleteBooking(Long bookingId ) {
        return null;
    }


    @Override
    public Boolean giveFeedbackForBooking(Feedback feedback) {
        return null;
    }

    @Override
    public Boolean accommodateUser(User user, House house) {
        return null;
    }

    //when the user went out of the property after his stay
    @Override
    public Boolean userIsOut(User user, House house) {
        return null;
    }
}
