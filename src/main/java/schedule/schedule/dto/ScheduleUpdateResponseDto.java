package schedule.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import schedule.schedule.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleUpdateResponseDto {

    private String title;
    private String content;


}
