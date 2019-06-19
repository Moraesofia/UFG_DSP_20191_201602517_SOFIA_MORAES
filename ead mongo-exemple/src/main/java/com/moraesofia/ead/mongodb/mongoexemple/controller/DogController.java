package com.moraesofia.ead.mongodb.mongoexemple.controller;

import java.util.List;
import java.util.Optional;

import com.moraesofia.ead.mongodb.mongoexemple.model.Dog;
import com.moraesofia.ead.mongodb.mongoexemple.repository.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/")
public class DogController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final DogRepository dogRepository;

    public DogController(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Dog> getAllDogs() {
        LOG.info("Getting all dogs.");
        return dogRepository.findAll();
    }

    @RequestMapping(value = "/{dogId}", method = RequestMethod.GET)
    public Dog getDog(@PathVariable String dogId) {
        LOG.info("Getting dog with ID: {}.", dogId);
        return dogRepository.findById(dogId).orElse(null);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Dog addNewDog(@RequestBody Dog dog) {
        LOG.info("Saving dog.");
        return dogRepository.save(dog);
    }

    @RequestMapping(value = "/{dogId}", method = RequestMethod.DELETE)
    public boolean deleteDog(@PathVariable String dogId) {
        if (dogRepository.existsById(dogId)) {
            dogRepository.deleteById(dogId);
            LOG.info("Deleted dog with ID: {}.", dogId);
            return true;
        } else {
            LOG.info("Dog with ID: {} not found.", dogId);
            return false;
        }
    }

}