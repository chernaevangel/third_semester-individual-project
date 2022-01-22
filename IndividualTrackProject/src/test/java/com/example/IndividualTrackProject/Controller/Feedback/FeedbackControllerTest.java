package com.example.IndividualTrackProject.Controller.Feedback;

import com.example.IndividualTrackProject.Controller.FeedbackController;
import com.example.IndividualTrackProject.Model.DTOs.feedbackDTO.allFeedbacksDTO;
import com.example.IndividualTrackProject.Model.DTOs.feedbackDTO.feedbacksDTO;
import com.example.IndividualTrackProject.Model.Feedback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class FeedbackControllerTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetFeedbacksTest(){
        FeedbackController feedbackController=new FeedbackController(new FeedbackServiceMock());

        ResponseEntity<List<allFeedbacksDTO>> feedbackResult=feedbackController.getAllFeedbacks();

        Assertions.assertEquals(HttpStatus.OK,feedbackResult.getStatusCode());
    }

    @Test
    void GetFeedbacksFailedTest(){
        FeedbackController feedbackController=new FeedbackController(new FeedbackServiceMock());

        ResponseEntity<List<allFeedbacksDTO>> feedbackResult= new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Assertions.assertEquals(HttpStatus.NOT_FOUND,feedbackResult.getStatusCode());
    }

    @Test
    void AddFeedbackSuccessfully(){
        FeedbackController feedbackController=new FeedbackController(new FeedbackServiceMock());

        ResponseEntity<allFeedbacksDTO> feedbackResult=feedbackController.createFeedback(new feedbacksDTO());

        Assertions.assertEquals(HttpStatus.OK,feedbackResult.getStatusCode());
    }

    @Test
    void GetFeedbackTest(){
        FeedbackController feedbackController=new FeedbackController(new FeedbackServiceMock());

        ResponseEntity<Feedback> feedbackResult=feedbackController.getFeedbackPath(2L);

        Assertions.assertEquals(HttpStatus.OK,feedbackResult.getStatusCode());
    }
}
