package core.model.coach;

import java.math.BigDecimal;

import javax.persistence.Entity;

import core.model.person.Person;

@Entity(name = Coach.ENTITY_NAME)
public class Coach extends Person {

	private static final long serialVersionUID = 1946548862819080823L;
	public static final String ENTITY_NAME = "coach";

	private BigDecimal commissionPercent;

	public BigDecimal getCommissionPercent() {
		return commissionPercent;
	}

	public void setCommissionPercent(BigDecimal commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

}
