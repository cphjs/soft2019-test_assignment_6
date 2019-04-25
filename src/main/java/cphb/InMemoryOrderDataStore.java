package cphb;

import java.util.ArrayList;
import java.util.List;

/**
 * InMemoryOrderDataStore
 */
public class InMemoryOrderDataStore implements OrderDataStore {

    private List<Order> orders = new ArrayList<>();

    @Override
    public boolean addOrder(Order order) {
        return orders.add(order);
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean removeOrder(Order order) {
        return orders.remove(order);
    }

    
}