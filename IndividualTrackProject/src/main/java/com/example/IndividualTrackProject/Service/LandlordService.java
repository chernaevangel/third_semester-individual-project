package com.example.IndividualTrackProject.Service;

import com.example.IndividualTrackProject.DataAccessInterfaces.ILandlordDataAccess;
import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.Request.LandlordCreateRequest;
import com.example.IndividualTrackProject.Service.Interfaces.ILandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordService implements ILandlordService {

    ILandlordDataAccess landlordDataAccess;

    @Autowired
    public LandlordService(ILandlordDataAccess landlordDataAccess){
        this.landlordDataAccess=landlordDataAccess;
    }

    @Override
    public Boolean addNewLandlord(LandlordCreateRequest landlordCreateRequest) {
        Landlord landlord=new Landlord();
        landlord.setName(landlordCreateRequest.getName());
        landlord.setEmail(landlordCreateRequest.getEmail());
        landlord.setMobilePhone(landlordCreateRequest.getMobilePhone());
        landlord.setVerificationCode(landlordCreateRequest.getVerificationCode());
        return landlordDataAccess.addNewLandlord(landlord);
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
        return landlordDataAccess.getAllLandlords();
    }

    @Override
    public Landlord getLandlordByEmailAndCode(String verificationCode,String email){
        List<Landlord> landlordList=getAllLandlords();
        for(Landlord landlord:landlordList){
           if(landlord.getVerificationCode().equals(verificationCode) && landlord.getEmail().equals(email)){
               return landlord;
           }

       }
        return null;
    }

    @Override
    public Landlord getLandlord(Long id) {
        return landlordDataAccess.getLandlord(id);
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
