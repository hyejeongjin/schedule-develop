package schedule.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schedule.schedule.dto.ScheduleResponseDto;
import schedule.schedule.entity.Schedule;
import schedule.schedule.entity.User;
import schedule.schedule.repository.ScheduleRepository;
import schedule.schedule.repository.UserRepository;

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
}
