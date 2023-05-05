package com.philvigus.keygeneratorservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("availableKeys")
public class Key {
    @Id
    private final String id;

    @Indexed(unique = true)
    private final String value;

    public Key(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
