package com.abhay.ruleengine.engine;

import com.abhay.ruleengine.events.Event;
import com.abhay.ruleengine.store.EventStore;

/**
 * A Rule combines a condition and an action.
 */
public class Rule {

    private final Condition condition;
    private final Action action;

    public Rule(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    /**
     * Evaluates the rule and executes the action if condition matches.
     */
    public void evaluate(EventStore store, Event event) {
        if (condition.evaluate(store, event)) {
            action.execute(event);
        }
    }
}
