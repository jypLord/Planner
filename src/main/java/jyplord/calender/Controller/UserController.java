package jyplord.calender.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jyplord.calender.DTO.request.LoginRequest;
import jyplord.calender.DTO.request.SignUpRequest;
import jyplord.calender.DTO.response.LoginResponse;
import jyplord.calender.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController{
    private final UserService userService;

    @PostMapping(value= "/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequest dto){
        userService.signUp(dto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping(value = "/planner/login" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest dto, HttpSession session){
        LoginResponse user = userService.login(dto);
        session.setAttribute("loginUser", user);
            return ResponseEntity.ok(user);
    }
}
