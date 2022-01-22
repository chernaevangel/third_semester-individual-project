package com.example.IndividualTrackProject.Controller.House;

import com.example.IndividualTrackProject.Controller.HouseController;
import com.example.IndividualTrackProject.Model.DTOs.houseDTO.housesDTO;
import com.example.IndividualTrackProject.Model.House;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class HouseControllerTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetHouseTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<House> houseResult=houseController.getHouse(1L);

        Assertions.assertEquals(HttpStatus.OK,houseResult.getStatusCode());
    }

    @Test
    void GetHouseFailScenarioTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<House> houseResult=houseController.getHouse(2L);

        Assertions.assertEquals(HttpStatus.NOT_FOUND,houseResult.getStatusCode());
    }

    @Test
    void GetAllHousesSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<List<housesDTO>> houseListResult=houseController.getAllHouses();

        Assertions.assertEquals(HttpStatus.OK,houseListResult.getStatusCode());
    }

    @Test
    void GetHousesFilteredByPriceSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<List<House>> houseListResult=houseController.getHousesByPrice(230.0);

        Assertions.assertEquals(HttpStatus.OK,houseListResult.getStatusCode());
    }

    @Test
    void GetHousesFilteredByPriceUnsuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<List<House>> houseListResult=houseController.getHousesByPrice(240.0);

        Assertions.assertEquals(HttpStatus.NOT_FOUND,houseListResult.getStatusCode());
    }

    @Test
    void AddHouseSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<House> responseEntity=houseController.createHouse(new House());

        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @Test
    void UpdateHouseSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<House> responseEntity=houseController.updateHouse(new House(2,"ss","dd",true,230,1L,"stefan","+2322211","strahil@gmail.com"));

        Assertions.assertEquals(HttpStatus.NO_CONTENT,responseEntity.getStatusCode());
    }

    @Test
    void GetAllHousesPerLandlordSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<List<House>> houseListResult=houseController.getAllHousesPerLandlord(1L);

        Assertions.assertEquals(HttpStatus.OK,houseListResult.getStatusCode());
    }

    @Test
    void GetAllBookedHousesPerLandlordSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<List<House>> houseListResult=houseController.getAllBookedHousesPerLandlord(1L);

        Assertions.assertEquals(HttpStatus.OK,houseListResult.getStatusCode());
    }

    @Test
    void ReserveHouseSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<House> houseListResult=houseController.reserveHouse(1L);

        Assertions.assertEquals(HttpStatus.NO_CONTENT,houseListResult.getStatusCode());
    }

    @Test
    void LeaveHouseSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<House> houseListResult=houseController.leaveHouse(1L);

        Assertions.assertEquals(HttpStatus.NO_CONTENT,houseListResult.getStatusCode());
    }

    @Test
    void DeleteHouseSuccessfullyTest(){
        HouseController houseController=new HouseController(new HouseServiceMock());

        ResponseEntity<House> houseListResult=houseController.deleteHouse(1);

        Assertions.assertEquals(HttpStatus.OK,houseListResult.getStatusCode());
    }

}
