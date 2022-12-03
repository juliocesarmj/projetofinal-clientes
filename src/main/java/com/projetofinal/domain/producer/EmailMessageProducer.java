package com.projetofinal.domain.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailMessageProducer {

    @Value("${topic.name.producer}")
    private String topico;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        new Thread() {
            @Override
            public void run() {
                kafkaTemplate.send(topico, message);
            }
        }.start();
    }
}
