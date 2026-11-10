package shopping.checkout;

import java.util.Collections;
import java.util.List;
/*
    Calculate and return the promotion offer in pence
 */
public record CalculatePromotion(Item item, int noOfItems, int offerItemCount) implements ItemPromotion {

    public static CalculatePromotion twoForOne(Item item) {
        return new CalculatePromotion(item, 2, 1);
    }

    public static CalculatePromotion threeForTwo(Item item) {
        return new CalculatePromotion(item, 3, 2);
    }

    @Override
    public int discount(List<Item> itemsInCart) {
        int itemCount = Collections.frequency(itemsInCart, item);
        int offerCount = itemCount/noOfItems;
        return offerCount * (noOfItems-offerItemCount) * item.getPriceInPence();
    }
}
