package com.example.IndividualTrackProject.Service;

import com.example.IndividualTrackProject.DataAccessInterfaces.IFeedbackDataAccess;
import com.example.IndividualTrackProject.Model.Feedback;
import com.example.IndividualTrackProject.Service.Interfaces.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackService implements IFeedbackService {

    IFeedbackDataAccess feedbackDataAccess;

    @Autowired
    public FeedbackService(IFeedbackDataAccess feedbackDataAccess){
        this.feedbackDataAccess=feedbackDataAccess;
    }

    @Override
    public List<Feedback> getFeedback() {
        return feedbackDataAccess.getFeedback();
    }

    @Override
    public Feedback getFeedback(long feedbackId) {
        return feedbackDataAccess.getFeedback(feedbackId);
    }

    @Override
    public Boolean addFeedback(Feedback feedback) {
        return feedbackDataAccess.addFeedback(feedback);
    }
}
