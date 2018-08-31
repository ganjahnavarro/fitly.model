package core.model.member;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import core.enums.MemberType;
import core.model.person.Person;

@Entity(name = Member.ENTITY_NAME)
public class Member extends Person {

	private static final long serialVersionUID = -7303731245447936447L;
	public static final String ENTITY_NAME = "member";

	private MemberType type = MemberType.REGULAR;

	private BigDecimal height;
	private BigDecimal width;

	@Enumerated(EnumType.STRING)
	public MemberType getType() {
		return type;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

}
