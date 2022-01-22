package com.example.IndividualTrackProject.Service.Interfaces;

import com.example.IndividualTrackProject.Model.House;

import java.util.List;

public interface IHouseService {
     List<House> getHouses();
     House getHouse(long houseId);
     Boolean deleteHouse(long houseId);
     List<House> getHousesFilteredByPrice(double price);
     public List<House> getHousesPerLandlord(Long id);
     List<House> getHousesBookedPerLandlord(Long id);
     Boolean reserveHouse(Long id);
     Boolean addHouse(House house);
     Boolean updateHouse(House house);
     Boolean leaveHouse(Long id);
}
