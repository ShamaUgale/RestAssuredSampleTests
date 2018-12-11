package HotelTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class TestGetCalls {
	
	public static final String BASE_URL= "http://localhost:8090/";
	
	@BeforeClass
	public void setDefaults(){
		RestAssured.baseURI = BASE_URL;

	}
	
	/*
	 * Setting headers
	 * path params
	 * get call
	 */
	@Test
	public void testGetCallWithPathParameters(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		
		given().headers(headers)
	      .when().get("/example/v1/hotels/{id}",4)
	      .then().statusCode(200);
	}
	
	/*
	 * Setting content-type and accept 
	 * path params
	 * get call
	 */
	@Test
	public void testGetCallWithQueryParameters(){
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
			.queryParam("page", 0)
			.queryParam("size", 100)
	      .when().get("/example/v1/hotels/")
	      .then().statusCode(200);
	}
	
	
	/*
	 * verify the node value in the response
	 */
	@Test
	public void testVerifyBody(){
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
			.queryParam("page", 0)
			.queryParam("size", 100)
	      .when().get("/example/v1/hotels/")
	      .then().body("size", equalTo(100), "content.id", hasItems(2));
	}
	
	
	
	
	
	
	
	
	
}
