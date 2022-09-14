package models.test;

import org.junit.Assert.*;
import models.Cart;
import models.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAddedTest() {
        assertTrue(cart.contains(new Item("Crush", 1.99)));
    }

    @Test
    public void removedItemTest() {
        cart.remove("Crush");
        assertFalse(cart.contains(new Item("Crush", 1.99)));
    }

    @Test
    public void subtotalIsValidTest() {
        assertEquals(3.98, cart.getSubtotal(), 2);
    }

    @Test
    public void taxIsValidTest() {
        assertEquals(0.51, cart.getTax(3.98), 2);
    }

    @Test
    public void totalIsValid() {
        assertEquals(4.49, (cart.getTotal(3.98, 0.51)), 2);
    }

    @Test(expected = IllegalStateException.class)
    public void invalidRemoveState() {
cart.clear();
cart.remove("Pepsi");
    }
}