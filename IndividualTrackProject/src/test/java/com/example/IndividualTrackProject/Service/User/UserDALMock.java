package com.example.IndividualTrackProject.Service.User;

import com.example.IndividualTrackProject.DataAccessInterfaces.IUserDataAccess;
import com.example.IndividualTrackProject.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDALMock implements IUserDataAccess {

    List<User> usersList=new ArrayList<>();

    @Override
    public List<User> getUsers() {
        usersList.add(new User());
        return usersList;
    }

    @Override
    public User getUser(long userId) {
       if(userId==1){
           return new User();
       }
       else {
           return null;
       }
    }

    @Override
    public Boolean deleteUser(long userId) {
        if(userId==1){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public Boolean addUser(User user) {
        if(user!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean updateUser(User user) {
        if(user!=null){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
