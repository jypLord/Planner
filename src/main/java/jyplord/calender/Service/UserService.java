package jyplord.calender.Service;

import config.PasswordEncoder;
import jyplord.calender.DTO.request.LoginRequest;
import jyplord.calender.DTO.request.SignUpRequest;
import jyplord.calender.DTO.response.LoginResponse;
import jyplord.calender.Entity.UserEntity;
import jyplord.calender.Repository.UserRepository;
import jyplord.calender.exception.PasswordInvalidException;
import jyplord.calender.exception.SignUpExistEmailException;
import jyplord.calender.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest dto) {
        Optional<UserEntity> loginSign = userRepository.findByEmail(dto.getEmail());
        if (loginSign.isEmpty()) {
            throw new UserNotFoundException("No ID");

        } else {
            UserEntity userEntity = loginSign.get();
            if (passwordEncoder.matches(dto.getPassword() , userEntity.getPassword())){

                LoginResponse user = new LoginResponse(userEntity.getId(), userEntity.getEmail(),
                        userEntity.getName());
                return user;
            } else {
                throw new PasswordInvalidException("Invalid Password");
            }
        }
    }
    public String signUp(SignUpRequest dto) {

        String encodePw = passwordEncoder.encode(dto.getPassword());
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new SignUpExistEmailException("존재하는 이메일입니다.");
        } else {
            UserEntity newbie = new UserEntity(dto.getName(), dto.getBirthYYYYMMDD(), dto.getEmail(), encodePw);

            userRepository.save(newbie);
            return "회원가입 성공";
        }

    }
}

