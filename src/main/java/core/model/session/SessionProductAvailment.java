package core.model.session;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import core.model.product.ProductAvailment;

public class SessionProductAvailment implements Serializable {

	private static final long serialVersionUID = 6652886892737589638L;
	public static final String ENTITY_NAME = "sessionProductAvailment";

	private Long id;
	private Session session;
	private ProductAvailment productAvailment;
	
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

	@NotNull(message = "Product availment is required")
	@ManyToOne(targetEntity = ProductAvailment.class)
	@JoinColumn(name = "productAvailmentId")
	public ProductAvailment getProductAvailment() {
		return productAvailment;
	}

	public void setProductAvailment(ProductAvailment productAvailment) {
		this.productAvailment = productAvailment;
	}

}
