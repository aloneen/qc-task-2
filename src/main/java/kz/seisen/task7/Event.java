package kz.seisen.task7;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Event {

    private final long userId;
    private final EventType type;
    private final LocalDateTime timestamp;

    public Event(long userId, EventType type, LocalDateTime timestamp) {
        this.userId = userId;
        this.type = type;
        this.timestamp = timestamp;
    }

    public long getUserId() {
        return userId;
    }

    public EventType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "userId=" + userId +
                ", type=" + type +
                ", timestamp=" + timestamp +
                '}';
    }
}
