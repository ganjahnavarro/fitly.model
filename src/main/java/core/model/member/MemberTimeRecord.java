package core.model.member;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import core.model.Record;

@Deprecated
@Entity(name = MemberTimeRecord.ENTITY_NAME)
public class MemberTimeRecord extends Record {

	private static final long serialVersionUID = -1300378615181102711L;
	public static final String ENTITY_NAME = "memberTimeRecord";

	private Member member;
	private Date date;

	@NotNull(message = "Member is required")
	@ManyToOne(targetEntity = Member.class)
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	@Transient
	public String getDisplayString() {
		return String.valueOf(getDate());
	}

}
