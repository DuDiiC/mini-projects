package com.md.mini.projects.kafka.basics.bus_line;

import com.md.mini.projects.kafka.basics.kafka.KafkaPayload;

record BusLine(
        Long number,
        BusLineType type
) implements KafkaPayload {
}
