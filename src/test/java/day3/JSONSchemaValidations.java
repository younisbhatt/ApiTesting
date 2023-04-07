package day3;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class JSONSchemaValidations {
	@Test
	void jsonSchemavalidation()
	{
      given()
      .when().get()
      .then()
      .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator.json"));
      
    }
	
}