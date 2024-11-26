package task.execution.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import task.execution.entity.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotNull(message = "Имя не может быть пустым")
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status status;
}
