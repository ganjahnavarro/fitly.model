package com.gnjb.fitly.model.product;

import javax.persistence.Entity;
import javax.persistence.Transient;

import core.model.Record;

@Entity(name = ProductAvailment.ENTITY_NAME)
public class ProductAvailment extends Record {

	private static final long serialVersionUID = 6093613995199631190L;
	public static final String ENTITY_NAME = "productAvailment";
	
	// TODO

	@Override
	@Transient
	public String getDisplayString() {
		// TODO Auto-generated method stub
		return null;
	}

}
