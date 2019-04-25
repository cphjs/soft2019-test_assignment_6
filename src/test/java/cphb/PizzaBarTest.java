package cphb;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * PizzaBarTest
 */
public class PizzaBarTest {

    private static Container container;

    private PizzaBar pizzaBar;

    @BeforeAll
    public static void setUp() throws Exception {
        container = new Container();
        container.load();
    }

    @BeforeEach
    public void setUpEach() {
        pizzaBar = new PizzaBar(container.get(OrderDataStore.class));
    }

    @Test
    public void testNewOrderReturnsEmptyOrder() {
        Order order = pizzaBar.newOrder();

        assertNotNull(order);
        assertTrue(order.getPizzas().isEmpty());
    }

    @Test
    public void testPlaceOrderSetStatus() {
        Order order = mock(Order.class);

        pizzaBar.placeOrder(order);
        verify(order).setStatus(OrderStatus.PENDING);
    }

    @Test
    public void testPlaceOrderAddsOrderToQueue() {
        Order order = mock(Order.class);

        pizzaBar.placeOrder(order);

        assertTrue(pizzaBar.getOrders().size() == 1);
    }

    @Test
    public void testRemoveOrderRemovesOrderFromQueue() {
        Order order = mock(Order.class);

        pizzaBar.placeOrder(order);
        pizzaBar.removeOrder(order);

        assertTrue(pizzaBar.getOrders().size() == 0);
    }
}