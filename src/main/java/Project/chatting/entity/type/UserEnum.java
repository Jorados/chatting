package Project.chatting.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum UserEnum {
    ADMIN("관리자"), NORMAL("일반회원");
    private String value;
}
