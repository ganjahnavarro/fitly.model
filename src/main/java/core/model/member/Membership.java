package core.model.member;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.Utility;
import core.model.Record;

@Entity(name = Membership.ENTITY_NAME)
public class Membership extends Record {

	private static final long serialVersionUID = -809162032512077562L;
	public static final String ENTITY_NAME = "membership";

	private Member member;

	private Date startDate;
	private Date endDate;

	private String accessCardNo;
	private BigDecimal amount;

	@NotNull(message = "Member is required")
	@OneToOne(targetEntity = Member.class)
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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

	public String getAccessCardNo() {
		return accessCardNo;
	}

	public void setAccessCardNo(String accessCardNo) {
		this.accessCardNo = accessCardNo;
	}

	@NotNull(message = "Amount is required")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	@Transient
	public String getDisplayString() {
		return "Membership from " + Utility.formatDate(getStartDate()) + " to "
				+ Utility.formatDate(getEndDate());
	}

}
