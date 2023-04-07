package day4;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDatagenerator {
    @Test
	void testGenerateDummyData()
	{
		Faker faker=new Faker();
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String lastname=faker.name().lastName();
		faker.phoneNumber().cellPhone();
		
	}
}
