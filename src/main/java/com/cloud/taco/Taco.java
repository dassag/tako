package com.cloud.taco;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Taco {
	
	@NotNull
	@Size(min=5,message="name can not be blank")
	private String name;
	
	@Size(min=5,message="please choose atleast one ingredient")
	private List<Ingredients> listOfIngredients;
	private long id;
	private Date createdAt;

}
