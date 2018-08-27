package com.gnjb.fitly.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import core.model.Record;

@Entity(name = Entry.ENTITY_NAME)
public class Entry extends Record {

	private static final long serialVersionUID = -1300378615181102711L;
	public static final String ENTITY_NAME = "entry";

	private Person person;
	private Date date;

	@NotNull(message = "Person is required.")
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "personId")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String getDisplayString() {
		return String.valueOf(getDate());
	}

}
