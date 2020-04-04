package com.cloud.taco.Repository;

import com.cloud.taco.POJO.Ingredients;

public interface IngredientRepository {
		  Iterable<Ingredients> findAll();//query for all ingredients 

		  Ingredients findOne(String id); //query for single ingredient using id

		  Ingredients save(Ingredients ingredient); //saving ingredient object

	}
