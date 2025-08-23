package day1;

import static io.restassured.RestAssured.*; // used for to avoid the Restassured.given() , Restassured.when(),RestrAssured.then()
import static org.hamcrest.Matchers.*;  // to validate the body require hamcrest matchers
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.Header;

public class ValidatePostRequest {
	
	@Test
	public void createUser() {
	
	HashMap<String,String> data=new HashMap<String,String>();
	
	data.put("name","morpheus");
	data.put("job","leader");
	
	 given()
	  .contentType("application/json")
	  .header("x-api-key","reqres-free-v1")
	   .body(data)
	  	  
	  .when()
	  .post("https://reqres.in/api/users")
	  
	  .then()
	  .body("name",equalTo("morpheus"))
	  .header("Content-Type", equalTo("application/json; charset=utf-8"))
	  .statusCode(201)
	  .time(lessThan(3000L));
	  
	  
	}

}
