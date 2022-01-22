package com.example.IndividualTrackProject.Service.Feedback;

import com.example.IndividualTrackProject.Model.Feedback;
import com.example.IndividualTrackProject.Service.FeedbackService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FeedbackServiceTest {

    @Test
    void contextLoads() {
    }

    @Test
    void GetFeedbackSuccessfullyTest(){
        FeedbackService feedbackService=new FeedbackService(new FeedbackDALMock());

        Feedback resultFeedback=feedbackService.getFeedback(1L);

        assertThat(resultFeedback).isNotNull();
    }

    @Test
    void GetFeedbackUnsuccessfullyTest(){
        FeedbackService feedbackService=new FeedbackService(new FeedbackDALMock());

        Feedback resultFeedback=feedbackService.getFeedback(2L);

        assertThat(resultFeedback).isNotEqualTo(new Feedback());
    }

    @Test
    void GetAllFeedbacksSuccessfullyTest(){
        FeedbackService feedbackService=new FeedbackService(new FeedbackDALMock());

        List<Feedback> feedbackList=feedbackService.getFeedback();

        assertThat(feedbackList).isNotNull();
    }

    @Test
    void AddFeedbackSuccessfullyTest(){
        FeedbackService feedbackService=new FeedbackService(new FeedbackDALMock());

        Boolean result=feedbackService.addFeedback(new Feedback());

        assertThat(result).isTrue();
    }

    @Test
    void AddFeedbackUnsuccessfullyTest(){
        FeedbackService feedbackService=new FeedbackService(new FeedbackDALMock());

        Boolean result=feedbackService.addFeedback(null);

        assertThat(result).isFalse();
    }
}
