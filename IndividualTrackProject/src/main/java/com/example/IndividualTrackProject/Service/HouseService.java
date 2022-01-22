package com.example.IndividualTrackProject.Service;


import com.example.IndividualTrackProject.DataAccessInterfaces.IHouseDataAccess;
import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Service.Interfaces.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HouseService implements IHouseService {


    IHouseDataAccess houseDataAccess;

    @Autowired
    public HouseService(IHouseDataAccess houseDataAccess){this.houseDataAccess=houseDataAccess;}

    @Override
    public List<House> getHouses() {
        List<House> availableHouses=new ArrayList<>();
        for (House house:houseDataAccess.getHouses()){
            if(house.isAccessible()==true){
                availableHouses.add(house);
            }
        }
        return availableHouses;
    }

    @Override
    public List<House> getHousesPerLandlord(Long id){
        List<House> getHousePerLandlordList=new ArrayList<>();
        for (House house:getHouses()){
            if(house.getLandlordId().equals(id)){
                getHousePerLandlordList.add(house);
            }
        }
        return getHousePerLandlordList;
    }

    @Override
    public List<House> getHousesBookedPerLandlord(Long id){
        List<House> getBookedHousePerLandlordList=new ArrayList<>();
        for(House house:houseDataAccess.getHouses()){
            if(house.isAccessible()==false && house.getLandlordId().equals(id)){
                getBookedHousePerLandlordList.add(house);
            }
        }
        return getBookedHousePerLandlordList;
    }

    @Override
    public House getHouse(long houseId) {
        return houseDataAccess.getHouse(houseId);
    }

    @Override
    public List<House> getHousesFilteredByPrice(double price){
        List<House> housesByPrice=new ArrayList<>();
        for (House house:getHouses()){
            if (house.getPricePerNight()<=price){
                housesByPrice.add(house);
            }
        }
        return housesByPrice;
    }

    @Override
    public Boolean reserveHouse(Long id){
        return houseDataAccess.reserveHouse(id);
    }

    @Override
    public Boolean leaveHouse(Long id){
        return houseDataAccess.leaveHouse(id);
    }

    @Override
    public Boolean deleteHouse(long houseId) {
        return houseDataAccess.deleteHouse(houseId);
    }
    @Override
    public Boolean addHouse(House house) {
        return houseDataAccess.addHouse(house);
    }
    @Override
    public Boolean updateHouse(House house) { return houseDataAccess.updateHouse(house); }


}
