package com.md.mini.projects.kafka.basics.bus_line;

import com.md.mini.projects.kafka.basics.kafka.KafkaConfiguration;
import com.md.mini.projects.kafka.basics.kafka.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class BusLineListener implements KafkaConsumer<BusLine> {

    private final Logger logger = LoggerFactory.getLogger(BusLineListener.class);

    @Override
    @KafkaListener(topics = KafkaConfiguration.Topics.BUS_LINES)
    public void listen(ConsumerRecord<String, BusLine> consumerRecord) {
        logConsumedMessage(consumerRecord);
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
