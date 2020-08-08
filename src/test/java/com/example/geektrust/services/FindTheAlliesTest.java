package com.example.geektrust.services;

import com.example.geektrust.controller.TameOfThronesController;
import com.example.geektrust.dto.Kingdom;
import com.example.geektrust.dto.SecretMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class FindTheAlliesTest {

    @InjectMocks
    FindTheAllies findtheallies;

    @Mock
    CeaserCipher ceasercipher;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findTheAlliesTest() throws IOException {
        //return true
        Mockito.when(ceasercipher.validateMessage(any(), any())).thenReturn(true);

        List<Kingdom> kingdoms = TameOfThronesController.initialisation();
        //List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        //kingdoms.add(new Kingdom("LAND","PANDA"));
        //kingdoms.add(new Kingdom("ICE","MAMMOTH"));
        //kingdoms.add(new Kingdom("FIRE","DRAGON"));

        List<SecretMessage> input = new ArrayList<SecretMessage>();
        input.add(new SecretMessage("LAND", "FAIJWJSOOFAMAU"));
        input.add(new SecretMessage("ICE", "STHSTSTVSASOS"));
        input.add(new SecretMessage("FIRE", "JXGOOMUTOO"));

        List<String> expected = new ArrayList<String>();
        expected.add("LAND");
        expected.add("ICE");
        expected.add("FIRE");

        List<String> actual = findtheallies.findTheAllies(kingdoms, input);
        assertEquals(3, actual.size());
        assertEquals(expected, actual);
    }
}