package com.example.geektrust.services;

import com.example.geektrust.dto.Kingdom;
import com.example.geektrust.utils.AnagramUtils;
import com.example.geektrust.utils.DecryptMessageUtils;
import com.example.geektrust.utils.GetSecretKeyUtils;
import org.jetbrains.annotations.NotNull;

public class CeaserCipherImpl implements CeaserCipher {

    @Override
    public Boolean validateMessage(final @NotNull Kingdom kingdom, final String message) {
        //get the key.......................................
        final int key = GetSecretKeyUtils.findSecretKey(kingdom.getEmblem());
        //...................................................
        final String decryptedMessage = DecryptMessageUtils.decryptSecretMessage(message, key);
        return AnagramUtils.isAnagram(decryptedMessage, kingdom.getEmblem());
    }

}