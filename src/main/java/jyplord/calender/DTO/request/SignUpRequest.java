package jyplord.calender.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequest {
    @NotBlank
    @Size(min= 4, max= 16)
    private final String userID;

    @NotBlank
    private final String name;

    @NotBlank
    @Size(min= 4, max= 16)
    private final String password;

    @Email
    private final String email;
}
