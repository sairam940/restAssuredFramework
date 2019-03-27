package com.getRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PostData {

	
	@Test
	public void test1()
	{
		RequestSpecification request= given();
		
		request.header("content-type", "application/json");
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("id", "111");
		jsonObj.put("first-name", "Ram");
		jsonObj.put("last-name", "Pullabhotla");
		jsonObj.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
		
		request.body(jsonObj.toJSONString());
		
		Response response =  request.post("https://reqres.in/api/users");
		
		int code = response.getStatusCode();
		
		Assert.assertEquals(code, 201);
		
	}
}
