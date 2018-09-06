package core.model.timeentry;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.model.Record;
import core.model.coach.Coach;
import core.model.member.Member;
import core.model.pkg.PackageAvailment;
import core.model.program.ProgramAvailment;

@Entity(name = TimeEntry.ENTITY_NAME)
public class TimeEntry extends Record {

	private static final long serialVersionUID = -8623877750405224224L;
	public static final String ENTITY_NAME = "timeentry";

	private Date date;

	private Member member;
	private String accessCardNoUsed;

	private ProgramAvailment programAvailment;
	private PackageAvailment packageAvailment;

	private Coach coachAssigned;
	private BigDecimal commission;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@NotNull(message = "Member is required")
	@ManyToOne(targetEntity = Member.class)
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getAccessCardNoUsed() {
		return accessCardNoUsed;
	}

	public void setAccessCardNoUsed(String accessCardNoUsed) {
		this.accessCardNoUsed = accessCardNoUsed;
	}

	@ManyToOne(targetEntity = Coach.class)
	@JoinColumn(name = "coachId")
	public Coach getCoachAssigned() {
		return coachAssigned;
	}

	public void setCoachAssigned(Coach coachAssigned) {
		this.coachAssigned = coachAssigned;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	@ManyToOne(targetEntity = ProgramAvailment.class)
	@JoinColumn(name = "programAvailmentId")
	public ProgramAvailment getProgramAvailment() {
		return programAvailment;
	}

	public void setProgramAvailment(ProgramAvailment programAvailment) {
		this.programAvailment = programAvailment;
	}

	@ManyToOne(targetEntity = PackageAvailment.class)
	@JoinColumn(name = "packageAvailmentId")
	public PackageAvailment getPackageAvailment() {
		return packageAvailment;
	}

	public void setPackageAvailment(PackageAvailment packageAvailment) {
		this.packageAvailment = packageAvailment;
	}

	@Override
	@Transient
	public String getDisplayString() {
		return null;
	}

}
