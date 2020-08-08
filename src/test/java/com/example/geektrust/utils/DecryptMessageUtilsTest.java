package com.example.geektrust.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecryptMessageUtilsTest {


    @Test
    public void decryptSecretMessageTest() {

        String message = "ROZO";
        String expected = "OLWL";
        int key = 3;
        String actual = DecryptMessageUtils.decryptSecretMessage(message, key);

        assertEquals(expected, actual);
    }
}