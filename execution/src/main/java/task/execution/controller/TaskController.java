package task.execution.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.execution.dto.TaskDto;
import task.execution.publisher.KafkaPublisherService;
import task.execution.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final KafkaPublisherService kafkaPublisherService;

    // TestController
    @PostMapping
    public  ResponseEntity<Void> createTask(@RequestBody @Valid TaskDto taskRequest) {
        kafkaPublisherService.sendMessage(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id) {
        TaskDto task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }
}
