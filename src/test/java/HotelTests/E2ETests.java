package HotelTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class E2ETests {
public static final String BASE_URL= "http://localhost:8090/";

	
	@BeforeClass
	public void setDefaults(){
		RestAssured.baseURI = BASE_URL;

	}
	
	@Test
	public void testHotelCRUD(){
		int id=5;
		String createJson= "{\"city\": \"Pune\",\"description\": \"my test hotel in Pune\",\"id\": "+id+",\"name\": \"Pune Test\",\"rating\": 4}";
		String updateJson= "{\"city\": \"Pune\",\"description\": \"my test hotel in Pune\",\"id\": "+id+",\"name\": \"Pune Test "+id+"\",\"rating\": 4}";

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		
		// create a hotel
		Response response= given().headers(headers)
		.body(createJson)
	      .when()
	      .post("/example/v1/hotels");
	      		
	     int statusCode=  response.getStatusCode();
	     Assert.assertEquals(statusCode, 201);

	     // get the hotel created and validate
	     response = given().headers(headers)
	      .when()
	      .get("/example/v1/hotels/{id}",id);
	      
	     int resID= response.jsonPath().getInt("id");
	     Assert.assertEquals(resID, id);
	     
	     // update the hotel name
	     response= given().headers(headers)
	    			.body(updateJson)
	    		      .when()
	    		      .put("/example/v1/hotels/{id}",id);
	     response = given().headers(headers)
	   	      .when()
	   	      .get("/example/v1/hotels/{id}",id);
	     String updatedHotelName= response.jsonPath().getString("name");
	     Assert.assertEquals(updatedHotelName, "Pune Test "+id);

	     
	}
}
