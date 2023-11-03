package priorsorution.co.th.produder.kafka.component.kafka.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaComponent {
    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaComponent(@Qualifier("registerKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendData(String message) {

        this.kafkaTemplate.send(topic, message)
                .whenComplete(
    }
}
