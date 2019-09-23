package com.example.restapi.repository;

import com.example.restapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    public static final String FIND_ALL_BREEDS = "SELECT breed FROM Dog";
    public static final String FIND_ALL_NAMES = "SELECT name FROM Dog";

    @Query(value = FIND_ALL_BREEDS)
    List<String> findAllBreeds();

    @Query(value = FIND_ALL_NAMES)
    List<String> findAllNames();

    @Query(value = "select breed from Dog where id=:id" )
    String findBreedById(Long id);
}
