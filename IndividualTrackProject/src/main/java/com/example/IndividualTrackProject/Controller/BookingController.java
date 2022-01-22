package com.example.IndividualTrackProject.Controller;

import com.example.IndividualTrackProject.Model.Booking;
import com.example.IndividualTrackProject.Model.DTOs.bookingDTO.bookingsDTO;
import com.example.IndividualTrackProject.Service.Interfaces.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    public BookingController(IBookingService bookingService){
        this.bookingService=bookingService;
    }


    @CrossOrigin("http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<bookingsDTO>> getAllBookings(){

        List<Booking> bookings=bookingService.getAllBookings();
        List<bookingsDTO> bookingsDTOList=new ArrayList<>();
        for (Booking booking:bookings){
            bookingsDTOList.add(new bookingsDTO(booking.getId(),booking.getHouse(),booking.getLandlord(),
                    booking.getUser(),booking.getAccommodationDate(),
                    booking.getLeavingDate(),booking.getReservationCode(),
                    booking.getPricePerNight(),booking.getWholePrice(),
                    booking.getBookingDays(),booking.getFeedbackFromCustomer()));
        }

        if (!bookingsDTOList.isEmpty()){
            return ResponseEntity.ok().body(bookingsDTOList);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/account")
    public ResponseEntity<List<Booking>> getBookingsPerUser(@RequestParam (value = "id") Long id){
        List<Booking> bookings=bookingService.getBookingsPerUser(id);
        if(bookings!=null){
            return ResponseEntity.ok().body(bookings);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/account/ended")
    public ResponseEntity<List<Booking>> getBookingsPerUserEnded(@RequestParam (value = "id") Long id){
        List<Booking> bookings=bookingService.getEndedBookingsPerUser(id);
        if(bookings!=null){
            return ResponseEntity.ok().body(bookings);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    //Get booking
    @CrossOrigin("http://localhost:3000")
    @GetMapping("/booking/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable(value = "id") Long id){
        Booking booking=bookingService.getBooking(id);
        if(booking!=null){
            return ResponseEntity.ok().body(booking);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete booking
    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteBooking(@RequestBody Long id){
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().build();

    }




 //Create booking

    @CrossOrigin("http://localhost:3000")
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody bookingsDTO bookingsDTO){
        Booking booking=new Booking();
        booking.setId(bookingsDTO.getId());
        booking.setHouse(bookingsDTO.getHouse());
        booking.setLandlord(bookingsDTO.getLandlord());
        booking.setUser(bookingsDTO.getUser());
        booking.setAccommodationDate(bookingsDTO.getAccommodationDate());
        booking.setLeavingDate(bookingsDTO.getLeavingDate());
        booking.setReservationCode(bookingsDTO.getReservationCode());
        booking.setPricePerNight(bookingsDTO.getPricePerNight());
        booking.setWholePrice(bookingsDTO.getWholePrice());
        booking.setBookingDays(bookingsDTO.getBookingDays());
        booking.setFeedbackFromCustomer(bookingsDTO.getFeedbackFromCustomer());
        bookingService.createBooking(booking);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("{id}")
    public ResponseEntity<Booking> endBooking(@PathVariable(value = "id") Long id){
        if (bookingService.endBooking(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity("Please provide a valid id. ", HttpStatus.NOT_FOUND);
        }
    }








}
