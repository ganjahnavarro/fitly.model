package core.model.pkg;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.enums.Duration;
import core.model.Record;
import core.model.member.Member;

@Entity(name = PackageAvailment.ENTITY_NAME)
public class PackageAvailment extends Record {

	private static final long serialVersionUID = -2333037781334637804L;
	public static final String ENTITY_NAME = "packageAvailment";

	private Member member;
	private Package availedPackage;
	private Date date;

	private Duration duration;
	private Integer durationCount;
	private Integer sessionsCount;
	private BigDecimal price;

	@NotNull(message = "Member is required")
	@ManyToOne(targetEntity = Member.class)
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@NotNull(message = "Package is required")
	@ManyToOne(targetEntity = Package.class)
	@JoinColumn(name = "packageId")
	public Package getAvailedPackage() {
		return availedPackage;
	}

	public void setAvailedPackage(Package availedPackage) {
		this.availedPackage = availedPackage;
	}
	
	@NotNull(message = "Date is required")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		String packageName = getAvailedPackage() != null ? getAvailedPackage().getName() : "None";
		return "Package Availment: " + packageName;
	}

}
