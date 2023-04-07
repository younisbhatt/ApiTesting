package day2;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Cookies {
	@Test
	void getCookies()
	{
		Response res=given()
		.when().get("https://www.google.com/");
		Map<String,String> cookies_value=res.getCookies();
		for(String k:cookies_value.keySet())
		{
	       String cookie_value=res.getCookie(k);
	       System.out.println(k+"  "+cookie_value);
		}
		
	}


}
