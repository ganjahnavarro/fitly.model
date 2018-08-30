package core.model.pkg;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import core.enums.Duration;
import core.model.Record;

@Entity(name = Package.ENTITY_NAME)
public class Package extends Record {

	private static final long serialVersionUID = -2333037781334637804L;
	public static final String ENTITY_NAME = "package";

	private String name;
	private String description;
	
	private Duration duration;
	private Integer durationCount;
	private Integer sessionsCount;
	private BigDecimal price;
	
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

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Duration is required")
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@NotNull(message = "Duration count is required")
	public Integer getDurationCount() {
		return durationCount;
	}

	public void setDurationCount(Integer durationCount) {
		this.durationCount = durationCount;
	}

	@NotNull(message = "Number of sessions is required")
	public Integer getSessionsCount() {
		return sessionsCount;
	}

	public void setSessionsCount(Integer sessionsCount) {
		this.sessionsCount = sessionsCount;
	}

	@NotNull(message = "Price is required")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	@Transient
	public String getDisplayString() {
		return getName();
	}

}
