package com.example.IndividualTrackProject.Service.Interfaces;

import com.example.IndividualTrackProject.Model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> getFeedback();
    Feedback getFeedback(long feedbackId);
    Boolean addFeedback(Feedback feedback);
}
