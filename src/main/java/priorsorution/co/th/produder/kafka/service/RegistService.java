package priorsorution.co.th.produder.kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import priorsorution.co.th.produder.kafka.component.kafka.component.KafkaComponent;
import priorsorution.co.th.produder.kafka.model.RegistrationModel;
import priorsorution.co.th.produder.kafka.model.ResponseModel;

@Service
public class RegistService {
    private KafkaComponent kafkaComponent;

    public RegistService(KafkaComponent kafkaComponent) {
        this.kafkaComponent = kafkaComponent;
    }


    public ResponseModel<Void> sendToKafka(RegistrationModel registrationModel) {
        ResponseModel<Void> result = new ResponseModel<>();
        result.setStatus(200);
        result.setDescription("ok");
        try {
            String message = this.objectToJasonString(registrationModel);
            this.kafkaComponent.sendData(message);

        } catch (Exception e) {
            result.setStatus(500);
            result.setDescription("Error" + e.getMessage());
        }
        return result;
    }
    private  String objectToJasonString(Object model) throws JsonProcessingException{

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(model);
    }

}
