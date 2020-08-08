package com.example.geektrust.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramUtilsTest {


    @Test
    public void isAnagramTest() {

        String emblem = "OWL";
        String message = DecryptMessageUtils.decryptSecretMessage("ROZO", 3);
        boolean actual = AnagramUtils.isAnagram(message, emblem);
        assertTrue(actual);
    }
}