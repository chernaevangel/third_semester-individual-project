package com.example.IndividualTrackProject.Service.Feedback;

import com.example.IndividualTrackProject.DataAccessInterfaces.IFeedbackDataAccess;
import com.example.IndividualTrackProject.Model.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDALMock implements IFeedbackDataAccess {

    List<Feedback> feedbackList=new ArrayList<>();

    @Override
    public List<Feedback> getFeedback() {
        feedbackList.add(new Feedback());
        return feedbackList;
    }

    @Override
    public Feedback getFeedback(long feedbackId) {
        if(feedbackId==1){
            return new Feedback();
        }
        else {
        return null;
        }
    }

    @Override
    public Boolean addFeedback(Feedback feedback) {
        if(feedback!=null){
            return true;
        }
        else {
            return false;
        }
    }
}
