package com.md.mini.projects.kafka.basics.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.slf4j.Logger;

import java.time.Instant;
import java.util.stream.StreamSupport;

public interface KafkaConsumer<T extends KafkaPayload> {

    void listen(ConsumerRecord<String, T> consumerRecord);

    default String extractHeaderValue(Headers headers, String headerKey) {
        return StreamSupport.stream(headers.spliterator(), false)
                .filter(header -> header.key().equals(headerKey))
                .findFirst()
                .map(header -> new String(header.value()))
                .orElse("N/A");
    }

    default void logConsumedMessage(ConsumerRecord<String, T> consumerRecord) {
        getLogger().info("Received message:\nKey: {}, type: {}, timestamp {}, producer: {},\nvalue: {}",
                consumerRecord.key(),
                extractHeaderValue(consumerRecord.headers(), KafkaConfiguration.Headers.TYPE_ID_KEY),
                Instant.ofEpochMilli(consumerRecord.timestamp()),
                extractHeaderValue(consumerRecord.headers(), KafkaConfiguration.Headers.PRODUCER_APP_KEY),
                consumerRecord.value().toString()
        );
    }

    Logger getLogger();
}
