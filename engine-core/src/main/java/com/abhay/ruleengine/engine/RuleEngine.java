package com.abhay.ruleengine.engine;

import com.abhay.ruleengine.events.Event;
import com.abhay.ruleengine.store.EventStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Core engine that processes events and evaluates rules.
 */
public class RuleEngine {

    private final List<Rule> rules;
    private final EventStore eventStore;

    public RuleEngine() {
        this.rules = new ArrayList<>();
        this.eventStore = new EventStore();
    }

    /**
     * Registers a rule with the engine.
     */
    public void registerRule(Rule rule) {
        rules.add(rule);
    }

    /**
     * Processes an incoming event.
     */
    public void process(Event event) {
        eventStore.addEvent(event);

        for (Rule rule : rules) {
            rule.evaluate(eventStore, event);
        }
    }
}
