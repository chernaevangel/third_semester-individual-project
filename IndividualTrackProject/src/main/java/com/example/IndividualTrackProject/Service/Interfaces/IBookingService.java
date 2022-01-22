package com.example.IndividualTrackProject.Service.Interfaces;

import com.example.IndividualTrackProject.Model.*;

import java.util.List;

public interface IBookingService {
    Boolean createBooking(Booking booking);
    Boolean updateBooking(Booking booking);
    Boolean deleteBooking(Long bookingId );
    Booking getBooking(Long id);
    List<Booking> getAllBookings();
    List<Booking> getBookingsPerUser(Long userId);
    List<Booking> getAllNotEndedBookings();
    List<Booking> getAllEndedBookings();
    List<Booking> getEndedBookingsPerUser(Long userId);
    Boolean giveFeedbackForBooking(Feedback feedback);
    Boolean accommodateUser(User user, House house);
    Boolean userIsOut(User user,House house);
    Boolean endBooking(Long id);
}
