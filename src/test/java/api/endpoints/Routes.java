package api.endpoints;
/*
 * Swagger url: https://petstore.swagger.io
 * create user(post): https://petstore.swagger.io/v2/user
   Get user(Get): https://petstore.swagger.io/v2/user/{username}
   Update User(Put):https://petstore.swagger.io/v2/user/{username}
   Delete User(Delete):https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	public static String base_url="https://petstore.swagger.io/v2";
	//user Model
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//store module
	  // here we'll create store module URL's
	
	//pet module
	// here we'll create pet module URL's

}
