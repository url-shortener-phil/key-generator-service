package com.philvigus.keygeneratorservice.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class KeyGeneratorService {
    private static final String HASHING_ALGORITHM = "MD5";
    public static final int DEFAULT_KEY_LENGTH = 7;

    public String generateKey(final String fullUrl) throws NoSuchAlgorithmException {
        return this.generateKey(fullUrl, DEFAULT_KEY_LENGTH);
    }

    public String generateKey(final String fullUrl, final int keyLength) throws NoSuchAlgorithmException {
        final byte[] hashBytes = generateHash(fullUrl);
        final String encodedHash = convertBytesToBase64EncodedString(hashBytes);

        return truncateHashToKeyLength(encodedHash, keyLength);
    }

    private byte[] generateHash(final String fullUrl) throws NoSuchAlgorithmException {
        final MessageDigest messageDigest = MessageDigest.getInstance(HASHING_ALGORITHM);
        messageDigest.update(fullUrl.getBytes(StandardCharsets.UTF_8));

        final byte[] digest = messageDigest.digest();
        final BigInteger bigInteger = new BigInteger(1, digest);

        String hashText = bigInteger.toString(16);
        hashText = "0".repeat(32 - hashText.length()) + hashText;

        return hashText.getBytes();
    }

    private String convertBytesToBase64EncodedString(final byte[] bytes) {
        final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

        return encoder.encodeToString(bytes);
    }

    private String truncateHashToKeyLength(final String hash, final int keyLength) {
        return hash.substring(0, keyLength);
    }
}
