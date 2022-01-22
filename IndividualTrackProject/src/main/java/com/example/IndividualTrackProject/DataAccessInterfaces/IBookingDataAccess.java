package com.example.IndividualTrackProject.DataAccessInterfaces;

import com.example.IndividualTrackProject.Model.*;

import java.util.List;

public interface IBookingDataAccess {
    Boolean createBooking(Booking booking);
    Boolean updateBooking(Booking booking);
    Boolean deleteBooking(Booking booking);
    Booking getBooking(Long id);
    List<Booking> getAllBookings();
    Boolean giveFeedbackForBooking(Feedback feedback);
    Boolean accommodateUser(User user, House house);
    Boolean userIsOut(User user, House house);
    Boolean endReservation(Long id);
}
