package shopping.checout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shopping.checkout.Item;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest
{
    @ParameterizedTest
    @ValueSource(strings = {"Apple","APPLE","apple"})
    public void parseAppleItemIgnoringCase(String item){
        assertEquals(Item.APPLE,Item.parseItem(item));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Orange","ORANGE","orange"})
    public void parseOrangeItemIgnoringCase(String item){
        assertEquals(Item.ORANGE,Item.parseItem(item));
    }

    @Test
    public void rejectInvalidItems(){
        assertThrows(IllegalArgumentException.class, () -> Item.parseItem("CustardApple"));
    }





}
