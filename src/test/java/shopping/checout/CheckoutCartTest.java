package shopping.checout;

import org.junit.jupiter.api.Nested;
import shopping.checkout.CheckoutCart;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static shopping.checkout.Item.APPLE;
import static shopping.checkout.Item.ORANGE;

public class CheckoutCartTest {
    @Nested
    class WithoutPromotions {

        private final CheckoutCart checkout = CheckoutCart.withoutPromotions();

        @Test
        void emptyShoppingCartCostsZeroPence() {
            assertEquals(0,checkout.totalPence(List.of()));
        }

        @Test
        void applesCost60pEach() {
            assertEquals(60,checkout.totalPence(List.of(APPLE)));
        }

        @Test
        void orangesCost25pEach() {
            assertEquals(25,checkout.totalPence(List.of(ORANGE)));
        }

        @Test
        void totalValueOfTheShoppingCart() {
            assertEquals(170,checkout.totalPence(List.of(APPLE, APPLE, ORANGE, ORANGE)));
        }

        @Test
        void totalShoppingCartInPounds() {
            assertEquals("£1.95",checkout.totalPrice(List.of("Apple","Orange","Apple","Orange","orange")));
        }
    }

    @Nested
    class WithPromotions {

        private final CheckoutCart checkout = CheckoutCart.withPromotions();

        @Test
        void emptyShoppingCartCostsZeroPence() {
            assertEquals(0,checkout.totalPence(List.of()));
        }

        @Test
        void singleAppleIsFullPrice() {
            assertEquals(60,checkout.totalPence(List.of(APPLE)));
        }

        @Test
        void twoForOneApples() {
            assertEquals(60,checkout.totalPence(List.of(APPLE, APPLE)));
        }

        @Test
        void oddNumberOfApplesPaysForTheExtraOne() {
            assertEquals(120,checkout.totalPence(List.of(APPLE, APPLE, APPLE)));
        }

        @Test
        void threeForTwoOnOranges() {
            assertEquals(50,checkout.totalPence(List.of(ORANGE, ORANGE, ORANGE)));
        }

        @Test
        void oneAppleInCartCostWithPromotions() {
            assertEquals("£0.60",checkout.totalPrice(List.of("Apple")));
        }

        @Test
        void twoOrangesInCartCostWithPromotions() {
            assertEquals("£0.50",checkout.totalPrice(List.of("Orange","Orange")));
        }

        @Test
        void totalShoppingCartInPounds() {
            assertEquals("£1.10",checkout.totalPrice(List.of("Apple","Orange","Apple","Orange","orange")));
        }

    }

}