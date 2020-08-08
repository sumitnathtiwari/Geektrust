package com.example.geektrust;

import com.example.geektrust.controller.TameOfThronesController;

import java.io.IOException;

public class TameOfThroneApplication {

    public static void main(final String[] args) throws
            IOException {
        if (args.length == 0) {
            throw new RuntimeException("No file Path Provided As Argument");
        } else {
            TameOfThronesController.processing(args[0]);
        }
    }

}
