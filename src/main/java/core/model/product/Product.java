package core.model.product;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import core.model.Record;

@MappedSuperclass
public abstract class Product extends Record {

	private static final long serialVersionUID = 5703232675108766534L;

	private String name;
	private String description;

	@NotBlank(message = "Name is required")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	@Transient
	public String getDisplayString() {
		return getName();
	}

}
