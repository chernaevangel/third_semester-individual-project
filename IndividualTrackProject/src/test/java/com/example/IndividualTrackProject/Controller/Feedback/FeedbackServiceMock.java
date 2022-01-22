package com.example.IndividualTrackProject.Controller.Feedback;

import com.example.IndividualTrackProject.Model.Feedback;
import com.example.IndividualTrackProject.Service.Interfaces.IFeedbackService;

import java.util.ArrayList;
import java.util.List;

public class FeedbackServiceMock implements IFeedbackService {


    private List<Feedback> feedbackList=new ArrayList<>();

    @Override
    public List<Feedback> getFeedback() {
        feedbackList.add(new Feedback());
        return feedbackList;
    }

    @Override
    public Feedback getFeedback(long feedbackId) {
        if(feedbackId==2){
            return new Feedback();
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean addFeedback(Feedback feedback) {
        if(feedback!=null){
            feedbackList.add(feedback);
            return true;
        }
        else {
            return false;
        }

    }
}
