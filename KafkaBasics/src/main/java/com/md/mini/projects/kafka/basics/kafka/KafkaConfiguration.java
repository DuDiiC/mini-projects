package com.md.mini.projects.kafka.basics.kafka;

public interface KafkaConfiguration {

    String PRODUCER_NAME = "KafkaBasics-localhost";

    interface Topics {
         String BUS_STOP_DEFINITIONS = "bus.stop.definitions";
         String BUS_LINES = "bus.lines";
    }

    interface Headers {
        // custom header instead of standard __TypeId__ because https://stackoverflow.com/q/73999912/8653765
        String TYPE_ID_KEY = "__ModelTypeId__";
        String PRODUCER_APP_KEY = "__ProducerApp__";
    }
}
