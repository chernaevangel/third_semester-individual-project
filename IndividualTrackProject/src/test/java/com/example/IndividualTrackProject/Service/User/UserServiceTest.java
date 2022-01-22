package com.example.IndividualTrackProject.Service.User;

import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetUserSuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        User userResult=service.getUser(1L);

        assertThat(userResult).isNotNull();
    }

    @Test
    void GetUserUnsuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        User userResult=service.getUser(2L);

        assertThat(userResult).isNull();
    }

    @Test
    void GetAllUsersSuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        List<User> userList=service.getUsers();

        assertThat(userList).isNotNull();
    }

    @Test
    void DeleteUserSuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        Boolean result=service.deleteUser(1L);

        assertThat(result).isTrue();
    }

    @Test
    void DeleteUserUnsuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        Boolean result=service.deleteUser(2L);

        assertThat(result).isFalse();
    }

    @Test
    void AddUserSuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        Boolean result=service.addUser(new User());

        assertThat(result).isTrue();
    }

    @Test
    void AddUserUnsuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        Boolean result=service.addUser(null);

        assertThat(result).isFalse();
    }

    @Test
    void UpdateUserSuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        Boolean result=service.updateUser(new User());

        assertThat(result).isTrue();
    }

    @Test
    void UpdateUserUnsuccessfullyTest(){
        UserService service=new UserService(new UserDALMock(),new BCryptPasswordEncoder());

        Boolean result=service.updateUser(null);

        assertThat(result).isFalse();
    }



}
