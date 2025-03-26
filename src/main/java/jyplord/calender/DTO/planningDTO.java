package jyplord.calender.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class planningDTO {
    private String userId;
    private String name;
    private String plan;
    private String password;
    private LocalDateTime writeDate;
    private BigDecimal plan_id;


    public planningDTO(String userID, String name, String plan, LocalDateTime writeDate){
        this.userId = userID;
        this.plan = plan;
        this.writeDate = writeDate;
        this.password = null;
        this.name = null;
    }

}
