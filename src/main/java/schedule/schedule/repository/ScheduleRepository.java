package schedule.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


}
