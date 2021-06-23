package consumer.controller;

import java.util.List;

import consumer.service.KafkaReciever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoentity.entity.Consumer;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private KafkaReciever reciever;

    @GetMapping("/current")
    public List<Consumer> getCurrent() {
        return reciever.getCurrent();

    }

    @GetMapping("/all")
    public List<Consumer> getAll() {
        return reciever.getAll();

    }

}
