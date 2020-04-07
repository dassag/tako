package com.cloud.taco.JPARepository;

import org.springframework.data.repository.CrudRepository;

import com.cloud.taco.POJO.Ingredients;

public interface IngredientRepository extends CrudRepository<Ingredients, String> {

}
