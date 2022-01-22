package com.example.IndividualTrackProject.Repository.Interfaces;

import com.example.IndividualTrackProject.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedbackRepo extends JpaRepository<Feedback, Long> {
}
