package kz.seisen.task5;

import java.util.List;

public class Task5 {

    public static void main(String[] args) {

        OrderItem item1 = new OrderItem(
                "Laptop",
                Money.of(999.99),
                1
        );

        OrderItem item2 = new OrderItem(
                "Mouse",
                Money.of(25.50),
                2
        );

        Order order = new Order(List.of(item1, item2));

        System.out.println("Total: " + order.totalAmount());
    }
}
