package jyplord.calender.DTO.response;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PlanResponse {
    private final String userID;
    private final String name;
    private final String plan;
    private final LocalDateTime writeDate;
}
