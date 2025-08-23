package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; // used for to avoid the Restassured.given() , Restassured.when(),RestrAssured.then()
import static org.hamcrest.Matchers.*;  // to validate the body require hamcrest matchers
import static io.restassured.matcher.RestAssuredMatchers.*;
import java.util.HashMap;

public class PostRequestReqRes {
	
	int id;
	
	@Test(priority=0)
	public void createUser() {
		
		HashMap<String,String> data=new HashMap<String,String>();
		
		data.put("name","morpheus");
		data.put("job","leader");
		
		  id=given()
		  .contentType("application/json")
		  .header("x-api-key","reqres-free-v1")
		   .body(data)
		  
		  
		  .when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");
		  
		 System.out.print(id);
		 
				
	}
	
	@Test(priority=1)
	public void updateUser() {
		
    HashMap<String,String> data=new HashMap<String,String>();
		
		data.put("name","pradeep");
		data.put("job","QA");
		
		  given()
		  .contentType("application/json")
		  .header("x-api-key","reqres-free-v1")
		   .body(data)
		  
		  
		  .when()
		  .put("https://reqres.in/api/users/"+id)
		  
		  .then()
		  .statusCode(200)
		  .log().all();
		
	}

}
