package com.cloud.taco.POJO;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Taco {
	
	@NotNull
	@Size(min=5,message="name can not be blank")
	private String name;
	
	@Size(min=5,message="please choose atleast one ingredient")
	@ManyToMany(mappedBy = "Ingredients")
	private List<Ingredients> listOfIngredients;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Date createdAt;
	
	@PrePersist
	  void createdAt() {
	    this.createdAt = new Date();
	  }

}
