package com.example.geektrust.services;

import com.example.geektrust.dto.Kingdom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CeaserCipherImplTest {

    @Test
    public void validateMessageTest() {
        CeaserCipher ceaserCipher = new CeaserCipherImpl();
        Kingdom kingdom = new Kingdom("LAND", "PANDA");
        String message = "FAIJWJSOOFAMAU";
        boolean actual = ceaserCipher.validateMessage(kingdom, message);
        assertTrue(actual);
    }
}