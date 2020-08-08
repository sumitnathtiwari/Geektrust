package com.example.geektrust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class SecretMessage {

    @NonNull
    private String kingdomName;
    private String message;
}