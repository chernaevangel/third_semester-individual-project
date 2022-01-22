package com.example.IndividualTrackProject.Controller;


import com.example.IndividualTrackProject.Model.DTOs.houseDTO.housesDTO;
import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Service.Interfaces.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/houses")
public class HouseController {
    // TODO: 01/10/2021 the house controller and some tests

    @Autowired
    private IHouseService houseService;



    public HouseController(IHouseService houseService){this.houseService=houseService;}

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<housesDTO>> getAllHouses(){

        List<House> houses=houseService.getHouses();
        List<housesDTO> housesDTOList=new ArrayList<>();

        for(House house: houses){
            housesDTOList.add(new housesDTO(house.getId(),house.getAddress(),house.getDescription(),house.isAccessible(),house.getPricePerNight(),house.getLandlordId(),house.getLandlordName(),house.getLandlordPhone(),house.getLandlordEmail()));
        }

        if (!housesDTOList.isEmpty()){
            return ResponseEntity.ok().body(housesDTOList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/houseLandlord/{id}")
    public ResponseEntity<List<House>> getAllHousesPerLandlord(@PathVariable(value = "id") Long id){

        List<House> houses=houseService.getHousesPerLandlord(id);

        if (houses!=null){
            return ResponseEntity.ok().body(houses);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/booked/houseLandlord/{id}")
    public ResponseEntity<List<House>> getAllBookedHousesPerLandlord(@PathVariable(value = "id") Long id){

        List<House> houses=houseService.getHousesBookedPerLandlord(id);

        if (houses!=null){
            return ResponseEntity.ok().body(houses);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

   @CrossOrigin("http://localhost:3000")
    @GetMapping("/byPrice")
    public ResponseEntity<List<House>> getHousesByPrice(@RequestParam(value = "price") Double price){
        List<House> houses=houseService.getHousesFilteredByPrice(price);

        if (houses!=null){
            return ResponseEntity.ok().body(houses);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/house/{id}")
    public ResponseEntity<House> getHouse(@PathVariable(value = "id") Long id) {

        House house = houseService.getHouse(id);

        if(house != null) {
            return ResponseEntity.ok().body(house);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("{id}")
    public ResponseEntity deleteHouse(@PathVariable int id) {
        houseService.deleteHouse(id);
        return ResponseEntity.ok().build();

    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/newHouse")
    public ResponseEntity<House> createHouse(@RequestBody House house) {
        houseService.addHouse(house);
        return ResponseEntity.ok().build();

    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping()
    public ResponseEntity<House> updateHouse(@RequestBody House house){
        if (houseService.updateHouse(house)){
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity("Please provide a valid id. ", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("{id}")
    public ResponseEntity<House> reserveHouse(@PathVariable(value = "id") Long id){
        if (houseService.reserveHouse(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity("Please provide a valid id. ", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/leave/{id}")
    public ResponseEntity<House> leaveHouse(@PathVariable(value = "id") Long id){
        if (houseService.leaveHouse(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity("Please provide a valid id. ", HttpStatus.NOT_FOUND);
        }
    }

}
