package schedule.schedule.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private final String username;

    private final String password;

    private final String email;


    public UserUpdateRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
