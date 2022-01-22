package com.example.IndividualTrackProject.DataAccessInterfaces;

import com.example.IndividualTrackProject.Model.House;

import java.util.List;

public interface IHouseDataAccess {
     //hey
     List<House> getHouses() ;
     House getHouse(long houseId);
     Boolean deleteHouse(long houseId);
     Boolean addHouse(House house);
     Boolean reserveHouse(Long id);
     Boolean updateHouse(House house);
     Boolean leaveHouse(Long id);

}
