package com.example.IndividualTrackProject.Controller;

import com.example.IndividualTrackProject.Model.DTOs.landlordDTO.landlordDTO;
import com.example.IndividualTrackProject.Model.DTOs.landlordDTO.landlordsDTO;
import com.example.IndividualTrackProject.Model.Landlord;
import com.example.IndividualTrackProject.Model.Request.LandlordCreateRequest;
import com.example.IndividualTrackProject.Service.Interfaces.ILandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/landlords")
public class LandlordController {

    @Autowired
    private ILandlordService landlordService;

    public LandlordController(ILandlordService landlordService){
        this.landlordService=landlordService;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<landlordsDTO>> getAllLandlords(){
        List<Landlord> landlords=landlordService.getAllLandlords();
        List<landlordsDTO> landlordsDTOS=new ArrayList<>();

        for (Landlord landlord:landlords){
            landlordsDTOS.add(new landlordsDTO(landlord.getId(),landlord.getName(),landlord.getEmail(),landlord.getMobilePhone()));
        }
        if (!landlordsDTOS.isEmpty()){
            return ResponseEntity.ok().body(landlordsDTOS);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }



    @CrossOrigin("http://localhost:3000")
    @GetMapping("/landlord/{id}")
    public ResponseEntity<landlordDTO> getLandlordPath(@PathVariable(value = "id") Long id){
       Landlord landlord=landlordService.getLandlord(id);
       landlordDTO landlordDTO=new landlordDTO(landlord.getId(),landlord.getName(),landlord.getEmail(),landlord.getMobilePhone(),landlord.getVerificationCode());
        if (landlordDTO.getId()!=null){
            return ResponseEntity.ok().body(landlordDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/landlord")
    public ResponseEntity<Landlord> getLandlordByEmailAndCode(@RequestParam (value = "code") String code,
                                                              @RequestParam (value = "email")String email){
        Landlord landlord=landlordService.getLandlordByEmailAndCode(code,email);
        if (landlord!=null){
            return ResponseEntity.ok().body(landlord);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/newLandlord")
    public ResponseEntity<Landlord> createLandlord(@RequestBody LandlordCreateRequest landlordCreateRequest) {
       landlordService.addNewLandlord(landlordCreateRequest);
       return ResponseEntity.ok().build();
    }

}
