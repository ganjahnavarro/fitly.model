package core.model.member;

import javax.persistence.Entity;

import core.model.person.Person;

@Entity(name = Member.ENTITY_NAME)
public class Member extends Person {

	private static final long serialVersionUID = -7303731245447936447L;
	public static final String ENTITY_NAME = "member";

}
