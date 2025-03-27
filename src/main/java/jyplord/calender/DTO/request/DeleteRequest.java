package jyplord.calender.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteRequest {
    private final String UserID;
    private final String password;
    private final String plan;
}
