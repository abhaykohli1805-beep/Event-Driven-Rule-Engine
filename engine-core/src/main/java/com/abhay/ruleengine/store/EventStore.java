package com.abhay.ruleengine.store;

import com.abhay.ruleengine.events.Event;
import com.abhay.ruleengine.events.EventType;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores events and allows querying based on time and entity.
 */
public class EventStore {

    private final List<Event> events = new ArrayList<>();

    /**
     * Adds an event to the store.
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Counts events of a specific type for an entity since a given time.
     */
    public long countEvents(EventType type, String entityId, long sinceTimestamp) {
        return events.stream()
                .filter(event -> event.getType() == type)
                .filter(event -> event.getEntityId().equals(entityId))
                .filter(event -> event.getTimestamp() >= sinceTimestamp)
                .count();
    }
}
