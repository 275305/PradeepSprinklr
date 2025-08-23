package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; // used for to avoid the Restassured.given() , Restassured.when(),RestrAssured.then()
import static org.hamcrest.Matchers.*;  // to validate the body require hamcrest matchers

public class GetRequestReqRes {
	
	
	@Test
	public void getListUserData() {
		
		 
		 given()
		 
		 .when().get("https://reqres.in/api/users?page=2")
		 
		 .then()
		 .statusCode(200)
		 .body("page", equalTo(2))
		 .body("data[0].first_name", equalTo("Michael"))
		 .body("data[1].first_name",equalTo("Lindsay"));
		
	}

}
