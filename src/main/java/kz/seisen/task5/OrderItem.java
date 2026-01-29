package kz.seisen.task5;

import java.util.Objects;

public final class OrderItem {

    private final String productName;
    private final Money price;
    private final int quantity;

    public OrderItem(String productName, Money price, int quantity) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        Objects.requireNonNull(price, "price is required");
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantiiy must be positive");
        }

        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Money totalPrice() {
        return price.multiply(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem that = (OrderItem) o;
        return quantity == that.quantity &&
                productName.equals(that.productName) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, quantity);
    }
}
