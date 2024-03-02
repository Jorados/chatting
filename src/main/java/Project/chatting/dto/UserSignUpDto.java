package Project.chatting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 자체 로그인 회원 가입 API에 RequestBody로 사욜할거임.
@NoArgsConstructor
@Getter
public class UserSignUpDto {
    private String email;
    private String password;
    private String nickname;
    private int age;
    private String city;
}
