package jyplord.calender.Service;

import jyplord.calender.DTO.request.SignUpRequest;
import jyplord.calender.Entity.UserEntity;
import jyplord.calender.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserSerivice {
    private final UserRepository userRepository;

    public boolean signUp(SignUpRequest dto) {
        try {
            UserEntity entity = new UserEntity(0,
                    dto.getUserID(),
                    dto.getName(),
                    dto.getPassword(),
                    dto.getEmail());
            userRepository.signUp(entity);
        } catch (SQLException e) {
            log.error("Error!");
            return false;
        }
        return true;
    }
}
