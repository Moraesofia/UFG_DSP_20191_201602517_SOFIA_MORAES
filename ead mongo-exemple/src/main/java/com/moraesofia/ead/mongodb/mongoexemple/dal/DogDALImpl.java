package com.moraesofia.ead.mongodb.mongoexemple.dal;

import com.mongodb.client.result.DeleteResult;
import com.moraesofia.ead.mongodb.mongoexemple.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DogDALImpl implements DogDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Dog> getAllDogs() {
        return mongoTemplate.findAll(Dog.class);
    }

    @Override
    public Dog getDogById(String dogId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("dogId").is(dogId));
        return mongoTemplate.findOne(query, Dog.class);
    }

    @Override
    public Dog addNewDog(Dog dog) {
        mongoTemplate.save(dog);
        return dog; //with Id
    }

    @Override
    public DeleteResult deleteDog(String dogId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("dogId").is(dogId));
        return mongoTemplate.remove(query, Dog.class);
    }
}