package schedule.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @NotBlank(message = "이름은 필수로 입력해야합니다!")
    private final String username;

    @NotBlank(message = "바밀번호는 필수로 입력해야합니다!")
    private final String password;

    @NotBlank(message = "이메일은 필수로 입력해야합니다!")
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private final String email;


    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
