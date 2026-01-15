package com.abhay.ruleengine.engine;

import com.abhay.ruleengine.events.Event;
import com.abhay.ruleengine.store.EventStore;

/**
 * A Condition defines the logic that decides
 * whether a rule should be triggered.
 */
public interface Condition {

    /**
     * Evaluates the condition using current and past events.
     *
     * @param store        event history store
     * @param currentEvent the event currently being processed
     * @return true if condition is satisfied
     */
    boolean evaluate(EventStore store, Event currentEvent);
}
