package core.model.program;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import core.enums.AvailmentType;
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

	private Boolean hasCoach = false;
	private BigDecimal coachPrice;

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
	
	@Override
	@Transient
	public String getDisplayString() {
		return getName();
	}
	
	@Transient
	public BigDecimal getPrice(AvailmentType type) {
		if (type == AvailmentType.REGULAR) {
			return getMemberPrice();
		} else if (type == AvailmentType.GUEST) {
			return getGuestPrice();
		} else if (type == AvailmentType.UNLIMITED) {
			return getMonthlyPrice();
		}
		return null;
	}

}