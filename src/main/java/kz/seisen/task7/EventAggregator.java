package kz.seisen.task7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventAggregator {

    public static Map<Long, Map<EventType, List<Event>>> aggregate(List<Event> events) {

        Map<Long, Map<EventType, List<Event>>> result = new HashMap<>();

        events.stream()
                .sorted(Comparator.comparing(Event::getTimestamp))
                .forEach(event ->
                        result.computeIfAbsent(event.getUserId(), k -> new HashMap<>())
                                .computeIfAbsent(event.getType(), k -> new ArrayList<>())
                                .add(event)
                );

        return result;
    }
}
