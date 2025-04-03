package schedule.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String title;
    private final String content;

    // 작성자를 보기 위함.
    private final String username;

    public CreateScheduleRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }
}
