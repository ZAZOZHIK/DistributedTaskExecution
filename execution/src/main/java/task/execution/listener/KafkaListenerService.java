package task.execution.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import task.execution.dto.TaskDto;
import task.execution.exception.DeserializeJsonException;
import task.execution.service.TaskService;

@Service
public class KafkaListenerService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TaskService taskService;

    @KafkaListener(topics = "${spring.kafka.topic.send-task}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        TaskDto taskDto;
        try {
            taskDto = objectMapper.readValue(message, TaskDto.class);
        } catch (JsonProcessingException e) {
            throw new DeserializeJsonException("Failed to deserialize skill offer event");
        }
        taskService.createTask(taskDto);
        System.out.println("Consumed message: " + message);
    }
}
