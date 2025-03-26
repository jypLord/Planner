package jyplord.calender.DTO.request;

import jyplord.calender.DTO.DTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PlanRequest implements DTO {
    private final String userID;
    private final LocalDateTime writeDate;
    private final int page;
}
