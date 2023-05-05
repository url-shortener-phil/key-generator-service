package com.philvigus.keygeneratorservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

class KeyGeneratorServiceTest {
    KeyGeneratorService keyGeneratorService;

    @BeforeEach
    void setUp() {
        keyGeneratorService = new KeyGeneratorService();
    }

    @Test
    void generateKeyGeneratesARandomStringWithTheSpecifiedLength() throws NoSuchAlgorithmException {
        final int keyLength = 10;
        String key = keyGeneratorService.generateKey("This is a test", keyLength);

        assertThat(key, instanceOf(String.class));
        assertThat(key.length(), is(keyLength));
    }

    @Test
    void generateKeyGeneratesARandomStringWithTheDefaultLengthWhenNoneIsSpecified() throws NoSuchAlgorithmException {
        String key = keyGeneratorService.generateKey("This is a test");

        assertThat(key, instanceOf(String.class));
        assertThat(key.length(), is(KeyGeneratorService.DEFAULT_KEY_LENGTH));
    }
}
