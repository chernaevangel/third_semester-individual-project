package com.example.IndividualTrackProject.Service.House;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Service.HouseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HouseServiceTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetHouseUnsuccessfulTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        House resultHouse=houseService.getHouse(2L);

       assertThat(resultHouse).isNotEqualTo(new House());
    }

    @Test
    void GetHouseSuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        House resultHouse=houseService.getHouse(1L);

        assertThat(resultHouse).isNotNull();
    }

    @Test
    void GetAllHousesSuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        List<House> houses=houseService.getHouses();

        assertThat(houses).isNotNull();
    }

    @Test
    void DeleteHouseSuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        Boolean result=houseService.deleteHouse(1L);

        assertThat(result).isTrue();
    }

    @Test
    void DeleteHouseUnsuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        Boolean result=houseService.deleteHouse(2L);

        assertThat(result).isFalse();
    }

    @Test
    void AddHouseSuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        Boolean result=houseService.addHouse(new House());

        assertThat(result).isTrue();
    }

    @Test
    void AddHouseUnsuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        Boolean result=houseService.addHouse(null);

        assertThat(result).isFalse();
    }

    @Test
    void UpdateHouseSuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        Boolean result=houseService.updateHouse(new House());

        assertThat(result).isTrue();
    }

    @Test
    void UpdateHouseUnsuccessfullyTest(){
        HouseService houseService=new HouseService(new HouseDALMock());

        Boolean result=houseService.updateHouse(null);

        assertThat(result).isFalse();
    }




}
