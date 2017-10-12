package com.cc.spring.util;

import com.cc.spring.domain.Geschlecht;
import com.cc.spring.domain.Name;
import com.cc.spring.domain.Produkt;
import com.cc.spring.domain.User;
import com.cc.spring.domain.Vertrag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtils {

	public static Produkt generateSampleProdukt(User user) {
		Produkt produkt = new Produkt();
    	produkt.setUser(user);
    	Vertrag vertrag = new Vertrag();
    	vertrag.setKontostand(100000);
    	vertrag.setTarifname("SuperTollerTarif");
    	produkt.setVertrag(vertrag);
    	return produkt;
	}
	
	public static User generateSampleUser() {
		User user = new User();
    	user.setGeschlecht(Geschlecht.MAENNLICH);
    	Name name = new Name();
    	name.setNachname("Mayer");
    	name.setVorname("Frank");
    	user.setName(name);
    	return user;
	}
	
	public static void printUserToCmdline() throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	System.out.println(mapper.writeValueAsString(RestUtils.generateSampleUser()));
	}
}
