package com.example.IndividualTrackProject.Controller.House;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Service.Interfaces.IHouseService;

import java.util.ArrayList;
import java.util.List;

public class HouseServiceMock implements IHouseService {

    List<House> houseList=new ArrayList<>();

    @Override
    public List<House> getHouses() {
        houseList.add(new House(1,"ss","dd",true,230,1L,"stefan","+2322211","strahil@gmail.com"));
        return houseList;
    }

    @Override
    public House getHouse(long houseId) {
        if(houseId==1){
            return new House();
        }
        return null;
    }

    @Override
    public Boolean deleteHouse(long houseId) {
        if(houseId==1){
            return true;
        }
        return false;
    }

    @Override
    public List<House> getHousesFilteredByPrice(double price) {
       List<House> houses=new ArrayList<>();
        houseList.add(new House(1,"ss","dd",true,230,1L,"stefan","+2322211","strahil@gmail.com"));
        for (House house: houseList){
            if(house.getPricePerNight()==price){
                houses.add(house);
                return houses;
            }
        }
        return null;
    }

    @Override
    public List<House> getHousesPerLandlord(Long id) {
        List<House> houses=new ArrayList<>();
        houseList.add(new House(1,"ss","dd",true,230,1L,"stefan","+2322211","strahil@gmail.com"));
       for(House house:houseList){
           if(house.getLandlordId()==id){
               houses.add(house);
           }
       }

        return houses;
    }

    @Override
    public List<House> getHousesBookedPerLandlord(Long id) {
        List<House> houses=new ArrayList<>();
        houseList.add(new House(1,"ss","dd",false,230,1L,"stefan","+2322211","strahil@gmail.com"));
        for(House house:houseList){
            if(house.getLandlordId()==id && house.isAccessible()==false){
                houses.add(house);
            }
        }

        return houses;
    }

    @Override
    public Boolean reserveHouse(Long id) {

        houseList.add(new House(1,"ss","dd",true,230,1L,"stefan","+2322211","strahil@gmail.com"));
        for(House house:houseList){
            if(house.getId()==1 && house.isAccessible()==true){
                house.setAccessible(false);

            }
        }
        return true;
    }

    @Override
    public Boolean addHouse(House house) {
        if(houseList.add(house)){
            return true;
        }
        else {
            return false;
        }
    }

   @Override
    public Boolean updateHouse(House house) {
       House house1=new House(1,"ss","dd",true,230,1L,"stefan","+2322211","strahil@gmail.com");
       if(house!=house1){
           return true;
       }
        else {
           // return false;
       }
       return false;
    }

    @Override
    public Boolean leaveHouse(Long id) {
        houseList.add(new House(1,"ss","dd",false,230,1L,"stefan","+2322211","strahil@gmail.com"));
        for(House house:houseList){
            if(house.getId()==1 && house.isAccessible()==false){
                house.setAccessible(true);

            }
        }
        return true;
    }
}
