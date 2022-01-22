package com.example.IndividualTrackProject.Repository.TestRepo;

import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Repository.TestRepo.TestInterfaces.IUserTestRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserTestRepo implements IUserTestRepo {

    private final List<User> userList=new ArrayList<>();




    @Override
    public List<User> getUsers() {
        return this.userList;
    }

    @Override
    public User getUser(Long nr) {
        for(User user:getUsers()){
            if(user.getId()==nr){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
            this.userList.add(user);
            return true;


    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
