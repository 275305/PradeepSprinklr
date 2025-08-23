package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class ValiadatePathParameter {
	
	
	
	@Test
	public void testParameter() {
		
		//how to validate the Query parameter 	
		given()
		.queryParam("page", 2)
		
		.when()
		.get("https://reqres.in/api/users")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.body("data[0].id", equalTo(7))
		.log().all(); 
		
		
		
	}

}
