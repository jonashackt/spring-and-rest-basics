package com.cc.spring.util;

import com.cc.spring.domain.*;
import com.cc.spring.domain.Produkt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtils {

	public static Produkt generateSampleProdukt(User user) {
		Produkt produkt = new Produkt();
    	produkt.setUser(user);
    	Vertrag vertrag = new Vertrag();
    	vertrag.setKontostand(100000);
    	vertrag.setTarifname("SofortBeginnendeSchulung");
    	produkt.setVertrag(vertrag);
    	return produkt;
	}

	public static User generateSampleUser() {
		User user = new User();
    	user.setGeschlecht(Geschlecht.MAENNLICH);
    	Name name = new Name();
    	name.setNachname("Tester");
    	name.setVorname("Theo");
    	user.setName(name);
    	return user;
	}

	public static void printUserToCmdline() throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	System.out.println(mapper.writeValueAsString(RestUtils.generateSampleUser()));
	}
}
