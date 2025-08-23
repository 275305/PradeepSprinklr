package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ValidateResponseinQueryParameter {
	
	@Test
	public void validateResponse() {
		//Validate first name in response
		given()
		.queryParam("page",2)
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.body("data[0].first_name",equalTo("Michael"))
		.body("data[5].last_name",equalTo("Howell"))
		.log().all();
		
		
	}
	

}
