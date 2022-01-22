package com.example.IndividualTrackProject.Repository.Interfaces;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.User;

import java.util.List;

public interface IFakeDataClass {
    public List<User> getUsers();
    public List<House> getHouses();
    public User getUser(int nr);
    public House getHouse(int nr);
    public boolean deleteUser(int id);
    public boolean deleteHouse(int id);
    public boolean addUser(User user);
    public boolean addHouse(House house);
    public boolean updateUser(User user);
    public boolean updateHouse(House house);
}
