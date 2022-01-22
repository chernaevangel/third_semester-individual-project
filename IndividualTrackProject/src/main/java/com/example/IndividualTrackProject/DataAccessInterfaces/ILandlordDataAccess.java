package com.example.IndividualTrackProject.DataAccessInterfaces;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;

import java.util.List;

public interface ILandlordDataAccess {

     Boolean addNewLandlord(Landlord landlord);
     Boolean updateLandlordInfo(Landlord landlord);
     Boolean deleteLandlord(Landlord landlord);
     List<Landlord> getAllLandlords();
     Landlord getLandlord(Long id);

     String getContactInformationForLandlord(Landlord landlord);
    List<House> getAllHousesPerLandlord(Landlord landlord);
}
