package com.example.IndividualTrackProject.Controller.Booking;

import com.example.IndividualTrackProject.Controller.BookingController;
import com.example.IndividualTrackProject.Model.Booking;
import com.example.IndividualTrackProject.Model.DTOs.bookingDTO.bookingsDTO;
import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class BookingControllerTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetBookingTest(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<Booking> bookingResult=bookingController.getBooking(1L);

        Assertions.assertEquals(HttpStatus.OK,bookingResult.getStatusCode());
    }

    @Test
    void GetBookingFailScenarioTest(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<Booking> bookingResult=bookingController.getBooking(2L);

        Assertions.assertEquals(HttpStatus.NOT_FOUND,bookingResult.getStatusCode());
    }

    @Test
    void DeleteBookingSuccessful(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<Booking> bookingResult=bookingController.deleteBooking(1L);

        Assertions.assertEquals(HttpStatus.OK, bookingResult.getStatusCode());
    }

    @Test
    void DeleteBookingFailed(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<Booking> bookingResult=bookingController.deleteBooking(2L);

        Assertions.assertEquals(HttpStatus.OK,bookingResult.getStatusCode());
    }

    @Test
    void GetAllBookingsSuccessfullyTest(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<List<bookingsDTO>> bookingResult=bookingController.getAllBookings();

        Assertions.assertEquals(HttpStatus.OK,bookingResult.getStatusCode());
    }

    @Test
    void CreateNewBookingSuccessfullyTest(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<Booking> bookingResult=bookingController.createBooking(new bookingsDTO(1L,new House(),new Landlord(),new User(),
                null,null,null,232.0,0,0,null));

        Assertions.assertEquals(HttpStatus.OK,bookingResult.getStatusCode());
    }

    @Test
    void GetAllBookingsPerUserSuccessfullyTest(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<List<Booking>> bookingResult=bookingController.getBookingsPerUser(1L);

        Assertions.assertEquals(HttpStatus.OK,bookingResult.getStatusCode());
    }

    @Test
    void GetAllEndedBookingsSuccessfullyTest(){
        BookingController bookingController=new BookingController(new BookingServiceMock());

        ResponseEntity<List<Booking>> bookingResult=bookingController.getBookingsPerUserEnded(1L);

        Assertions.assertEquals(HttpStatus.OK,bookingResult.getStatusCode());
    }




}
