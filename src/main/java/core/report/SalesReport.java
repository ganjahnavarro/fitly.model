package core.report;

import java.math.BigDecimal;
import java.util.Date;

import core.model.person.Person;

public class SalesReport {

	private Date date;
	private Person person;
	private String description;
	private BigDecimal amount;

	public SalesReport(Date date, Person person, String description, BigDecimal amount) {
		this.date = date;
		this.person = person;
		this.description = description;
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
