package com.example.IndividualTrackProject.Repository.Interfaces;

import com.example.IndividualTrackProject.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepo extends JpaRepository<Booking, Long> {
}
