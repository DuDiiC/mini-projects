package com.md.mini.projects.kafka.basics.bus_line;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus-lines")
class BusLinesController {

    private final BusLinesProducer busLinesProducer;

    public BusLinesController(BusLinesProducer busLinesProducer) {
        this.busLinesProducer = busLinesProducer;
    }

    @PostMapping
    public void addBusLine(@RequestBody BusLine busLine) {
        busLinesProducer.sendPayload(busLine);
    }
}
