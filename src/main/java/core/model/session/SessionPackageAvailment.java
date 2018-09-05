package core.model.session;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import core.model.pkg.PackageAvailment;

@Deprecated
@Entity(name = SessionPackageAvailment.ENTITY_NAME)
public class SessionPackageAvailment implements Serializable {

	private static final long serialVersionUID = 1704631225863612178L;
	public static final String ENTITY_NAME = "sessionPackageAvailment";

	private Long id;
	private Session session;
	private PackageAvailment packageAvailment;
	
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
	
	@NotNull(message = "Package availment is required")
	@ManyToOne(targetEntity = PackageAvailment.class)
	@JoinColumn(name = "packageAvailmentId")
	public PackageAvailment getPackageAvailment() {
		return packageAvailment;
	}

	public void setPackageAvailment(PackageAvailment packageAvailment) {
		this.packageAvailment = packageAvailment;
	}

}
