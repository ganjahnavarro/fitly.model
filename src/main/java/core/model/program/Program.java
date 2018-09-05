package core.model.program;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import core.model.Record;

@Entity(name = Program.ENTITY_NAME)
public class Program extends Record {

	private static final long serialVersionUID = 6947948233927815395L;
	public static final String ENTITY_NAME = "program";

	private String name;
	private String description;

	private BigDecimal guestPrice;
	private BigDecimal memberPrice;
	private BigDecimal monthlyPrice;
	private BigDecimal coachPrice;

	private BigDecimal commission;
	private Boolean active = true;

	@NotBlank(message = "Name is required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull(message = "Guest price is required")
	public BigDecimal getGuestPrice() {
		return guestPrice;
	}

	public void setGuestPrice(BigDecimal guestPrice) {
		this.guestPrice = guestPrice;
	}

	@NotNull(message = "Member price is required")
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

	public BigDecimal getCoachPrice() {
		return coachPrice;
	}

	public void setCoachPrice(BigDecimal coachPrice) {
		this.coachPrice = coachPrice;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	@Transient
	public String getDisplayString() {
		return getName();
	}

}