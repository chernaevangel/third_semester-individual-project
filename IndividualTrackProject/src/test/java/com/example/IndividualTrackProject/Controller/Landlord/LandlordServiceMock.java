package com.example.IndividualTrackProject.Controller.Landlord;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.Request.LandlordCreateRequest;
import com.example.IndividualTrackProject.Service.Interfaces.ILandlordService;

import java.util.ArrayList;
import java.util.List;

public class LandlordServiceMock implements ILandlordService {



    List<Landlord> landlordList =new ArrayList<>();

    @Override
    public Boolean addNewLandlord(LandlordCreateRequest landlordCreateRequest) {
        if(landlordCreateRequest!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean updateLandlordInfo(Landlord landlord) {
        return null;
    }

    @Override
    public Boolean deleteLandlord(Landlord landlord) {
        return null;
    }

    @Override
    public List<Landlord> getAllLandlords() {

        landlordList.add(new Landlord(1L,"spas","spas@gmail.com","+83625252","EIN98"));
        landlordList.add(new Landlord(2L,"dan","dan@gmail.com","+84625252","EIN78"));
        return landlordList;
    }

    @Override
    public Landlord getLandlord(Long id) {
        if(id==1){
            return new Landlord(1L,"spas","spas@gmail.com","+83625252","EIN98");
        }
        else {
            return null;
        }
    }

    @Override
    public Landlord getLandlordByEmailAndCode(String verificationCode, String email) {

        landlordList.add(new Landlord(1L,"spas","spas@gmail.com","+83625252","EIN99"));
        for (Landlord landlord:landlordList){
            if(landlord.getEmail()==email && landlord.getVerificationCode()==verificationCode){
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
