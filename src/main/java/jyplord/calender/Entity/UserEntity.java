package jyplord.calender.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserEntity {
    private final int id;
    private final String userID;
    private final String name;
    private final String password;

    public UserEntity(String userID, String password){
        this.id = 0;
        this.userID = userID;
        this.name = null;
        this.password = password;
    }
}
