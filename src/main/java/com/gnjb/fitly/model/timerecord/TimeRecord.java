package com.gnjb.fitly.model.timerecord;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.gnjb.fitly.model.person.Person;

import core.model.Record;

@Entity(name = TimeRecord.ENTITY_NAME)
public class TimeRecord extends Record {

	private static final long serialVersionUID = -1300378615181102711L;
	public static final String ENTITY_NAME = "timeRecord";

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
	@Transient
	public String getDisplayString() {
		return String.valueOf(getDate());
	}

}
