package jyplord.calender.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class SaveRequest {
    @NotBlank(message = "ID is necessary")
    private final String userID;

    @NotNull
    private final String name;

    @Size(max = 200, message = "Please enter less than 200 characters.")
    private final String plan;

    private final LocalDateTime writeDate;
}
