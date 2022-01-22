package com.example.IndividualTrackProject.Service;

import com.example.IndividualTrackProject.DataAccessInterfaces.IUserDataAccess;
import com.example.IndividualTrackProject.Model.Request.UserCreateRequest;
import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class UserService implements IUserService {


    @Autowired
    private final IUserDataAccess userDataAccess;

    private final BCryptPasswordEncoder passwordEncoder;
   // @Autowired
    // private final ILandlordDataAccess landlordDataAccess;

   @Autowired
   public UserService(IUserDataAccess userDataAccess,BCryptPasswordEncoder bCryptPasswordEncoder){this.userDataAccess=userDataAccess;
   this.passwordEncoder=bCryptPasswordEncoder;}


    public User readUserByUsername (String username) {
        return userDataAccess.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void createUser(UserCreateRequest userCreateRequest) {
        User user = new User();
        Optional<User> byUsername = userDataAccess.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        user.setEmail(userCreateRequest.getEmail());
        userDataAccess.addUser(user);
    }



    @Override
    public List<User> getUsers() {
        return userDataAccess.getUsers();
    }


    @Override
    public User getUserId(String username,String password) {
        List<User> listUsers=getUsers();
        for (User user: listUsers){
            if (user.getUsername().equals(username) && passwordEncoder.matches(password, user.getPassword())){
                return user;
            }
        }
        return null;
    }


    @Override
    public User getUser(long userId) {
        return userDataAccess.getUser(userId);
    }

    @Override
    public Boolean deleteUser(long userId) {
        return userDataAccess.deleteUser(userId);
    }

    public Boolean addUser(User user) {
        return userDataAccess.addUser(user);
    }

   /* @Override
    public Boolean addLandlordUser(User user, Landlord landlord){
        if(landlordDataAccess.addNewLandlord(landlord)!=null){
            return addUser(user);
        }else {
            return false;
        }
    } */

    @Override
    public Boolean updateUser(User user) {return userDataAccess.updateUser(user); }


}
