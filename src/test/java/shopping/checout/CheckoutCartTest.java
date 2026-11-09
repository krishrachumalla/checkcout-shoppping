package shopping.checout;

import shopping.checkout.CheckoutCart;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutCartTest {
    private final CheckoutCart checkout = new CheckoutCart();


    @Test
    void tesEmptyCartReturnsZero() {
        assertEquals(0, checkout.calculateTotal(List.of()));
    }

    @Test
    void testTotalCostWhenCartContainsOnlyApples() {
        assertEquals(120,
                checkout.calculateTotal(List.of("Apple","Apple")));
    }

    @Test
    void testTotalCostWhenCartContainsOnlyOranges() {
        assertEquals(50,
                checkout.calculateTotal(List.of("Orange","Orange")));
    }

    @Test
    void testTotalCostOfTheEntireShoppingCart() {
        assertEquals(170,
                checkout.calculateTotal(List.of("Apple","Apple","Orange","Orange")));
    }

    @Test
    void testInvalidTotalCost() {
        assertNotEquals(120,checkout.calculateTotal(List.of("Apple","Orange")));
    }

    @Test
    void testNullCartReturnsZero() {
        assertEquals(0, checkout.calculateTotal(null));
    }
}