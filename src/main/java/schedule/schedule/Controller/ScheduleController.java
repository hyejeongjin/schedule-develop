package schedule.schedule.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedule.schedule.dto.CreateScheduleRequestDto;
import schedule.schedule.dto.ScheduleResponseDto;
import schedule.schedule.dto.ScheduleUpdateRequestDto;
import schedule.schedule.dto.ScheduleUpdateResponseDto;
import schedule.schedule.entity.Schedule;
import schedule.schedule.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto){

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTitle(), requestDto.getContent(), requestDto.getUsername());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateSchedule(
            @PathVariable Long user_id,
            @PathVariable Long schedule_id,
            @RequestBody ScheduleUpdateRequestDto requestDto
            ){

        scheduleService.updateSchedule(user_id, schedule_id, requestDto);

        return new ResponseEntity<>(HttpStatus.OK);

    }


}
