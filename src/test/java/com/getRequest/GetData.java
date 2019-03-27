package com.getRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetData {

	@Test
	public void getResponseData()
	{			
		int code = get("https://gitlab.com/api/v4/users?username=RustyShackleford1").getStatusCode();
		
		System.out.println("Status Code is:"+code);
		
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void getResponseBody()
	{
				
		String respBody = get("https://gitlab.com/api/v4/users?username=RustyShackleford1").asString();
		
		long time= get("https://docs.gitlab.com/ee/api/users?seaerch=sairam940").getTime();
		
		System.out.println("The data is:"+ respBody);
		
		System.out.println("Response Time:"+time);
		
	}
	
	@Test
	public void getActiveUsers()
	{
		String respBodyActiveUser = get("https://gitlab.com/api/v4/users?state=active").asString();
		
		int codeActiveUser = get("https://gitlab.com/api/v4/users?state=active").getStatusCode();
		
		System.out.println("The Active User Details are:"+respBodyActiveUser);
		
		System.out.println("The status code of this test is:"+codeActiveUser);
		
	}
	
	@Test
	public void getUserProjects()
	{
		String projectDetails = get("https://gitlab.com/api/v4/projects/11499211").asString();
		
		System.out.println("The project details of user 11499211 are:"+projectDetails);
	}
	
	
}
