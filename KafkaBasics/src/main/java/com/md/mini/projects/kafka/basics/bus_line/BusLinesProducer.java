package com.md.mini.projects.kafka.basics.bus_line;

import com.md.mini.projects.kafka.basics.kafka.KafkaConfiguration;
import com.md.mini.projects.kafka.basics.kafka.KafkaProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
class BusLinesProducer extends KafkaProducer<BusLine> {

    protected BusLinesProducer(KafkaTemplate<String, BusLine> kafkaTemplate) {
        super(kafkaTemplate, KafkaConfiguration.Topics.BUS_LINES);
    }
}
