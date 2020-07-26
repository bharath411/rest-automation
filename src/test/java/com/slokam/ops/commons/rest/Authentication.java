package com.slokam.ops.commons.rest;

import com.slokam.ops.commons.core.RestBase;
import com.slokam.ops.commons.utils.RestConstants;
import com.slokam.ops.testscripts.BaseTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Authentication {

	
	
	public String createSession() {
		String username = BaseTest.username;
		String password = BaseTest.password;
		String userJson = "{\r\n" + "	\"username\": "+username+",\r\n" + "	\"password\":"+password+"\r\n" + "}";
		
		RestBase restBase = new RestBase();
		String sessionUrl = BaseTest.baseUrl + RestConstants.SESSION;
		Response response  = restBase.postWithoutAuth(userJson, sessionUrl);
		String responseBody = response.getBody().asString();

		JsonPath path = new JsonPath(responseBody);
		String token = path.get("item.token");
		System.out.println(token);
		
		return token;
	}
	
}
