package jyplord.calender.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviseRequest {
    @NotBlank
    @Size(max = 50, message = "plz enter under 50 characters")
    private final String planTitle;

    @Size(max = 200, message = "plz enter under 200 characters")
    private final String planBody;
}
