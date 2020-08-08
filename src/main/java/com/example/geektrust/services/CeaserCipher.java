package com.example.geektrust.services;

import com.example.geektrust.dto.Kingdom;

/*

this interface will handle the function for finding
if the message contains animal name or not

*/
public interface CeaserCipher {

    Boolean validateMessage(Kingdom kingdom, String message);
}