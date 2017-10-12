package com.cc.spring.endpoints;

import com.cc.spring.RestApplication;
import com.cc.spring.domain.User;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.cc.spring.util.RestUtils.generateSampleProdukt;
import static com.cc.spring.util.RestUtils.generateSampleUser;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = RestApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
		properties = {"server.port=8080"}
)
public class RestEndpointsTest {
    
	@Test
	public void testWithSpringRestTemplate() {
	    // Given
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // When
	    String response = restTemplate.getForObject("http://localhost:8080/api/hello", String.class);
	    
	    // Then
	    assertEquals(RestEndpoints.RESPONSE, response);
	}
	
	/**
	 * Using Restassured for elegant REST-Testing, see https://github.com/jayway/rest-assured
	 */
	@Test
    public void testWithRestAssured() {
		
	    get("http://localhost:8080/api/hello")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
                .equals(RestEndpoints.RESPONSE);
    }
	
	@Test
    public void testeLegeNamenAn() {
		
	    given() 
	    .when()
	    	.post("http://localhost:8080/api/hello?name=Holger")
	    .then()
	    	.statusCode(HttpStatus.SC_CREATED); // Kein fachlicher Response
    }
	
	@Test
    public void testeAendereNamen() {
		
	    given() 
	    .when()
	    	.put("http://localhost:8080/api/hello/Holger")
	    .then()
	    	.statusCode(HttpStatus.SC_NO_CONTENT); // Kein fachlicher Response
    }
	
	
	@Test
	public void testeBerechnungJson() {
		User user = generateSampleUser();
		
		given()
			.contentType(ContentType.JSON)
			.body(user)
		.when()
			.post("http://localhost:8080/api/produkt.json")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.contentType(ContentType.JSON)
			.assertThat()
				.equals(generateSampleProdukt(user));
	}
	
	@Test
	public void testeBerechnungXml() {
		User user = generateSampleUser();
		
		given()
			.contentType(ContentType.XML)
			.body(user)
		.when()
			.post("http://localhost:8080/api/produkt.xml")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.contentType(ContentType.XML)
			.assertThat()
				.equals(generateSampleProdukt(user));
	}

}
