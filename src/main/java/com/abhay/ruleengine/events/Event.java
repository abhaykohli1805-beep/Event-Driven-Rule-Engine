package com.abhay.ruleengine.events;

/**
 * Immutable representation of a system event.
 */
public class Event {

    private final EventType type;
    private final String entityId;
    private final long timestamp;

    public Event(EventType type, String entityId, long timestamp) {
        this.type = type;
        this.entityId = entityId;
        this.timestamp = timestamp;
    }

    public EventType getType() {
        return type;
    }

    public String getEntityId() {
        return entityId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

