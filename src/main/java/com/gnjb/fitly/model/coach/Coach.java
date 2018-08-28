package com.gnjb.fitly.model.coach;

import javax.persistence.Entity;

import com.gnjb.fitly.model.person.Person;

@Entity(name = Coach.ENTITY_NAME)
public class Coach extends Person {
	
	private static final long serialVersionUID = 1946548862819080823L;
	public static final String ENTITY_NAME = "coach";

}
