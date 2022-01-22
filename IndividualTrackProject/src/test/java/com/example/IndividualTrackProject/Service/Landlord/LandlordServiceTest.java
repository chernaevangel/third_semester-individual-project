package com.example.IndividualTrackProject.Service.Landlord;

import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.Request.LandlordCreateRequest;
import com.example.IndividualTrackProject.Service.LandlordService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class LandlordServiceTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetLandlordSuccessfullyTest(){
        LandlordService service=new LandlordService(new LandlordDALMock());

        Landlord landlordResult=service.getLandlord(1L);

        assertThat(landlordResult).isNotNull();
    }



    @Test
    void AddLandlordSuccessfullyTest(){
        LandlordService service=new LandlordService(new LandlordDALMock());

        Boolean landlordResult=service.addNewLandlord(new LandlordCreateRequest());

        assertThat(landlordResult).isTrue();
    }










    @Test
    void GetAllLandlordsSuccessfullyTest(){
        LandlordService service=new LandlordService(new LandlordDALMock());

        List<Landlord> landlordResult=service.getAllLandlords();

        assertThat(landlordResult).isNotNull();
    }







}
