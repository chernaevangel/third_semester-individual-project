package com.example.IndividualTrackProject.Repository.TestRepo.TestInterfaces;

import com.example.IndividualTrackProject.Model.User;

import java.util.List;

public interface IUserTestRepo {
    public List<User> getUsers();
    public User getUser(Long nr);
    public boolean deleteUser(Long id);
    public boolean addUser(User user);
    public boolean updateUser(User user);
}
