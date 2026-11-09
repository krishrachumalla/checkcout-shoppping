package shopping.checout;

import shopping.checkout.CheckoutCart;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutCartTest {
    private final CheckoutCart checkout = new CheckoutCart();


    @Test
    void tesEmptyCartReturnsZero() {
        assertEquals(0, checkout.calculateTotal(List.of(),false,false));
    }

    @Test
    void testTotalCostWhenCartContainsOnlyApples() {
        assertEquals(120,
                checkout.calculateTotal(List.of("Apple","Apple"),false,false));
    }

    @Test
    void testTotalCostWhenCartContainsOnlyOranges() {
        assertEquals(50,
                checkout.calculateTotal(List.of("Orange","Orange"),false,false));
    }

    @Test
    void testTotalCostOfTheEntireShoppingCart() {
        assertEquals(170,
                checkout.calculateTotal(List.of("Apple","Apple","Orange","Orange"),false,false));
    }

    @Test
    void testInvalidTotalCost() {
        assertNotEquals(120,checkout.calculateTotal(List.of("Apple","Orange"),false,false));
    }

    @Test
    void testNullCartReturnsZero() {
        assertEquals(0, checkout.calculateTotal(null,false,false));
    }

    @Test
    void testTotalCostWhenCartContainsOnlyApplesWithOffer() {
        assertEquals(60,
                checkout.calculateTotal(List.of("Apple","Apple"),true,false));
    }

    @Test
    void testTotalCostWhenCartContainsOnlyOrangesWithOffer() {
        assertEquals(100,
                checkout.calculateTotal(List.of("Orange","Orange","Orange","Orange","Orange"),false,true));
    }

    @Test
    void testTotalCostOfTheEntireShoppingCartWithOffer() {
        assertEquals(110,
                checkout.calculateTotal(List.of("Apple","Apple","Orange","Orange"),true,true));
    }
}