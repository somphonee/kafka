package priorsorution.co.th.produder.kafka.controller.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priorsorution.co.th.produder.kafka.model.RegistrationModel;
import priorsorution.co.th.produder.kafka.model.ResponseModel;
import priorsorution.co.th.produder.kafka.service.RegistService;

@RestController
@RequestMapping("/api")
public class RegistrationRestController {
    private RegistService registService;

    public RegistrationRestController(RegistService registService) {
        this.registService = registService;
    }

    public ResponseModel<Void>produceMessageToKafka(@RequestBody RegistrationModel message){
        return this.registService.sendToKafka(message);
    }


}
