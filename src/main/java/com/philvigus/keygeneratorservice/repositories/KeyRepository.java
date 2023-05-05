package com.philvigus.keygeneratorservice.repositories;

import com.philvigus.keygeneratorservice.models.Key;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KeyRepository extends MongoRepository<Key, String> {
}
