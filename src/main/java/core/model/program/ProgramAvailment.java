package core.model.program;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.enums.AvailmentType;
import core.model.Record;
import core.model.member.Member;
import core.model.program.Program;

@Entity(name = ProgramAvailment.ENTITY_NAME)
public class ProgramAvailment extends Record {

	private static final long serialVersionUID = -2333037781334637804L;
	public static final String ENTITY_NAME = "programAvailment";

	private Member member;
	private Program availedProgram;
	private Date date;

	private AvailmentType type;
	private BigDecimal price;

	@NotNull(message = "Member is required")
	@OneToOne(targetEntity = Member.class)
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@NotNull(message = "Program is required")
	@OneToOne(targetEntity = Program.class)
	@JoinColumn(name = "programId")
	public Program getAvailedProgram() {
		return availedProgram;
	}

	public void setAvailedProgram(Program availedProgram) {
		this.availedProgram = availedProgram;
	}

	@NotNull(message = "Date is required")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
