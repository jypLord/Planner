package jyplord.calender.Controller;

import jakarta.validation.Valid;
import jyplord.calender.DTO.request.SignUpRequest;
import jyplord.calender.Service.UserSerivice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController{
    private final UserSerivice userSerivice;

    @PutMapping(value = "/planner/login" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequest dto){
        boolean result = userSerivice.signUp(dto);
        if(result){
            return ResponseEntity.ok("Sign up complete");
        }else {
            return ResponseEntity.badRequest().body("failed");
        }
    }
}
