package com.example.geektrust.services;

import com.example.geektrust.dto.Kingdom;
import com.example.geektrust.dto.SecretMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindTheAllies {

    private final CeaserCipher ceaserCipher = new CeaserCipherImpl();

    public List<String> findTheAllies(List<Kingdom> kingdoms, List<SecretMessage> secretMessages) {

        //will store the object of the different kingdom 
        //so that we can easily find them with input file string
        HashMap<String, Kingdom> map = createAndFillMap(kingdoms);

        //it will handle if there were duplicates kingdom
        HashSet<String> duplicates = new HashSet<String>();

        //it will store the output which we will print on console
        List<String> output = new ArrayList<String>();

        for (SecretMessage secretMessage : secretMessages) {

            String kingdomName = secretMessage.getKingdomName();
            if (map.containsKey(kingdomName)
                    && !duplicates.contains(kingdomName)) {

                boolean isAlly = ceaserCipher
                        .validateMessage(map.get(kingdomName),
                                secretMessage.getMessage());

                if (isAlly) {
                    output.add(kingdomName);
                    duplicates.add(kingdomName);
                }

            }
        }
        return output;
    }

    //will print the data on console
    public static void printOnConsole(List<String> output) {

        if (output.size() < 3) {
            System.out.println("NONE");
        } else {

            System.out.print("SPACE");

            for (String str : output) {
                System.out.print(" " + str);
            }
        }

    }

    public static HashMap<String, Kingdom> createAndFillMap(List<Kingdom> kingdoms) {
        HashMap<String, Kingdom> map = new HashMap<String, Kingdom>();
        for (Kingdom kingdom : kingdoms) {
            map.put(kingdom.getKingdom(), kingdom);
        }
        return map;
    }
}