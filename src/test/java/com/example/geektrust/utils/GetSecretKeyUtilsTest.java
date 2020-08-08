package com.example.geektrust.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetSecretKeyUtilsTest {

    @Test
    public void findSecretKeyTest() {

        {
            String emblem = "owl";
            int key = GetSecretKeyUtils.findSecretKey(emblem);
            assertEquals(3, key);
        }

        {
            String emblem = "abcdefghijklmnopqrstuvwxyza";
            int key = GetSecretKeyUtils.findSecretKey(emblem);
            assertEquals(1, key);
        }

    }
}