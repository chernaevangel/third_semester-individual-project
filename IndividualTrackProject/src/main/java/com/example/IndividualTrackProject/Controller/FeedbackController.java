package com.example.IndividualTrackProject.Controller;


import com.example.IndividualTrackProject.Model.DTOs.feedbackDTO.allFeedbacksDTO;
import com.example.IndividualTrackProject.Model.DTOs.feedbackDTO.feedbacksDTO;
import com.example.IndividualTrackProject.Model.Feedback;
import com.example.IndividualTrackProject.Service.Interfaces.IFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private IFeedbackService feedbackService;

    public FeedbackController(IFeedbackService feedbackService){
        this.feedbackService=feedbackService;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<allFeedbacksDTO>> getAllFeedbacks(){
        List<Feedback> feedbacks=feedbackService.getFeedback();
        List<allFeedbacksDTO> allFeedbacksDTOList=new ArrayList<>();

        for(Feedback feedback:feedbacks){
            allFeedbacksDTOList.add(new allFeedbacksDTO(feedback.getId(), feedback.getFeedback()));
        }

        if (!allFeedbacksDTOList.isEmpty()){
            return ResponseEntity.ok().body(allFeedbacksDTOList);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackPath(@PathVariable(value = "id") Long id) {

        Feedback feedback = feedbackService.getFeedback(id);

        if(feedback != null) {
            return ResponseEntity.ok().body(feedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping()
    public ResponseEntity<allFeedbacksDTO> createFeedback(@RequestBody feedbacksDTO feedbackDto) {
        Feedback feedback=new Feedback();
        feedback.setFeedback(feedbackDto.getFeedback());
        feedbackService.addFeedback(feedback);
        return ResponseEntity.ok().build();
    }

}
