package com.example.IndividualTrackProject.Repository.Interfaces;

import com.example.IndividualTrackProject.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHouseRepo extends JpaRepository<House, Long> {
}
