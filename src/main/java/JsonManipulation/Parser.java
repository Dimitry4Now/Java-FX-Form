package JsonManipulation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Parser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <E> E fromJson(JsonNode node, Class<E> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }
}
