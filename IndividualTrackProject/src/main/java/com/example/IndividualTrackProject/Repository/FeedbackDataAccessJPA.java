package com.example.IndividualTrackProject.Repository;

import com.example.IndividualTrackProject.DataAccessInterfaces.IFeedbackDataAccess;
import com.example.IndividualTrackProject.Model.Feedback;
import com.example.IndividualTrackProject.Repository.Interfaces.IFeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackDataAccessJPA implements IFeedbackDataAccess {

    @Autowired
    IFeedbackRepo feedbackRepo;

    @Override
    public List<Feedback> getFeedback() {
        return feedbackRepo.findAll();
    }

    @Override
    public Feedback getFeedback(long feedbackId) {
        return feedbackRepo.findById(feedbackId).orElse(null);
    }

    @Override
    public Boolean addFeedback(Feedback feedback) {
        feedbackRepo.save(feedback);
        return true;

    }
}
