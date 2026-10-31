package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomJsonEncoder {

    public static String serializeToJson(Product product) throws JsonSerializationException {
       try {
           ObjectMapper mapper = new ObjectMapper();
           return mapper.writeValueAsString(product);
       }catch (JsonProcessingException exception){
           exception.printStackTrace();
           throw new JsonSerializationException(
                   String.format("failed to encode product to json\nreason: %s", exception.getMessage())
           );
       }

    }
    public static Product deserializeFrom(String json) throws JsonSerializationException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Product.class);
        }catch (JsonProcessingException exception) {
            exception.printStackTrace();
            throw new JsonSerializationException(exception.getMessage());
        }
    }


}
