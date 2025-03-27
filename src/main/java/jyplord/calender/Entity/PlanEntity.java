package jyplord.calender.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PlanEntity{
    private final BigDecimal planID;
    private final String userID;
    private String plan;
    private LocalDateTime writeDate;

    public PlanEntity(String userID, LocalDateTime writeDate){
        this.planID = null;
        this.plan = null;
        this.userID = userID;
        this.writeDate = writeDate;
    }
}
