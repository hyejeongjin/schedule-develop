package schedule.schedule.dto;

import lombok.Getter;
import schedule.schedule.entity.Schedule;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String content;


    public ScheduleResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getSchedule_id(), schedule.getTitle(), schedule.getContent());
    }

}
