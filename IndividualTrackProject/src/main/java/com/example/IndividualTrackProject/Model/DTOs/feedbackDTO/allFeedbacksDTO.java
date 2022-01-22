package com.example.IndividualTrackProject.Model.DTOs.feedbackDTO;

import lombok.Data;

@Data
public class allFeedbacksDTO {

    private long id;
    private String feedback;

    public allFeedbacksDTO(long id, String feedback){
        this.id=id;
        this.feedback=feedback;
    }
}
