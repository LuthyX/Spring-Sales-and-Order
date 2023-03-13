package com.luti.report_application.kafka;

import com.luti.report_application.model.KafkaOrder;
import com.luti.report_application.repository.KafkaOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private KafkaOrderRepository repository;

    public KafkaConsumer(KafkaOrderRepository repository) {
        this.repository = repository;
    }

    @Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(KafkaOrder order) {
        LOGGER.info(String.format("Json message recieved -> %s", order.toString()));
        repository.save(order);
    }
}
