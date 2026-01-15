package com.abhay.backendapi.controller;

import com.abhay.backendapi.dto.EventRequest;
import com.abhay.ruleengine.engine.RuleEngine;
import com.abhay.ruleengine.events.Event;
import com.abhay.ruleengine.events.EventType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private final RuleEngine ruleEngine;

    public EventController(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    @PostMapping("/login-failed")
    public String loginFailed(@RequestBody EventRequest request) {
        ruleEngine.process(new Event(
                EventType.LOGIN_FAILED,
                request.getEntityId(),
                System.currentTimeMillis()
        ));
        return "Login failure event processed";
    }

    @PostMapping("/cpu-high")
    public String cpuHigh(@RequestBody EventRequest request) {
        ruleEngine.process(new Event(
                EventType.CPU_HIGH,
                request.getEntityId(),
                System.currentTimeMillis()
        ));
        return "CPU high event processed";
    }
}
