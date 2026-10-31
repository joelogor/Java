package json;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CustomJsonEncoderTest {

    @Test
    public void testCanSerializeToJson() {
        try {
            Product product = new Product();
            product.setName("iphone 20");
            product.setDescription("a london used very, very new iphone 20");
            product.setPrice(new BigDecimal("2000000.00"));
            product.setQuantity(100);
            String json = CustomJsonEncoder.serializeToJson(product);
            String expected = "{\"name\":\"iphone 20\",\"description\":\"a london used very, very new iphone 20\",\"price\":2000000.00,\"quantity\":100}";
            assertEquals(expected, json);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    @Test
    public void testCanDeserializeFromJson() {
        try {
            String json = "{\"name\": \"Musa\", \"description\":\"a musa\",\"price\":2000000.00,\"quantity\":100}";
            Product product = CustomJsonEncoder.deserializeFrom(json);
            assertEquals("Musa", product.getName());
            assertEquals("a musa", product.getDescription());
            assertEquals(new BigDecimal("2000000.00"), product.getPrice());
            assertEquals(100, product.getQuantity());
        }catch (JsonSerializationException exception) {
            exception.printStackTrace();
        }

    }
}
