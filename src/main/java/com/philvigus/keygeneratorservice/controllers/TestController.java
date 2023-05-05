package com.philvigus.keygeneratorservice.controllers;

import com.philvigus.keygeneratorservice.models.Key;
import com.philvigus.keygeneratorservice.repositories.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final KeyRepository keyRepository;

    @Autowired
    public TestController(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    @GetMapping(value = "/test")
    public String testMapping() {
        keyRepository.save(new Key("blah", "wibble"));
        return "Hello, wibble-wobble-woo";
    }
}
