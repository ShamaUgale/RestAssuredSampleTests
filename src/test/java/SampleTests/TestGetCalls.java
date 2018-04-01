package SampleTests;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestGetCalls {

	/*
	 * fire a get request no parameters
	 * Ex: http://services.groupkt.com/country/get/all 
	 * print the response on the console
	 */
	@Test
	public void testGetCallWithNoParameters(){
		given()
	      .when().get("http://services.groupkt.com/country/get/all")
	      .then().statusCode(200);
	}
	
	/*
	 * fire a get request PATH parameters
	 * Ex: http://services.groupkt.com/country/get/iso2code/{countryCode}  -- countryCode is a path parameter
	 * print the response on the console (observe the request specification on the console, {countryCode} is replaced by "IN")
	 */
	@Test
	public void testGetCallWithPathParameters(){
		given().pathParams("countryCode", "IN").log().all()
	      .when().get("http://services.groupkt.com/country/get/iso2code/{countryCode}")
	      .then().statusCode(200);
	 
		// you can use multiple path parameters like below - can use map as well
		
		/*
		given().pathParams("countryCode", "IN", "x","value for x", "y", "value for y").log().all()
	      .when().get("http://services.groupkt.com/country/get/iso2code/{countryCode}/{x}/{y}")
	      .then().statusCode(200);
		
		//or one can use a map as well as below
		
		
		HashMap<String,String> map= new HashMap<String, String>();
		map.put("x", "value for x");
		map.put("y", "value for y");
		
		given().pathParams(map).log().all()
	      .when().get("http://services.groupkt.com/country/get/iso2code/{countryCode}/{x}/{y}")
	      .then().statusCode(200);
	      */
	}
	
	/*
	 * fire a get request query parameters
	 * Ex:http://services.groupkt.com/country/search?text=un - here text is query parameter
	 * print the response on the console
	 */
	@Test
	public void testGetCallWithQueryParameters(){
		given().
		log().all().
			queryParam("text", "un").
		when().
		get("http://services.groupkt.com/country/search").
	    then().
	    	statusCode(200);
		//map can be used here as well - refer the above path parameter example
		
	}
	
	
}
