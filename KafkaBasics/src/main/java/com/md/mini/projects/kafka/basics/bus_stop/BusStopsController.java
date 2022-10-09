package com.md.mini.projects.kafka.basics.bus_stop;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus-stop-definitions")
class BusStopsController {

    private final BusStopDefinitionsProducer busStopDefinitionsProducer;

    public BusStopsController(BusStopDefinitionsProducer busStopDefinitionsProducer) {
        this.busStopDefinitionsProducer = busStopDefinitionsProducer;
    }

    @PostMapping
    public void addBusStopDefinition(@RequestBody BusStopDefinition busStopDefinition) {
        busStopDefinitionsProducer.sendPayload(busStopDefinition);
    }
}
