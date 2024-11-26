package task.execution.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import task.execution.dto.TaskDto;
import task.execution.exception.SerializeJsonException;

@Service
public class KafkaPublisherService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${spring.kafka.topic.send-task}")
    private String topic;

    public void sendMessage(TaskDto message) {
        try {
            kafkaTemplate.send(topic, objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new SerializeJsonException("Cannot serialize event to json");
        }
    }
}
