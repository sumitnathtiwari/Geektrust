package com.example.geektrust.utils;

public class GetSecretKeyUtils {

    public static int findSecretKey(final String message) {
        return (message.length() % 26);
    }
}