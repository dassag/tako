package com.cloud.taco;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Taco {
	
	private String name;
	private List<Ingredients> listOfIngredients;
	private long id;
	private Date createdAt;

}
