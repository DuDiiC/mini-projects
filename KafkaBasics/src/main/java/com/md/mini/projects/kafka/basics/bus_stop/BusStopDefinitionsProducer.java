package com.md.mini.projects.kafka.basics.bus_stop;

import com.md.mini.projects.kafka.basics.kafka.KafkaConfiguration;
import com.md.mini.projects.kafka.basics.kafka.KafkaProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
class BusStopDefinitionsProducer extends KafkaProducer<BusStopDefinition> {

    protected BusStopDefinitionsProducer(KafkaTemplate<String, BusStopDefinition> kafkaTemplate) {
        super(kafkaTemplate, KafkaConfiguration.Topics.BUS_STOP_DEFINITIONS);
    }
}