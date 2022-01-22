package com.example.IndividualTrackProject.Service.Booking;

import com.example.IndividualTrackProject.Model.Booking;
import com.example.IndividualTrackProject.Service.BookingService;
import com.example.IndividualTrackProject.Service.User.UserDALMock;
import com.example.IndividualTrackProject.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookingServiceTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetBookingSuccessfullyTest(){
        BookingService bookingService=new BookingService(new BookingDALMock(),new UserService(new UserDALMock(),new BCryptPasswordEncoder()));

        Booking resultBooking=bookingService.getBooking(1L);

        assertThat(resultBooking).isNotNull();
    }

    @Test
    void GetBookingUnsuccessfullyTest(){
        BookingService bookingService=new BookingService(new BookingDALMock(),new UserService(new UserDALMock(),new BCryptPasswordEncoder()));

        Booking resultBooking=bookingService.getBooking(2L);

        assertThat(resultBooking).isNull();
    }

    @Test
    void GetAllBookingsSuccessfullyTest(){
        BookingService bookingService=new BookingService(new BookingDALMock(),new UserService(new UserDALMock(),new BCryptPasswordEncoder()));

        List<Booking> bookings=bookingService.getAllBookings();

        assertThat(bookings).isNotNull();
    }





    @Test
    void CreateBookingSuccessfullyTest(){
        BookingService bookingService=new BookingService(new BookingDALMock(),new UserService(new UserDALMock(),new BCryptPasswordEncoder()));

        Boolean bookings=bookingService.createBooking(new Booking());

        assertThat(bookings).isTrue();
    }

    @Test
    void CreateBookingUnsuccessfullyTest(){
        BookingService bookingService=new BookingService(new BookingDALMock(),new UserService(new UserDALMock(),new BCryptPasswordEncoder()));

        Boolean bookings=bookingService.createBooking(null);

        assertThat(bookings).isFalse();
    }





    @Test
    void EndBookingSuccessfullyTest(){
        BookingService bookingService=new BookingService(new BookingDALMock(),new UserService(new UserDALMock(),new BCryptPasswordEncoder()));

        Boolean bookings=bookingService.endBooking(1L);

        assertThat(bookings).isTrue();
    }

    @Test
    void EndBookingUnsuccessfullyTest(){
        BookingService bookingService=new BookingService(new BookingDALMock(),new UserService(new UserDALMock(),new BCryptPasswordEncoder()));

        Boolean bookings=bookingService.endBooking(2L);

        assertThat(bookings).isFalse();
    }


}
