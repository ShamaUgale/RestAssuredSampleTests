package HotelTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestPutCalls {
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
	public void testPutCallWithJsonBodyAndPathParameter(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		
		String createJson= "{\"city\": \"Pune\",\"description\": \"my test hotel in Pune\",\"id\": 2,\"name\": \"Pune Test- updated\",\"rating\": 4}";
		
		Response response= given().headers(headers)
		.body(createJson)
	      .when()
	      .put("/example/v1/hotels/{id}",2);
	      		
	     int statusCode=  response.getStatusCode();
	     Assert.assertEquals(statusCode, 204);
	}
}
