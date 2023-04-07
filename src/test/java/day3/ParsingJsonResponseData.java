package day3;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class ParsingJsonResponseData {
	@Test
	void testJsonResponse()
	{
//		//Approach1
		given().contentType("ContentType.json")
		.when().get("http://localhost:3000/store")
		.then().statusCode(200).header("Content-Type","application/json;charset-utf-8")
		.body("book[3].title",equalTo("The Lord of the Rings"));
		
		//Approach2
		Response res=
		given().contentType(ContentType.JSON)
		.when().get("http://localhost:3000/store");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.getHeader("Content-Type"),"application/json;charset-utf-8");
		String bookname=res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");
		
	}
	@Test
	void testJsonResponseBodyData()
	{
         Response res=
		given().contentType(ContentType.JSON)
		.when().get("http://localhost:3000/store");
         
		// Using JsonObject class we can parse the JsonResponse data
        JSONObject jo =new JSONObject(res.toString());//converting response to json object type
        
        // print all titles of the book
        for(int i=0;i<jo.getJSONArray("book").length();i++)
         {
        	 String booktitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();//Refer TestAPI foder under response validations
       	     System.out.println(booktitle);
         }
        //Validate if particular book is present
        boolean status=false;
           for(int i=0;i<jo.getJSONArray("book").length();i++)
           {
        	   String booktitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
        	   if(booktitle.equals("The Lord of the Rings"))
        	   {
        		   status=true;
        		   break;
        	   }
           }
          Assert.assertEquals(status, true);
	}

}
