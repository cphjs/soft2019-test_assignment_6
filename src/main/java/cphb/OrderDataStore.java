package cphb;

import java.util.List;

/**
 * OrderDataStore
 */
public interface OrderDataStore {

    public boolean addOrder(Order order);
    
    public List<Order> getOrders();
    
    public boolean removeOrder(Order order);
}

