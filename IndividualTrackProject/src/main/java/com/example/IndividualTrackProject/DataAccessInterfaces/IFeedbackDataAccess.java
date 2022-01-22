package com.example.IndividualTrackProject.DataAccessInterfaces;

import com.example.IndividualTrackProject.Model.Feedback;

import java.util.List;

public interface IFeedbackDataAccess {
    List<Feedback> getFeedback();

    Feedback getFeedback(long feedbackId);

    Boolean addFeedback(Feedback feedback);
}
