package cphb;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 */
public class Order {

    private List<Pizza> pizzas = new ArrayList<>();
    private OrderStatus status;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}