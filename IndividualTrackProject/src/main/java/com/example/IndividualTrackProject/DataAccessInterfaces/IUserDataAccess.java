package com.example.IndividualTrackProject.DataAccessInterfaces;

import com.example.IndividualTrackProject.Model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDataAccess {

     List<User> getUsers();
     User getUser(long userId);
     Boolean deleteUser(long userId);
     Boolean addUser(User user);
     Boolean updateUser(User user);

     Optional<User> findByUsername(String username);
}
