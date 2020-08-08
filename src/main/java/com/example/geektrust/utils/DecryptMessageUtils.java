package com.example.geektrust.utils;

public class DecryptMessageUtils {

    public static String decryptSecretMessage(String message, int key) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isAlphabetic(message.charAt(i)) && Character.isUpperCase(message.charAt(i))) {
                int shiftedValue = ((int) message.charAt(i) - 65 - key);
                if (shiftedValue < 0) {
                    shiftedValue += 26;
                }
                char ch = (char) (shiftedValue + 65);
                decryptedMessage.append(ch);
            } else if (Character.isAlphabetic(message.charAt(i))) {
                char ch = (char) (((int) message.charAt(i) - 97 - key) % 26 + 97);
                decryptedMessage.append(ch);

            }
        }
        return decryptedMessage.toString();
    }

}