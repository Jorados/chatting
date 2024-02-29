package Project.chatting.entity;

import Project.chatting.entity.type.UserEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    // 기본키를 자동으로 생성하는 방법 4가지 --> 따로 정리하자.
    // @Id @GeneratedValue 혹은 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  --> 디비에게 권한위임 --> 디비가 알아서 기본키 생성
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserEnum role;

//    @CreatedDate
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
}
