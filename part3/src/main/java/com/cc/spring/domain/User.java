package com.cc.spring.domain;

import javax.xml.bind.annotation.XmlRootElement;

public class User {

	private Name name;
	private Geschlecht geschlecht;

	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}
}
