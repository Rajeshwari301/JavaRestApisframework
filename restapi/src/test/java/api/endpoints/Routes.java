package api.endpoints;

/*
 * PET STORE - https://petstore.swagger.io/v2/
 * 
 * Create User(POST) - https://petstore.swagger.io/v2/user/
 * Get User(GET)-https://petstore.swagger.io/v2/user/{username}
 * Update user(PUT) - https://petstore.swagger.io/v2/user/{username}
 * Delete user(DELETE) - https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	
	public static String baseurl = "https://petstore.swagger.io/v2/";
	
	public static String posturl = baseurl + "user";
	public static String geturl = baseurl + "user/{username}";
	public static String puturl = baseurl + "user/{username}";
	public static String deleteurl = baseurl + "user/{username}";
}
