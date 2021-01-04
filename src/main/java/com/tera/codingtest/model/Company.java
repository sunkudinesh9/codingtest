package com.tera.codingtest.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Company {
	@Column(name = "companyname")
	private String companyName;
	private String catchPhrase;
	private String bs;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

}
