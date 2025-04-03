package schedule.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateResponseDto {

    private final String title;

    private final String content;

    public ScheduleUpdateResponseDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
