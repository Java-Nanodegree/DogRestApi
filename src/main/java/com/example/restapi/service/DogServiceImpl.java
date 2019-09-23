package com.example.restapi.service;

import com.example.restapi.entity.Dog;
import com.example.restapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<String> retrieveDogBreed() {
        return(List<String>) dogRepository.findAllBreeds();
    }

    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllNames();
    }

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public String retrieveDogBreedById(Long id){
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
}
