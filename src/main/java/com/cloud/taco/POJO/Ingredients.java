package com.cloud.taco.POJO;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
//JPA requires its entities to have a 
//no args constructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredients {

	private final String name;
	private final String id;
	private final Type type;
	
	public static enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
	}

}
