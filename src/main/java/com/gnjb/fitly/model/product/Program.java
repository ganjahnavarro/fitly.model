package com.gnjb.fitly.model.product;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity(name = Program.ENTITY_NAME)
public class Program extends Product {

	private static final long serialVersionUID = 6947948233927815395L;
	public static final String ENTITY_NAME = "program";

	private BigDecimal guestPrice;
	private BigDecimal memberPrice;
	private BigDecimal monthlyPrice;

	private Boolean hasCoach = false;
	private BigDecimal coachPrice;

	private Boolean active = true;

	public BigDecimal getGuestPrice() {
		return guestPrice;
	}

	public void setGuestPrice(BigDecimal guestPrice) {
		this.guestPrice = guestPrice;
	}

	public BigDecimal getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}

	public BigDecimal getMonthlyPrice() {
		return monthlyPrice;
	}

	public void setMonthlyPrice(BigDecimal monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	public Boolean getHasCoach() {
		return hasCoach;
	}

	public void setHasCoach(Boolean hasCoach) {
		this.hasCoach = hasCoach;
	}

	public BigDecimal getCoachPrice() {
		return coachPrice;
	}

	public void setCoachPrice(BigDecimal coachPrice) {
		this.coachPrice = coachPrice;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}