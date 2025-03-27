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
    private final String email;

    public UserEntity(String userID, String password){
        this.id = 0;
        this.userID = userID;
        this.name = null;
        this.password = password;
        this.email= null;
    }

    /*public UserEntity(Integer id, String userID, String name , String password, String email) {
        this.id = null;
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.email = email;
    }*/
}
