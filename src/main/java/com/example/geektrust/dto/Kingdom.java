package com.example.geektrust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kingdom {
    @NonNull
    private String kingdom;
    @NonNull
    private String emblem;

}