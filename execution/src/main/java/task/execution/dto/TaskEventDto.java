package task.execution.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import task.execution.entity.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEventDto {
    private Long id;
    private String name;
    private Status status;
}
