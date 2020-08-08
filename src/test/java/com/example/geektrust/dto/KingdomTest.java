package com.example.geektrust.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class KingdomTest {

    @Test
    public void serializeAndDeserializeKingdomJsonTest()
            throws IOException, JSONException {
        //jackson based json to pojo
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        java.io.InputStream inputStream = classLoader.getResourceAsStream("initial_data_kingdom.json");

        String expected = IOUtils.toString(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8.name());

        List<Kingdom> kingdom = mapper.readValue(expected, new TypeReference<List<Kingdom>>() {
        });

        String actual = mapper.writeValueAsString(kingdom);

        JSONAssert.assertEquals(expected, actual, false);
    }
}