package com.example.restapi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.restapi.entity.Dog;
import com.example.restapi.repository.DogRepository;
import com.example.restapi.exception.BreedNotFoundException;
import com.example.restapi.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(String breed) {
        Iterable<Dog> dogs = this.dogRepository.findAll();
        Boolean deleted = false;

        for (Dog d:dogs) {
            if(d.getBreed().equals(breed)){
                this.dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted){
            throw new BreedNotFoundException("Breed not found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            // Set the new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
