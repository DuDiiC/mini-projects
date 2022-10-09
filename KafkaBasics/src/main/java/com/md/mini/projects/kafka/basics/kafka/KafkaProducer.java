package com.md.mini.projects.kafka.basics.kafka;

import de.huxhorn.sulky.ulid.ULID;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.charset.StandardCharsets;

public abstract class KafkaProducer<T extends KafkaPayload> {

    private final KafkaTemplate<String, T> kafkaTemplate;
    private final String topicName;

    protected KafkaProducer(KafkaTemplate<String, T> kafkaTemplate, String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendPayload(T payload) {
        var producerRecord = new ProducerRecord<>(topicName, new ULID().nextULID(), payload);
        producerRecord.headers().add(KafkaConfiguration.Headers.TYPE_ID_KEY,
                payload.getClass().getCanonicalName().getBytes(StandardCharsets.UTF_8));
        producerRecord.headers().add(KafkaConfiguration.Headers.PRODUCER_APP_KEY,
                KafkaConfiguration.PRODUCER_NAME.getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(producerRecord);
    }
}
