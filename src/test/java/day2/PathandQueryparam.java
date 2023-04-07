package day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathandQueryparam {
	//https://reqres.in/api/users?page=2
	@Test
	void testQueryandPathParam()
	{
		given().pathParam("mypath","users").queryParam("page", 2)
		.when().get("https://reqres.in/api/{mypath}")
		.then().statusCode(200);
	}

}
