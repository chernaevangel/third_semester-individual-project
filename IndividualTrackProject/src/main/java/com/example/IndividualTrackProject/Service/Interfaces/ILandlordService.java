package com.example.IndividualTrackProject.Service.Interfaces;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.Request.LandlordCreateRequest;

import java.util.List;

public interface ILandlordService {
    Boolean addNewLandlord(LandlordCreateRequest landlordCreateRequest);
    Boolean updateLandlordInfo(Landlord landlord);
    Boolean deleteLandlord(Landlord landlord);
    List<Landlord> getAllLandlords();
    Landlord getLandlord(Long id);
    Landlord getLandlordByEmailAndCode(String verificationCode,String email);
    String getContactInformationForLandlord(Landlord landlord);
    List<House> getAllHousesPerLandlord(Landlord landlord);
}
