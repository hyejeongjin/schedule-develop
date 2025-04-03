package schedule.schedule.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import schedule.schedule.dto.ScheduleResponseDto;
import schedule.schedule.dto.ScheduleUpdateRequestDto;
import schedule.schedule.dto.ScheduleUpdateResponseDto;
import schedule.schedule.entity.Schedule;
import schedule.schedule.entity.User;
import schedule.schedule.repository.ScheduleRepository;
import schedule.schedule.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;


    public ScheduleResponseDto save(String title, String content, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, content);
        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getSchedule_id(), savedSchedule.getTitle(), savedSchedule.getContent());
    }

    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

    }

    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long user_id, Long schedule_id, ScheduleUpdateRequestDto requestDto) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(schedule_id);
        User findUser = userRepository.findByIdOrElseThrow(user_id);

        if(!findUser.getUser_id().equals(user_id) && !findSchedule.getSchedule_id().equals(schedule_id)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "작성자가 일치하지 않습니다!");
        }

        findSchedule.update(requestDto.getTitle(), requestDto.getContent());

        return updateSchedule(user_id, schedule_id, requestDto);

    }

    public void delete(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
