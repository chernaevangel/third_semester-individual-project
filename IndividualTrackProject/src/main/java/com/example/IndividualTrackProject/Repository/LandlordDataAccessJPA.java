package com.example.IndividualTrackProject.Repository;

import com.example.IndividualTrackProject.DataAccessInterfaces.ILandlordDataAccess;
import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Repository.Interfaces.ILandlordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LandlordDataAccessJPA implements ILandlordDataAccess {

    @Autowired
    ILandlordRepo landlordRepo;

    @Override
    public Boolean addNewLandlord(Landlord landlord) {
       landlordRepo.save(landlord);

            return true;


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
        return landlordRepo.findAll();
    }

    @Override
    public Landlord getLandlord(Long id) {
        return landlordRepo.findById(id).orElse(null);
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
