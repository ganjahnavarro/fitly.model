package com.gnjb.fitly.model.session;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.gnjb.fitly.model.coach.Coach;
import com.gnjb.fitly.model.product.ProductAvailment;

import core.Utility;
import core.model.Record;

@Entity(name = Session.ENTITY_NAME)
public class Session extends Record {

	private static final long serialVersionUID = 4240562372196169717L;
	public static final String ENTITY_NAME = "session";

	private Coach coach;
	private Date date;
	private List<ProductAvailment> productAvailments;

	@NotNull(message = "Coach is required.")
	@ManyToOne(targetEntity = Coach.class)
	@JoinColumn(name = "coachId")
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(targetEntity = ProductAvailment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "session", orphanRemoval = true)
	public List<ProductAvailment> getProductAvailments() {
		return productAvailments;
	}

	public void setProductAvailments(List<ProductAvailment> productAvailments) {
		this.productAvailments = productAvailments;
	}

	@Override
	@Transient
	public String getDisplayString() {
		return "Session: " + Utility.formatDate(getDate());
	}

}
