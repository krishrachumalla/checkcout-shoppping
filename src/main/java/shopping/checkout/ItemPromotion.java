package shopping.checkout;

import java.util.List;

public interface ItemPromotion {
    //item discount in pence
    int discount(List<Item> items);
}
