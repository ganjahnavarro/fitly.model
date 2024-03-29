package core.model.program;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.enums.AvailmentType;
import core.model.Record;
import core.model.member.Member;

@Entity(name = ProgramAvailment.ENTITY_NAME)
public class ProgramAvailment extends Record {

	private static final long serialVersionUID = -2333037781334637804L;
	public static final String ENTITY_NAME = "programAvailment";

	private Member member;
	private Program availedProgram;

	private Date startDate;
	private Date endDate;

	private AvailmentType type;
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

	@NotNull(message = "Program is required")
	@ManyToOne(targetEntity = Program.class)
	@JoinColumn(name = "programId")
	public Program getAvailedProgram() {
		return availedProgram;
	}

	public void setAvailedProgram(Program availedProgram) {
		this.availedProgram = availedProgram;
	}

	@NotNull(message = "Start date is required")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@NotNull(message = "End date is required")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Type is required")
	public AvailmentType getType() {
		return type;
	}

	public void setType(AvailmentType type) {
		this.type = type;
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
		String programName = getAvailedProgram() != null ? getAvailedProgram().getName() : "None";
		return "Availed Program: " + programName;
	}

}
