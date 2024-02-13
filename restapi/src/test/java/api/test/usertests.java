package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class usertests {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void Setupdate()
	{
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(0);
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserstatus(0);
		
	}
	
	@Test(priority=1)
	public void testpostuser()
	{
		Response response =UserEndpoints.createuser(userpayload);
		//response.then().log().all();
		//response.then().log().everything();
		Assert.assertEquals(response.getStatusCode(),200);
		//System.out.println("POST USER"+);
		
	}
	
	@Test(priority=2)
	public void testgetuserbyname()
	{
		Response response1 = UserEndpoints.readuser(this.userpayload.getUsername());
		//response1.then().log().all();
		Assert.assertEquals(response1.getStatusCode(), 200);
		//response1.getBody();
		
	}
	
	
	@Test(priority=2)
	public void testupdateuserbyname()
	{
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response =UserEndpoints.updateuser(this.userpayload.getUsername(),userpayload);
		System.out.print(Routes.puturl);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		

		Response response1 = UserEndpoints.readuser(this.userpayload.getUsername());
		response1.then().log().all();
		Assert.assertEquals(response1.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testdeleteuserbyname()
	{

		Response response = UserEndpoints.deleteuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
