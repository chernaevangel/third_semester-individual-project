package com.example.IndividualTrackProject.Repository;

import com.example.IndividualTrackProject.DataAccessInterfaces.IUserDataAccess;
import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Repository.Interfaces.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserDataAccessJPA implements IUserDataAccess {

    private final IUserRepo userRepo;



    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(long userId) {
        return userRepo.findById(userId).orElse(null);
    }



    @Override
    public Boolean deleteUser(long userId) {
        User user=getUser(userId);
        if (user==null){
            return false;
        }
        else {
            userRepo.deleteById(userId);
            return true;
        }

    }

    @Override
    public Boolean addUser(User user) {
       userRepo.save(user);


            return true;

    }

    @Override
    public Boolean updateUser(User user) {
        User userFromDB=this.getUser(user.getId());
        if (userFromDB!=null){
            userFromDB.setEmail(user.getEmail());
            userFromDB.setUsername((user.getUsername()));
            userFromDB.setPassword((user.getPassword()));
            userRepo.save(userFromDB);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
