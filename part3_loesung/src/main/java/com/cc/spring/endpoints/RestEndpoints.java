package com.cc.spring.endpoints;

import com.cc.spring.domain.Produkt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cc.spring.backend.ExampleBackend;
import com.cc.spring.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api")
public class RestEndpoints {

    public static final String RESPONSE = "Hello Rest-User!";
    
    @RequestMapping("/hello")
    public String gruesse() {
        return RESPONSE;
    }
    
    @RequestMapping(value="/hello/{name}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void aendereName(@PathVariable("name") String name) {
    	// Moegliche Verarbeitung hier: aendere den Namen in der Datenbank...
    	System.out.println("Ersetze den alten Namen durch '" + name + "'.");
    }
    
    @RequestMapping(value="/hello", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void legeNamenAn(@RequestParam("name") String name) throws JsonProcessingException {
    	// Moegliche Verarbeitung hier: lege Namen in der Datenbank an...
    	System.out.println("Lege neuen Namen '" + name + "' an.");
    }	
    
    @RequestMapping(value="/produkt.json", method=RequestMethod.POST, produces="application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Produkt berechneProduktDaten(@RequestBody User user) {
    	// komplizierte Berechnung ...
    	return ExampleBackend.berechneImBackend(user);
    }
    
    @RequestMapping(value="/produkt.xml", method=RequestMethod.POST, produces="application/xml")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Produkt berechneProduktDatenXml(@RequestBody User user) {
    	// komplizierte Berechnung ...
    	return ExampleBackend.berechneImBackend(user);
    }
}
