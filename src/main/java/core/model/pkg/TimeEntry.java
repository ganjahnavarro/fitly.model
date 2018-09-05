package core.model.pkg;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;

import core.model.Record;
import core.model.coach.Coach;
import core.model.member.Member;
import core.model.program.ProgramAvailment;

public class TimeEntry extends Record {

	private static final long serialVersionUID = -8623877750405224224L;
	public static final String ENTITY_NAME = "timeentry";

	private Date date;
	private Member member;
	private Coach coachAssigned;
	private BigDecimal commission;

	private ProgramAvailment programaAvailment;
	private PackageAvailment packageAvailment;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

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

	public ProgramAvailment getProgramaAvailment() {
		return programaAvailment;
	}

	public void setProgramaAvailment(ProgramAvailment programaAvailment) {
		this.programaAvailment = programaAvailment;
	}

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
