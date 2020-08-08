package com.example.geektrust.controller;

import com.example.geektrust.dto.Kingdom;
import com.example.geektrust.dto.SecretMessage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TameOfThronesControllerTest {

    @Test
    public void readDataTest() throws FileNotFoundException {
        String path = "testinput.txt";
        List<SecretMessage> actual = TameOfThronesController.readData(path);
        assertEquals(4, actual.size());
    }

    @Test
    public void initialisationTest() throws IOException {
        List<Kingdom> kingdoms = TameOfThronesController.initialisation();
        assertEquals(6, kingdoms.size());
    }

}