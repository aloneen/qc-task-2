package kz.seisen.task5;

import java.util.List;
import java.util.Objects;

public final class Order {

    private final List<OrderItem> items;

    public Order(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("order must contain items");
        }
        this.items = List.copyOf(items);
    }

    public Money totalAmount() {
        Money total = Money.of(0);
        for (OrderItem item : items) {
            total = total.add(item.totalPrice());
        }
        return total;
    }

    public List<OrderItem> items() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return items.equals(order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
