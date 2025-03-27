package jyplord.calender.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviseRequest {

    @NotBlank(message = "ID is necessary")
    private final String UserID;

    private final String password;

    @Size(max = 200, message = "plz enter under 200 characters")
    private final String plan;
}
