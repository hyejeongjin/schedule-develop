package schedule.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    @NotBlank
    private final String title;

    @NotBlank
    private final String content;

    private final Long user_id;


    public ScheduleUpdateRequestDto(Long userId, String title, String content) {
        this.user_id = userId;
        this.title = title;
        this.content = content;

    }
}
