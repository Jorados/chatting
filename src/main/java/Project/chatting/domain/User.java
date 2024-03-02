package Project.chatting.domain;

import Project.chatting.domain.type.Role;
import Project.chatting.domain.type.SocialType;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "USERS")
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String password;
    private String nickname;
    private String imageUrl; // 프로필 이미지
    private int age;
    private String city; // 사는 도시

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType; // KAKAO , NAVER , GOOGLE

    private String socialId; // 로그인한 소셜 타입의 식별자 값 ( 일반 로그인인 경우 null )
    private String refreshToken; // 리프레시 토큰

    public void authorizeUser(){
        this.role = Role.USER;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

    public void updateRefreshToken(String updateRefreshToken){
        this.refreshToken = updateRefreshToken;
    }
}
