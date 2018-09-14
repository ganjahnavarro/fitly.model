package core.model.promo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.model.Record;

@Entity(name = Promo.ENTITY_NAME)
public class Promo extends Record {

	private static final long serialVersionUID = 8599651598242367363L;
	public static final String ENTITY_NAME = "promo";

	private String code;
	private String description;
	private BigDecimal discountAmount;

	@NotNull(message = "Code is required")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull(message = "Discount amount is required")
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	@Transient
	public String getDisplayString() {
		return getCode();
	}

}
