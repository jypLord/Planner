package jyplord.calender.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CommentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentID;

    private String comment;

    @ManyToOne
    @JoinColumn(name="user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name ="plan")
    private PlanEntity plan;
}
