package jyplord.calender.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private final long id;

    private final String name;
    private final String email;
}
