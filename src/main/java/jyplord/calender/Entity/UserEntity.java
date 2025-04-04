package jyplord.calender.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
public class UserEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String birthDay;

    @Column(unique = true)
    private String email;
    private String password;

    public UserEntity(String name, String birthDay,String email, String password){
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.password = password;
    }

    public UserEntity(String name){
        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    private List<PlanEntity> plans = new ArrayList<>();

    @OneToMany(mappedBy = "comment")
    private List<CommentEntity> comment = new ArrayList<>();
}
