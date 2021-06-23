package consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.example.demoentity.entity.Consumer;

@Service
public class KafkaReciever {

    private List<Consumer> allList = new ArrayList<>();
    private List<Consumer> currentList = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReciever.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void recieveData(Consumer student) {
        LOGGER.info("Data - " + student.toString() + " recieved");
        currentList.add(student);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "${spring.kafka.topic.name}", partitionOffsets = {
            @PartitionOffset(partition = "0", initialOffset = "0") }), containerFactory = "kafkaListenerContainerFactory",
            groupId = "group-2")
    public void addtoList(Consumer student) {
        LOGGER.info("Data - " + student.toString() + " recieved");
        allList.add(student);
    }

    public List<Consumer> getCurrent() {
        return currentList;
    }

    public List<Consumer> getAll() {
        return allList;
    }

}
