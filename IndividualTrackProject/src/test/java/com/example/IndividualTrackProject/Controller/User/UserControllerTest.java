package com.example.IndividualTrackProject.Controller.User;

import com.example.IndividualTrackProject.Controller.UsersController;
import com.example.IndividualTrackProject.Model.DTOs.userDTO.UsersDTO;
import com.example.IndividualTrackProject.Model.DTOs.userDTO.userAuthenticationDTO;
import com.example.IndividualTrackProject.Model.Request.UserCreateRequest;
import com.example.IndividualTrackProject.Model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class UserControllerTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetUserTest(){
        UsersController controller= new UsersController(new UserServiceMock());

        ResponseEntity<userAuthenticationDTO> result = controller.getUserPath(1L);

        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
    }


    @Test
    void DeleteUser(){
        UsersController controller=new UsersController(new UserServiceMock());

        ResponseEntity<User> result= controller.deletePost(1);

        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void DeleteUserFailed(){
        UsersController controller=new UsersController(new UserServiceMock());

        ResponseEntity<User> result= controller.deletePost(2);

        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void GetAllUsersSuccessfully(){
        UsersController controller=new UsersController(new UserServiceMock());

        ResponseEntity<List<UsersDTO>> result= controller.getAllUsers();

        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void GetUserIdSuccessfullyTest(){
        UsersController controller= new UsersController(new UserServiceMock());

        ResponseEntity<User> result = controller.getUserId("daniel","daniel");

        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
    }

    @Test
    void GetUserIdUnsuccessfullyTest(){
        UsersController controller= new UsersController(new UserServiceMock());

        ResponseEntity<User> result = controller.getUserId("spas","daniel");

        Assertions.assertEquals(HttpStatus.NOT_FOUND,result.getStatusCode());
    }

    @Test
    void CreateUserSuccessfullyTest(){
        UsersController controller= new UsersController(new UserServiceMock());

        ResponseEntity<User> result = controller.createUser(new UserCreateRequest());

        Assertions.assertEquals(HttpStatus.OK,result.getStatusCode());
    }



}
