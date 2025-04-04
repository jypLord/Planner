package jyplord.calender.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequest {

    @Email
    private final String email;

    @Pattern(regexp = "\\D+", message = "이름을 입력해주세요")
    private final String name;

    @Pattern(regexp = "^\\d{8}$", message = "올바른 생년월일을 입력해주세요")
    private final String birthYYYYMMDD;

    @Size(min=8, max=16)
    private final String password;
}
