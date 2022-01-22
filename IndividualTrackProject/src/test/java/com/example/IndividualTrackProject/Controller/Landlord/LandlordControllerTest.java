package com.example.IndividualTrackProject.Controller.Landlord;

import com.example.IndividualTrackProject.Controller.LandlordController;
import com.example.IndividualTrackProject.Model.DTOs.landlordDTO.landlordDTO;
import com.example.IndividualTrackProject.Model.DTOs.landlordDTO.landlordsDTO;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.Request.LandlordCreateRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class LandlordControllerTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetLandlordSuccessfullyTest(){
        LandlordController controller= new LandlordController(new LandlordServiceMock());

        ResponseEntity<landlordDTO> result = controller.getLandlordPath(1L);

        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
    }

    @Test
    void GetAllLandlordsSuccessfullyTest(){
        LandlordController controller= new LandlordController(new LandlordServiceMock());

        ResponseEntity<List<landlordsDTO>> result = controller.getAllLandlords();

        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
    }

    @Test
    void GetLandlordByEmailSuccessfullyTest(){
        LandlordController controller= new LandlordController(new LandlordServiceMock());

        ResponseEntity<Landlord> result = controller.getLandlordByEmailAndCode("EIN99","spas@gmail.com");

        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
    }

    @Test
    void GetLandlordByEmailUnsuccessfullyTest(){
        LandlordController controller= new LandlordController(new LandlordServiceMock());

        ResponseEntity<Landlord> result = controller.getLandlordByEmailAndCode("EIN100","spas@gmail.com");

        Assertions.assertEquals(HttpStatus.NOT_FOUND,result.getStatusCode());
    }

    @Test
    void CreateLandlordSuccessfullyTest(){
        LandlordController controller= new LandlordController(new LandlordServiceMock());

        ResponseEntity<Landlord> result = controller.createLandlord(new LandlordCreateRequest());

        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
    }
}
