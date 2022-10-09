package com.md.mini.projects.kafka.basics.bus_stop;

import com.md.mini.projects.kafka.basics.kafka.KafkaConfiguration;
import com.md.mini.projects.kafka.basics.kafka.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class BusStopDefinitionsListener implements KafkaConsumer<BusStopDefinition> {

    private final Logger logger = LoggerFactory.getLogger(BusStopDefinitionsListener.class);

    @Override
    @KafkaListener(topics = KafkaConfiguration.Topics.BUS_STOP_DEFINITIONS)
    public void listen(ConsumerRecord<String, BusStopDefinition> consumerRecord) {
        logConsumedMessage(consumerRecord);
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
