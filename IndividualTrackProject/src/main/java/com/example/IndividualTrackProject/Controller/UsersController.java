package com.example.IndividualTrackProject.Controller;


import com.example.IndividualTrackProject.Model.DTOs.userDTO.UsersDTO;
import com.example.IndividualTrackProject.Model.DTOs.userDTO.userAuthenticationDTO;
import com.example.IndividualTrackProject.Model.Request.UserCreateRequest;
import com.example.IndividualTrackProject.Model.User;
import com.example.IndividualTrackProject.Service.Interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final IUserService userService;


    @CrossOrigin("http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        List<User> users=userService.getUsers();
        List<UsersDTO> usersDTOList=new ArrayList<>();

        for(User user: users){
            usersDTOList.add(new UsersDTO(user.getId(),user.getUsername(),user.getEmail()));
        }

        if (!usersDTOList.isEmpty()){
            return ResponseEntity.ok().body(usersDTOList);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


    @CrossOrigin("http://localhost:3000")
    @GetMapping("/user/{id}")
    public ResponseEntity<userAuthenticationDTO> getUserPath(@PathVariable (value = "id") Long id) {

        User user = userService.getUser(id);
        userAuthenticationDTO userAuthenticationDTO=new userAuthenticationDTO(user.getId(),user.getUsername(),user.getEmail(),user.getPassword());

        if(userAuthenticationDTO.getId()!= null) {
            return ResponseEntity.ok().body(userAuthenticationDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @CrossOrigin("http://localhost:3000")
    @GetMapping("/user")
    public ResponseEntity<User> getUserId(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        User user=userService.getUserId(username, password);


        if (user!=null){
            return ResponseEntity.ok().body(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }




    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("user/{id}")
    public ResponseEntity deletePost(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();

    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        userService.createUser(userCreateRequest);
        return ResponseEntity.ok().build();
    }




    @CrossOrigin("http://localhost:3000")
    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user){
        if (userService.updateUser(user)){
            return ResponseEntity.noContent().build();
        }
        else {
            return new ResponseEntity("Please provide a valid id. ", HttpStatus.NOT_FOUND);
        }
    }




}
