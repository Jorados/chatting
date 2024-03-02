package Project.chatting.service;

import Project.chatting.domain.User;
import Project.chatting.domain.type.Role;
import Project.chatting.dto.UserSignUpDto;
import Project.chatting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // 자체 로그인, 회원가입 시 사용하는 회원 가입 API의 로직입니다.
    // 자체 로그인이기 때문에 클라이언트 요청에서 age,city 등 추가 정보까지 다 받아와서 Buileder로 추가정보를 포함한
    // User Entity 생성 후에 DB에 저장.
    public void signUp(UserSignUpDto userSignUpDto) throws Exception{
        if(userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if(userRepository.findByNickname(userSignUpDto.getNickname()).isPresent()){
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        User user = User.builder()
                .email(userSignUpDto.getEmail())
                .password(userSignUpDto.getPassword())
                .nickname(userSignUpDto.getNickname())
                .age(userSignUpDto.getAge())
                .city(userSignUpDto.getCity())
                .role(Role.USER)
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }
}
