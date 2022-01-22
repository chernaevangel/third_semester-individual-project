package com.example.IndividualTrackProject.Repository;

import com.example.IndividualTrackProject.DataAccessInterfaces.IHouseDataAccess;
import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Repository.Interfaces.IHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDataAccessJPA implements IHouseDataAccess {

    @Autowired
    IHouseRepo houseRepo;


    @Override
    public List<House> getHouses() {
        return houseRepo.findAll();
    }

    @Override
    public House getHouse(long houseId) {
        return houseRepo.findById(houseId).orElse(null);
    }

    @Override
    public Boolean deleteHouse(long houseId) {
        House house=getHouse(houseId);
        if (house==null){
            return false;
        }else{
            houseRepo.deleteById(houseId);
            return true;
        }

    }

    @Override
    public Boolean addHouse(House house) {
      houseRepo.save(house);

            return true;


    }

    @Override
    public Boolean reserveHouse(Long id){
        House house=this.getHouse(id);
        if(house!=null){
            house.setAccessible(false);
            houseRepo.save(house);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean leaveHouse(Long id){
        House house=this.getHouse(id);
        if (house!=null){
            house.setAccessible(true);
            houseRepo.save(house);
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public Boolean updateHouse(House house) {
        House houseFromDB=this.getHouse(house.getId());
        if (houseFromDB!=null){
            //houseFromDB.setLandlord(house.getLandlord());
            houseFromDB.setAddress(house.getAddress());
            houseFromDB.setDescription(house.getDescription());
            houseFromDB.setPricePerNight(house.getPricePerNight());
            houseRepo.save(houseFromDB);
            return true;
        }
        else {
            return false;
        }
    }
}
