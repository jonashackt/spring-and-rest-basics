package com.cc.spring.domain;

import javax.xml.bind.annotation.XmlRootElement;

public class Produkt {

	private Vertrag vertrag;
	private User user;
	public Vertrag getVertrag() {
		return vertrag;
	}
	public void setVertrag(Vertrag vertrag) {
		this.vertrag = vertrag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
