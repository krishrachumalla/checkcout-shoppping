package shopping.checkout;

import java.util.Locale;

public enum Item
{
    APPLE(60),
    ORANGE(25);

    private final int priceInPence;

    Item(int priceInPence)
    {
        this.priceInPence = priceInPence;
    }

    public int getPriceInPence()
    {
        return priceInPence;
    }

    public static Item parseItem(String item)
    {
        if(item==null || item.isEmpty()){
            throw new IllegalArgumentException("item cannot be null or empty");
        }
        try{
            return Item.valueOf(item.toUpperCase(Locale.ROOT));
        }catch(IllegalArgumentException ex){
            throw new IllegalArgumentException("");
        }
    }
}
