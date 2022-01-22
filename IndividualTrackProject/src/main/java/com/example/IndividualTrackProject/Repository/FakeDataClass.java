/* package com.example.IndividualTrackProject.Repository;

import com.example.IndividualTrackProject.Model.House;
import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Repository.Interfaces.IFakeDataClass;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeDataClass implements IFakeDataClass {


    private final List<User> userList=new ArrayList<>();
    private final List<House> houseList=new ArrayList<>();

    public FakeDataClass(){
        userList.add(new User("john123@gmail.com","john123","john123"));
        userList.add(new User("peter123@gmail.com","peter123","peter123"));
        userList.add(new User("daren123@gmail.com","daren123","daren123"));
        userList.add(new User("david123@gmail.com","david123","david123"));
        userList.add(new User("jordan23@gmail.com","jordan123","jordan123"));
        userList.add(new User("lucas123@gmail.com","lucas123","lucas123"));
        houseList.add(new House(1,"Petar Jackson","Brunelleschiweg 12","Cozy apartment with nice view",25));
        houseList.add(new House(2,"David Jackson","Hoegsttraat 132","Cozy room with nice view",40));
        houseList.add(new House(3,"Simon Jackson","Pioenroostraat 4","Cozy apartment in a nice location",60));
        houseList.add(new House(4,"Daniel Jackson","Strijkstaat 23","Cozy room in a nice location",35));
        houseList.add(new House(5,"Alex Jackson","Sttratum 1","Cozy apartment at a great price",17));
        houseList.add(new House(6,"Joey Jackson","Vestijk 53","Cozy apartment at a great price",20));
    }


    public List<User> getUsers() {return userList;}

    public List<House> getHouses() {return houseList;}

    public User getUser(int nr) {
        for (User user : userList) {
            if (user.getId() == nr)
                return user;
        }
        return null;
    }

    public House getHouse(int nr){
        for(House house : houseList){
            if(house.getHouseId()==nr)
                return house;
        }
        return null;
    }


    public boolean deleteUser(int id){
        User user = getUser(id);
        if (user == null){
            return false;
        }
        return userList.remove(user);
    }

    public boolean deleteHouse(int id){
        House house = getHouse(id);
        if (house == null){
            return false;
        }
        return houseList.remove(house);
    }



    public boolean addUser(User user) {
        if (this.getUser((int)user.getId()) != null){
            return false;
        }
        userList.add(user);
        return true;
    }

    public boolean addHouse(House house) {
        if (this.getHouse((int)house.getHouseId()) != null){
            return false;
        }
        houseList.add(house);
        return true;
    }


    public boolean updateUser(User user) {
        User oldUser=this.getUser((int)user.getId());
        if (oldUser==null){
            return false;
        }
        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        return true;
    }

    public boolean updateHouse(House house) {
        House oldHouse=this.getHouse((int)house.getHouseId());
        if (oldHouse==null){
            return false;
        }
        oldHouse.setLandlord(house.getLandlord());
        oldHouse.setAddress(house.getAddress());
        oldHouse.setDescription(house.getDescription());
        oldHouse.setPricePerNight(house.getPricePerNight());
        return true;
    }



} */
