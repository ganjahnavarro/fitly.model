package core.model.pkg;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = PackageAvailmentSession.ENTITY_NAME)
public class PackageAvailmentSession implements Serializable {

	private static final long serialVersionUID = -3167263311392943288L;
	public static final String ENTITY_NAME = "packageAvailmentSession";

	private Long id;
	private PackageAvailment packageAvailment;
	private Date date;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@NotNull(message = "Date is required")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((packageAvailment == null) ? 0 : packageAvailment.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PackageAvailmentSession && ((PackageAvailmentSession) obj).getId() != null && getId() != null)
			return ((PackageAvailmentSession) obj).getId().equals(getId());
		return super.equals(obj);
	}

}
