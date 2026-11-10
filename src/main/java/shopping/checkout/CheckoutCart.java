package shopping.checkout;

import java.util.List;

/*
    Part 1 and Part 2 without applying patterns like Strategy
 */
public final class CheckoutCart {
    private final List<CalculatePromotion> promotions;

    public CheckoutCart(List<CalculatePromotion> promotions) {
        this.promotions = promotions;
    }

    public static CheckoutCart withPromotions() {
        return new CheckoutCart(List.of(
                new CalculatePromotion(Item.APPLE,2,1),
                new CalculatePromotion(Item.ORANGE,3,2))
        );
    }

    public static CheckoutCart withoutPromotions() {
        return new CheckoutCart(List.of());
    }

    public String totalPrice(List<String> itemsInCart){
        List<Item> noOfSpecificItems = itemsInCart.stream().map(Item::parseItem).toList();
        return formatPriceToPounds(totalPence(noOfSpecificItems));
    }

    public int totalPence(List<Item> specificItems){
            int discount = promotions.stream()
                    .mapToInt(promotion -> promotion.discount(specificItems))
                    .sum();
            int totalPrice = specificItems.stream().mapToInt(Item::getPriceInPence).sum();
            return totalPrice - discount;
    }

    public static String formatPriceToPounds(int pence) {
        return "£%d.%02d".formatted(pence / 100, pence % 100);
    }

}