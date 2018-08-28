package com.gnjb.fitly.model.product;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.gnjb.fitly.enums.Duration;

@Entity(name = Package.ENTITY_NAME)
public class Package extends Product {

	private static final long serialVersionUID = -2333037781334637804L;
	public static final String ENTITY_NAME = "package";

	private Duration duration;
	private Integer durationCount;
	private Integer sessionsCount;
	private BigDecimal price;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Duration is required.")
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@NotNull(message = "Duration count is required.")
	public Integer getDurationCount() {
		return durationCount;
	}

	public void setDurationCount(Integer durationCount) {
		this.durationCount = durationCount;
	}

	@NotNull(message = "Number of sessions is required.")
	public Integer getSessionsCount() {
		return sessionsCount;
	}

	public void setSessionsCount(Integer sessionsCount) {
		this.sessionsCount = sessionsCount;
	}

	@NotNull(message = "Price is required.")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
