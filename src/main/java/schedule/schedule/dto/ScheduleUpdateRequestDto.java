package schedule.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    @NotBlank(message = "제목은 필수로 입력해야합니다!")
    private final String title;

    @NotBlank(message = "내용은 필수로 입력해야합니다!")
    private final String content;

    private final Long user_id;


    public ScheduleUpdateRequestDto(Long userId, String title, String content) {
        this.user_id = userId;
        this.title = title;
        this.content = content;

    }
}
