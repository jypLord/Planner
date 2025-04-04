package jyplord.calender.DTO.response;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
public class AllPlanResponse {

    private final Long PlanID;
    private final String planTitle;
    private final String planBody;

    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
}
