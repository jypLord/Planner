package jyplord.calender.Entity;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlanEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planID;

    private String planTitle;
    private String planBody;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserEntity name;

    @OneToMany(mappedBy = "plan")
    List<CommentEntity> comments = new ArrayList<>();

    public PlanEntity(String planTitle ,String planBody, UserEntity name){
        this.planTitle = planTitle;
        this.planBody = planBody;
        this.name = name;
    }
}
