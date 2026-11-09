package shopping.checkout;

import java.util.List;

/*
    Part 1 and Part 2 without applying patterns like Strategy
 */
public class CheckoutCart {
    private static final int COST_OF_APPLE = 60;
    private static final int COST_OF_ORANGE = 25;

    public int calculateTotal(List<String> items, boolean appleOffer, boolean orangeOffer) {
        if (items == null || items.isEmpty()) {
            return 0;
        }

        int apples = 0;
        int oranges = 0;

        for (String item : items) {
            if (item.equalsIgnoreCase("apple")) {
                apples++;
            }else if (item.equalsIgnoreCase("orange")) {
                oranges++;
            }else {
                return 0;
            }
        }
        apples = apples!=0 && appleOffer?apples/2:apples;
        oranges = oranges!=0 && orangeOffer?((oranges / 3) * 2 + oranges % 3):oranges;
        int appleTotal = apples * COST_OF_APPLE;
        int orangeTotal = oranges * COST_OF_ORANGE;

        return appleTotal + orangeTotal;
    }

    public static void main(String[] args) {
        CheckoutCart checkout = new CheckoutCart();

        List<String> items = List.of(
                "Orange", "Apple", "Orange", "Apple"
        );

        int totalWithoutOffer = checkout.calculateTotal(items,false,false);
        int totalWithOffer = checkout.calculateTotal(items, true, true);

        System.out.printf(
                "Total: £%.2f%n", totalWithoutOffer / 100.0
        );

        System.out.printf(
                "Total: £%.2f%n", totalWithOffer / 100.0
        );
    }
}