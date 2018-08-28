package com.gnjb.fitly.model.session;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.gnjb.fitly.model.product.ProductAvailment;

@Entity(name = SessionProductAvailment.ENTITY_NAME)
public class SessionProductAvailment implements Serializable {

	private static final long serialVersionUID = 6652886892737589638L;
	public static final String ENTITY_NAME = "sessionProductAvailment";

	private Session session;
	private ProductAvailment productAvailment;

	@NotNull(message = "Session is required.")
	@ManyToOne(targetEntity = Session.class)
	@JoinColumn(name = "sessionId")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@NotNull(message = "Product availment is required.")
	@ManyToOne(targetEntity = ProductAvailment.class)
	@JoinColumn(name = "productAvailmentId")
	public ProductAvailment getProductAvailment() {
		return productAvailment;
	}

	public void setProductAvailment(ProductAvailment productAvailment) {
		this.productAvailment = productAvailment;
	}

}
