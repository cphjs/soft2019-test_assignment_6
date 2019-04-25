package cphb;

import java.util.List;

/**
 * DatabaseOrderDataStore
 */
public class DatabaseOrderDataStore implements OrderDataStore {

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public boolean removeOrder(Order order) {
        return false;
    }

    
}