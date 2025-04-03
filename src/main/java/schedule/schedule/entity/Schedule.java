package schedule.schedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    private Long schedule_id;




}
