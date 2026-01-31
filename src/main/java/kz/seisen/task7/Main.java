package kz.seisen.task7;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Event> events = List.of(
                new Event(1, EventType.LOGIN,  LocalDateTime.of(2024, 1, 1, 10, 0)),
                new Event(1, EventType.LOGIN,  LocalDateTime.of(2024, 1, 1, 9, 0)),
                new Event(1, EventType.LOGOUT, LocalDateTime.of(2024, 1, 1, 11, 0)),
                new Event(2, EventType.LOGIN,  LocalDateTime.of(2024, 1, 2, 8, 0)),
                new Event(2, EventType.PURCHASE,  LocalDateTime.of(2024, 1, 3, 8, 0)),
                new Event(2, EventType.PURCHASE,  LocalDateTime.of(2024, 1, 2, 8, 0))
        );

        Map<Long, Map<EventType, List<Event>>> result = EventAggregator.aggregate(events);

        printResult(result);
    }

    private static void printResult(Map<Long, Map<EventType, List<Event>>> data) {
        data.forEach((userId, typeMap) -> {
            System.out.println("User " + userId + ":");
            typeMap.forEach((type, list) -> {
                System.out.println("  " + type + ":");
                list.forEach(event ->
                        System.out.println("    " + event)
                );
            });
            System.out.println();
        });
    }
}
