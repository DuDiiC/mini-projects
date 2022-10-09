package com.md.mini.projects.kafka.basics.bus_stop;

import com.md.mini.projects.kafka.basics.kafka.KafkaPayload;

import java.util.List;

record BusStopDefinition(
        String stopName,
        String street,
        GPSCoordinates coordinates,
        List<String> busLineIds
) implements KafkaPayload {
}
