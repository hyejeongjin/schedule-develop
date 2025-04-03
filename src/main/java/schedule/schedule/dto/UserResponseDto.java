package schedule.schedule.dto;

import lombok.Getter;
import schedule.schedule.entity.User;

@Getter
public class UserResponseDto {
    private final String username;

    private final String email;

    public UserResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
