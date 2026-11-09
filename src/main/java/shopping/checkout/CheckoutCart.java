package shopping.checkout;

import java.util.List;

/*
    Part 1 without applying patterns like Strategy
 */
public class CheckoutCart {
    private static final int COST_OF_APPLE = 60;
    private static final int COST_OF_ORANGE = 25;

    public int calculateTotal(List<String> items) {
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

        int appleTotal = apples * COST_OF_APPLE;

        int orangeTotal = oranges * COST_OF_ORANGE;

        return appleTotal + orangeTotal;
    }

    public static void main(String[] args) {
        CheckoutCart checkout = new CheckoutCart();

        List<String> items = List.of(
                "Orange", "Apple", "Orange", "Apple"
        );

        int total = checkout.calculateTotal(items);

        System.out.printf(
                "Total: £%.2f%n", total / 100.0
        );
    }
}