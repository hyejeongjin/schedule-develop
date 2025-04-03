package schedule.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private final String title;

    private final String content;

    private final Long user_id;


    public ScheduleUpdateRequestDto(Long userId, String title, String content) {
        this.user_id = userId;
        this.title = title;
        this.content = content;

    }
}
