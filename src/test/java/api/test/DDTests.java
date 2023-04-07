package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID, String username,String fname,String lname,String useremail,String pwd, String ph)
	{
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(username);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);	
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(),201);
	}

	@Test(dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String username)
	{
		Response response=UserEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
