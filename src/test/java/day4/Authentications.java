package day4;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentications {
	@Test
	void testBasicAuth()
	{
		given().auth().basic("postman", "password")
		.when().get("")
		.then().statusCode(200)
		.body("authenticated", equalTo(true));
	}
	@Test
	void testDigestAuth()
	{
		given().auth().digest("postman", "password")
		.when().get("")
		.then().statusCode(200)
		.body("authenticated", equalTo(true));
	}
	@Test
	void testPreemptiveAuth()
	{
		given().auth().preemptive().basic("postman", "password")
		.when().get("")
		.then().statusCode(200)
		.body("authenticated", equalTo(true));
	}
	@Test
	void testBearerTokenAuth()
	{
		String bearerToken="dfghgfhgfhgfh";
		given().headers("Authorization","bearer"+bearerToken)
		.when().get("")
		.then().statusCode(200)
		.body("authenticated", equalTo(true));
	}
	@Test
	void testOAuth1Authentication()
	{
		//this is for oauth 1.0
		given().auth().oauth("consumerKey", "consumersecrate", "accessToken", "tokenSecrate")
		.when().get("url")
		.then().statusCode(200);
		
	}
	@Test
	void testOAuth2Authentication()
	{
		//this is for oauth 2.0
		given().auth().oauth2("")
		.when().get("url")
		.then().statusCode(200);
		
	}
	@Test
	void testAPIkeyAuthentication()
	{
	
		given().queryParam("Apikey...", "keyvalue..")
		.when().get("url")
		.then().statusCode(200);
		
	}

}
