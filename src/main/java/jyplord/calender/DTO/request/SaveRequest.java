package jyplord.calender.DTO.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class SaveRequest {
    private final String userID;
    private final String name;
    private final String plan;
    private final LocalDateTime writeDate;
}
