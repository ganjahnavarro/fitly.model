package core.model.coach;

import javax.persistence.Entity;

import core.model.person.Person;

@Entity(name = Coach.ENTITY_NAME)
public class Coach extends Person {

	private static final long serialVersionUID = 1946548862819080823L;
	public static final String ENTITY_NAME = "coach";

}
