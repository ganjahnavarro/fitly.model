package core.model.session;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import core.model.program.ProgramAvailment;

@Deprecated
@Entity(name = SessionProgramAvailment.ENTITY_NAME)
public class SessionProgramAvailment implements Serializable {

	private static final long serialVersionUID = 5049364408101884599L;
	public static final String ENTITY_NAME = "sessionProgramAvailment";

	private Long id;
	private Session session;
	private ProgramAvailment programAvailment;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "Session is required")
	@ManyToOne(targetEntity = Session.class)
	@JoinColumn(name = "sessionId")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	@NotNull(message = "Program availment is required")
	@ManyToOne(targetEntity = ProgramAvailment.class)
	@JoinColumn(name = "programAvailmentId")
	public ProgramAvailment getProgramAvailment() {
		return programAvailment;
	}

	public void setProgramAvailment(ProgramAvailment programAvailment) {
		this.programAvailment = programAvailment;
	}

}
