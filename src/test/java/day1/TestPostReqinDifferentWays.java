package day1;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap; 

public class TestPostReqinDifferentWays {
	
@Test
void testPostUsingHashMap() 
{
	
	HashMap data=new HashMap();
	data.put("name", "Scott");
	data.put("location", "France");
	data.put("phone", "123456");
	String coursearr[]= {"c","c++"};
	data.put("courses", coursearr);
	
	given().contentType("application/json").body(data)
	.when().post("http://localhost:3000/students")
	.then().statusCode(201)
	.body("name",equalTo("Scott"))
	.body("location",equalTo("France"))
	.body("phone",equalTo("123456"))
	.body("courses[0]",equalTo("c"))
	.body("courses[1]",equalTo("c++"))
	.header("Content-Type","application/json;charset-utf-8")
	.log().all();
}
@Test
void testPostUsingjsonlibrary() 
{
	
	JSONObject data=new JSONObject();
	data.put("name", "Scott");
	data.put("location", "France");
	data.put("phone", "123456");
	
	String coursearr[]= {"c","c++"};
	data.put("courses", coursearr);
	
	given().contentType("application/json").body(data.toString())
	.when().post("http://localhost:3000/students")
	.then().statusCode(201)
	.body("name",equalTo("Scott"))
	.body("location",equalTo("France"))
	.body("phone",equalTo("123456"))
	.body("courses[0]",equalTo("c"))
	.body("courses[1]",equalTo("c++"))
	.header("Content-Type","application/json;charset-utf-8")
	.log().all();
}
@Test
void testPostUsingPOJO() 
{
	POJO_PostReq data=new POJO_PostReq();
	data.setName("Scott");
	data.setLocation("France");
	data.setPhone("123456");
	String coursearr[]= {"c","c+"};
	data.setCourses(coursearr);
	
	given().contentType("application/json").body(data)
	.when().post("http://localhost:3000/students")
	.then().statusCode(201)
	.body("name",equalTo("Scott"))
	.body("location",equalTo("France"))
	.body("phone",equalTo("123456"))
	.body("courses[0]",equalTo("c"))
	.body("courses[1]",equalTo("c++"))
	.header("Content-Type","application/json;charset-utf-8")
	.log().all();
}

@Test
void testPostUsingexternalJsonfile() throws FileNotFoundException 
{
	File file=new File(".\\body.json");
	FileReader fr=new FileReader(file);
	JSONTokener jt=new JSONTokener(fr);
	JSONObject data=new JSONObject(jt);
	
	given().contentType("application/json").body(data.toString())
	.when().post("http://localhost:3000/students")
	.then().statusCode(201)
	.body("name",equalTo("Scott"))
	.body("location",equalTo("France"))
	.body("phone",equalTo("123456"))
	.body("courses[0]",equalTo("c"))
	.body("courses[1]",equalTo("c++"))
	.header("Content-Type","application/json;charset-utf-8")
	.log().all();
}
	
	
}
