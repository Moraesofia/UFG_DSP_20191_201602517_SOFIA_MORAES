package com.moraesofia.ead.mongodb.mongoexemple.dal;

import java.util.List;

import com.mongodb.client.result.DeleteResult;
import com.moraesofia.ead.mongodb.mongoexemple.model.Dog;

public interface DogDAL {

    List<Dog> getAllDogs();

    Dog getDogById(String dogId);

    Dog addNewDog(Dog dog);

    DeleteResult deleteDog(String dogId);
}
