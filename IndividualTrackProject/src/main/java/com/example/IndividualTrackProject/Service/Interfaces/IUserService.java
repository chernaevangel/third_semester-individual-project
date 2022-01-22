package com.example.IndividualTrackProject.Service.Interfaces;

import com.example.IndividualTrackProject.Model.Request.UserCreateRequest;
import com.example.IndividualTrackProject.Model.User;

import java.util.List;

public interface IUserService {
     List<User> getUsers();
     User getUser(long userId);
     User getUserId(String username,String password);
     Boolean deleteUser(long userId);
     Boolean addUser(User user);
     Boolean updateUser(User user);

     //Boolean addLandlordUser(User user, Landlord landlord);
    // void createLandlordUser(LandlordCreateRequest landlordCreateRequest);

     void createUser(UserCreateRequest userCreateRequest);
}
