import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

class ParseItemAndQuantityTest {

    @Test
    public void testParseItemAndQuantity_validInput() {
        Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity("Cherry Sapling 20");
        assertNotNull(result);
        assertEquals("Cherry Sapling", result.getKey());
        assertEquals(20, result.getValue());
    }

    @Test
    public void testParseItemAndQuantity_missingQuantity() {
        Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity("Cherry Sapling");
        assertNull(result);
    }

    @Test
    public void testParseItemAndQuantity_negativeQuantity() {
        Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity("Cherry Sapling -5");
        assertNull(result);
    }

    @Test
    public void testParseItemAndQuantity_nonNumericQuantity() {
        Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity("Cherry Sapling abc");
        assertNull(result);
    }

    @Test
    public void testParseItemAndQuantity_extrasSpaces() {
        Map.Entry<String, Integer> result = Helpers.parseItemAndQuantity("   Cherry       Sapling     10");

        assertNotNull(result);
        assertEquals("Cherry Sapling", result.getKey());
        assertEquals(10, result.getValue());
    }
}