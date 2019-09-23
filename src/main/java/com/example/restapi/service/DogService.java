package com.example.restapi.service;

import com.example.restapi.entity.Dog;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();

    List<Dog> retrieveDogs();
}
