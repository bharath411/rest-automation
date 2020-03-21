package com.slokam.ops.commons.core;

import static io.restassured.RestAssured.*;

import com.slokam.ops.commons.pojo.Customer;
import com.slokam.ops.testscripts.BaseTest;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestBase {

	Header contentType = new Header("Content-Type","application/json");
	String authValue = "Bearer " + BaseTest.token;
	Header authorization = new Header("Authorization",authValue);
	
	public Response get(String url) {
		Response  response =  given()
				.header(authorization)
				.queryParam("size", "200")
				.get(url);
		return response;
	}

	public Response postWithoutAuth(String body,String url) {
		Response response = given()
				.header(contentType)
				.body(body)
				.post(url);
		return response;
	}
	
	public Response postWithAuth(String body,String url) {
		Response response = given()
				.header(contentType)
				.header(authorization)
				.body(body)
				.post(url);
		return response;
	}
	
	public Response post(Customer customerBody,String url) {
		Response response = given()
				.header(contentType)
				.header(authorization)
				.body(customerBody)
				.post(url);
		return response;
	}
}
