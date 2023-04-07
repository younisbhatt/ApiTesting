package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	@Test
	public void testPostUser()
	{
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),201);
	}
	@Test
	public void testGetUserByName()
	{
		Response response=UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void testUpdateUser()
	{
		//update data using pay load
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		Response responseAfterData=UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		Assert.assertEquals(responseAfterData.getStatusCode(), 200);
	}
	
	@Test
	public void testDeleteUserByName()
	{
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
