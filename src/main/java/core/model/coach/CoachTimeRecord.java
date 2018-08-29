package core.model.coach;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.model.Record;

@Entity(name = CoachTimeRecord.ENTITY_NAME)
public class CoachTimeRecord extends Record {

	private static final long serialVersionUID = -1300378615181102711L;
	public static final String ENTITY_NAME = "coachTimeRecord";

	private Coach coach;
	private Date date;

	@NotNull(message = "Coach is required")
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

	@Override
	@Transient
	public String getDisplayString() {
		return String.valueOf(getDate());
	}

}
