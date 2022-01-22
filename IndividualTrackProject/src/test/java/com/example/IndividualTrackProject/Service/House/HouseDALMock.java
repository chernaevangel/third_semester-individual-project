package com.example.IndividualTrackProject.Service.House;

import com.example.IndividualTrackProject.DataAccessInterfaces.IHouseDataAccess;
import com.example.IndividualTrackProject.Model.House;

import java.util.ArrayList;
import java.util.List;

public class HouseDALMock implements IHouseDataAccess {

    List<House> houseList=new ArrayList<>();

    @Override
    public List<House> getHouses() {
        houseList.add(new House());
        return houseList;
    }

    @Override
    public House getHouse(long houseId) {
        if(houseId==1){
            return new House();
        }
        else{
            return null;
        }

    }

    @Override
    public Boolean deleteHouse(long houseId) {
        if(houseId==1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean addHouse(House house) {
        if(house!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean reserveHouse(Long id) {
        return null;
    }

    @Override
    public Boolean updateHouse(House house) {
        if(house!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean leaveHouse(Long id) {
        return null;
    }
}
