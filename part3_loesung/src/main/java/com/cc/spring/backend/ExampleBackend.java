package com.cc.spring.backend;

import com.cc.spring.domain.Produkt;
import com.cc.spring.domain.User;
import com.cc.spring.util.RestUtils;

public class ExampleBackend {

	public static Produkt berechneImBackend(User user) {
		return RestUtils.generateSampleProduct(user);
	}

	
	
	
}
