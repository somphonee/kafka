package priorsorution.co.th.produder.kafka.component.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {
    @Value("${kafka.server}")
    private String server;


    @Bean
    public Map<String, Object> settingProducerConfigs(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return props;

    }
    @Bean
    public ProducerFactory<String, String> generateProducerFactory(){

        return  new DefaultKafkaProducerFactory<>(settingProducerConfigs());
    }
    @Bean(name = "registerKafkaTemplate")
    public KafkaTemplate<String, String> registerKafkaTemplate(){

        return new KafkaTemplate<>(generateProducerFactory());
    }





}
