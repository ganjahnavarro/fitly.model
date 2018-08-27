package com.gnjb.fitly.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = SessionMember.ENTITY_NAME)
public class SessionMember implements Serializable {

	private static final long serialVersionUID = 6652886892737589638L;
	public static final String ENTITY_NAME = "sessionMember";

	private Session session;
	private Member member;

	@NotNull(message = "Session is required.")
	@ManyToOne(targetEntity = Session.class)
	@JoinColumn(name = "sessionId")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@NotNull(message = "Member is required.")
	@ManyToOne(targetEntity = Member.class)
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
