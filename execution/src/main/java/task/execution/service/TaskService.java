package task.execution.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.execution.dto.TaskDto;
import task.execution.entity.Status;
import task.execution.entity.TaskEntity;
import task.execution.exception.DataValidationException;
import task.execution.mapper.TaskMapper;
import task.execution.repository.TaskRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    public final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @Transactional
    public void createTask(TaskDto request) {
        TaskEntity task = taskMapper.toEntity(request);
        task.setStatus(Status.CREATE);
        taskRepository.save(task);
        log.info("Saved the created task {}", task.getName());
    }

    @Transactional(readOnly = true)
    public TaskDto getTask(Long id) {
        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() -> new DataValidationException("Task not found"));
        return taskMapper.toDto(task);
    }
}
