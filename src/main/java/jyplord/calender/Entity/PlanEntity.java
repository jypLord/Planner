package jyplord.calender.Entity;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
public class PlanEntity {
    private final BigDecimal planID;
    private final String userID;
    private String plan;
    private LocalDateTime write_date;
}
