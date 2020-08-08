package com.example.geektrust.utils;

public class AnagramUtils {

    private static final int CHARACTER_RANGE = 256;

    public static boolean isAnagram(String decryptedMessage, String emblem) {

        //for emblem
        int[] emblemFrequencyCount = new int[CHARACTER_RANGE];
        //for decryptedMessage
        int[] messageFrequencyCount = new int[CHARACTER_RANGE];
        for (int i = 0; i < emblem.length(); i++) {
            emblemFrequencyCount[emblem.charAt(i)]++;
        }

        for (int i = 0; i < decryptedMessage.length(); i++) {
            messageFrequencyCount[decryptedMessage.charAt(i)]++;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (emblemFrequencyCount[i] > messageFrequencyCount[i]) {
                return false;
            }
        }
        return true;
    }

}