package com.moraesofia.ead.mongodb.mongoexemple.repository;

import com.moraesofia.ead.mongodb.mongoexemple.model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends MongoRepository<Dog, String> {
}