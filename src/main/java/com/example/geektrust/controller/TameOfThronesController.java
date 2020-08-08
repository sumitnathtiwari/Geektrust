package com.example.geektrust.controller;

import com.example.geektrust.dto.Kingdom;
import com.example.geektrust.dto.SecretMessage;
import com.example.geektrust.services.FindTheAllies;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//controller class to handle all the processing

public class TameOfThronesController {

    static final ObjectMapper mapper = new ObjectMapper();
    static final FindTheAllies findTheAllies = new FindTheAllies();
    static final ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    // this method will read data from the txt file
    public static List<SecretMessage> readData(String path) throws FileNotFoundException {

        Scanner input = new Scanner(new File(path));

        List<SecretMessage> secretMessages = new ArrayList<SecretMessage>();
        while (input.hasNext()) {
            String name = input.next();
            String message = input.nextLine();
            SecretMessage secretMessage = new SecretMessage(name.toUpperCase(), message.toUpperCase());
            secretMessages.add(secretMessage);
        }
        input.close();
        return secretMessages;
    }

    // this will process the data and logic
    //this will handle all the calling
    public static void processing(String path) throws IOException {

        List<SecretMessage> secretMessages = readData(path);
        List<Kingdom> kingdoms = initialisation();

        List<String> output = findTheAllies.findTheAllies(kingdoms, secretMessages);
        FindTheAllies.printOnConsole(output);
    }

    //this will initialise the data with default kingdom and emblem
    public static List<Kingdom> initialisation() throws
            IOException {
        InputStream secretMessage = classLoader.getResourceAsStream("initial_data_kingdom.json");
        return mapper.readValue(secretMessage, new TypeReference<List<Kingdom>>() {
        });
    }
}