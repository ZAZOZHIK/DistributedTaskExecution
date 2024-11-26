package task.execution.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import task.execution.dto.TaskDto;
import task.execution.dto.TaskEventDto;
import task.execution.entity.TaskEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface TaskMapper {


    TaskDto toDto(TaskEntity taskEntity);

    TaskEntity toEntity(TaskDto taskDto);

    TaskEventDto toEventDto(TaskEntity taskEntity);

}
