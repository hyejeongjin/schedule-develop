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

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }


    @PatchMapping("/{schedule_id}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateSchedule(
            @PathVariable Long schedule_id,
            @RequestBody ScheduleUpdateRequestDto requestDto
            ){

        ScheduleUpdateResponseDto scheduleUpdateResponseDto = scheduleService.updateSchedule(schedule_id, requestDto);

        return new ResponseEntity<>(scheduleUpdateResponseDto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
