package com.example.IndividualTrackProject.Service.Landlord;

import com.example.IndividualTrackProject.DataAccessInterfaces.ILandlordDataAccess;
import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;

import java.util.ArrayList;
import java.util.List;

public class LandlordDALMock implements ILandlordDataAccess {

    List<Landlord> landlordList=new ArrayList<>();

    @Override
    public Boolean addNewLandlord(Landlord landlord) {
        if(landlord!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean updateLandlordInfo(Landlord landlord) {
        if(landlord!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean deleteLandlord(Landlord landlord) {
        if(landlord!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Landlord> getAllLandlords() {
        landlordList.add(new Landlord());
        return landlordList;
    }

    @Override
    public Landlord getLandlord(Long id) {
        landlordList.add(new Landlord(1L,"peter","peter@gmail.com","+2322333","EIN99"));
        for (Landlord landlord:landlordList){
            if(landlord.getId()==id){
                return landlord;
            }
        }
        return null;
    }

    @Override
    public String getContactInformationForLandlord(Landlord landlord) {
        return null;
    }

    @Override
    public List<House> getAllHousesPerLandlord(Landlord landlord) {
        return null;
    }
}
