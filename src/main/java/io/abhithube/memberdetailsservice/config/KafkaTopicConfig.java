package io.abhithube.memberdetailsservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic registrationTopic() {
        return new NewTopic("registration", 1, (short) 3);
    }
}
