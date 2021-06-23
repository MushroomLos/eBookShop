package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoentity.entity.Consumer;
import service.KafkaSender;

@RestController
@RequestMapping("/kafkaProducer")
public class KafkaProducerController {

    @Autowired
    private KafkaSender sender;

    @GetMapping
    public Consumer getConsumer() {
        Consumer s = new Consumer();
        s.setCustomerId("SID_001");
        s.setFirstName("Zhang");
        s.setLastName("Liping");
        s.setAge("25");

        return s;

    }

    @PostMapping
    public ResponseEntity<String> sendData(@RequestBody Consumer consumer){
        sender.sendData(customer);
        return new ResponseEntity<>("Data sent to Kafka", HttpStatus.OK);
    }
}
