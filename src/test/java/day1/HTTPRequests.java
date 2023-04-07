package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


/*
given()
content type,set cookies,add auth,add param,set headers info etc

when()
get,post,put,delete

then()
validate status code, extract response,extract headers cookies and response body
*/

public class HTTPRequests {
  int id;
	@Test()
	void getUsers()
	{
		given()
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then().statusCode(200).body("page",equalTo(2));
	}
	@Test
	void createUser() {
		HashMap data= new HashMap();
		data.put("name","pavan");
		data.put("job","trainer");
		
		id=given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then().statusCode(201);
	}
	@Test
	void updateUser() {
		HashMap data= new HashMap();
		data.put("name","john");
		data.put("job","teacher");
		
		given().contentType("application/json").body(data)
		.when().put("https://reqres.in/api/users/"+id)
		.then().statusCode(200);
	}
	@Test
	void deleteUser() {
		
		given()
		.when().delete("https://reqres.in/api/users/"+id)
		.then().statusCode(204);
	}
	
	

}
