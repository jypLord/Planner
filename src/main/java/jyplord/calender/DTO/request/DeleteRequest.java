package jyplord.calender.DTO.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteRequest {
    @NotBlank(message = "ID is necessary")
    private final String UserID;
    private final String password;

    private final String plan;
}
