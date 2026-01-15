package com.abhay.ruleengine.engine;

import com.abhay.ruleengine.events.Event;

/**
 * An Action represents a side-effect
 * that is executed when a rule triggers.
 */
public interface Action {

    /**
     * Executes the action.
     *
     * @param event the event that triggered the action
     */
    void execute(Event event);
}
