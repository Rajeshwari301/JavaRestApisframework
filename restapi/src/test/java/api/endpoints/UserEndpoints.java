package api.endpoints;

import org.testng.annotations.Test;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserEndpoints {
	
	public static Response createuser(User payload)
	{
		Response response = given().log().body()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
				.post(Routes.posturl);
				
			 return response;	
	}
	
	public static Response readuser(String username)
	{
		Response response = given().log().body()
					.pathParam("username", username)
					.when()
						.get(Routes.geturl);
				
			 		return response;	
	}
	
	public static Response updateuser(String username, User payload)
	{
		Response response = given().log().body()
			.contentType(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
			.when()
				.put(Routes.puturl);
				
			 return response;	
	}
	
	public static Response deleteuser(String username)
	{
		Response response = given()
					.pathParam("username", username)
					.when()
						.get(Routes.deleteurl);
				
			 		return response;	
	}

}
