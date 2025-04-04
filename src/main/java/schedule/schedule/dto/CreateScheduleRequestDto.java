package schedule.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    @NotBlank(message = "제목은 필수로 입력해야합니다!")
    private final String title;

    @NotBlank(message = "내용은 필수로 입력해야합니다!")
    private final String content;

    // 작성자를 보기 위함.
    private final String username;

    public CreateScheduleRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }
}
