package com.example.IndividualTrackProject.Controller.User;

import com.example.IndividualTrackProject.Model.Request.UserCreateRequest;
import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Service.Interfaces.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceMock implements IUserService {


    List<User> userList=new ArrayList<>();
    List<UserCreateRequest> userCreateRequestList=new ArrayList<>();

    @Override
    public List<User> getUsers() {

        userList.add(new User(1L,"daniel@gmail.com","dani123","daniel123"));
        return userList;
    }

    @Override
    public User getUser(long userId) {
        if(userId == 1){
            return new User();
        }
        else {
            return null;
        }
    }

    @Override
    public User getUserId(String username, String password) {
        userList.add(new User(1L,"daniel@gmail.com","daniel","daniel"));
        for(User user:userList){
            if(user.getUsername()==username && user.getPassword()==password){
                return user;
            }
        }
        return null;
    }

    @Override
    public Boolean deleteUser(long userId) {
        if (userId==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addUser(User user) {
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        return null;
    }


    @Override
    public void createUser(UserCreateRequest userCreateRequest) {
            if(userCreateRequest!=null) {
                userCreateRequestList.add(userCreateRequest);
            }
    }
}
