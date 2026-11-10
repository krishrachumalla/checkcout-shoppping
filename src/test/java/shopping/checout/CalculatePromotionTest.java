package shopping.checout;


import org.junit.jupiter.api.Test;
import shopping.checkout.CalculatePromotion;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static shopping.checkout.Item.ORANGE;
import static shopping.checkout.Item.APPLE;

public class CalculatePromotionTest {
    private final CalculatePromotion twoForOne =
            CalculatePromotion. twoForOne(APPLE);
    private final CalculatePromotion threeForTwo =
            CalculatePromotion.threeForTwo(ORANGE);

    @Test
    void nooDiscountOnEmptyShoppingCart() {
        assertEquals(0,twoForOne.discount(List.of()));
    }

    @Test
    void noDiscountOnItemsLessThanEligibleCount() {
        assertEquals(0,twoForOne.discount(List.of(APPLE)));
        assertEquals(0,threeForTwo.discount(List.of(ORANGE, ORANGE)));
    }

    @Test
    void discountsOnEligibleCountOfTheItems() {
        assertEquals(60,twoForOne.discount(List.of(APPLE, APPLE)));
        assertEquals(25,threeForTwo.discount(List.of(ORANGE, ORANGE, ORANGE)));
    }

 }
