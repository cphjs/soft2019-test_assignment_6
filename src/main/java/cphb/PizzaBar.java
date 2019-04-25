package cphb;

import java.util.List;

/**
 * PizzaBar
 */
public class PizzaBar {

    private OrderDataStore orderStore;

    public PizzaBar(OrderDataStore store) {
        this.orderStore = store;
    }

    public Order newOrder() {
        return new Order();
    }

    public void placeOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        orderStore.addOrder(order);
    }

    public List<Order> getOrders() {
        return orderStore.getOrders();
    }

    public boolean removeOrder(Order order) {
        order.setStatus(OrderStatus.FINISHED);
        return orderStore.removeOrder(order);
    }
}