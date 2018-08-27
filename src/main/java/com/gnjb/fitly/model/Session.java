package com.gnjb.fitly.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import core.Utility;
import core.model.Record;

@Entity(name = Session.ENTITY_NAME)
public class Session extends Record {

	private static final long serialVersionUID = 4240562372196169717L;
	public static final String ENTITY_NAME = "session";

	private Coach coach;
	private Date date;
	private List<Member> members;

	@NotNull(message = "Coach is required.")
	@ManyToOne(targetEntity = Coach.class)
	@JoinColumn(name = "coachId")
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(targetEntity = Member.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "session", orphanRemoval = true)
	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String getDisplayString() {
		return "Session: " + Utility.formatDate(getDate());
	}

}
