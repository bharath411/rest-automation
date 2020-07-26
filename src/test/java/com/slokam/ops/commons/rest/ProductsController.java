package com.slokam.ops.commons.rest;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.slokam.ops.commons.core.RestBase;
import com.slokam.ops.commons.pojo.Customer;
import com.slokam.ops.commons.pojo.Products;
import com.slokam.ops.commons.pojo.ProductsResult;
import com.slokam.ops.commons.utils.RestConstants;
import com.slokam.ops.testscripts.BaseTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductsController {
	String productsUrl = BaseTest.baseUrl + RestConstants.PRODUCTS;
	RestBase restBase = new RestBase();

	public int getMaxProductsId() {

		Response response = restBase.get(productsUrl);
		response.then().assertThat().statusCode(200).and().body("operationStatus", equalTo("SUCCESS"));
		String json = response.getBody().asString();

		JsonPath path = new JsonPath(json);
		ArrayList<Integer> list = (ArrayList<Integer>) path.get("items.id");
		System.out.println(list.size());

		Collections.sort(list);

		int maxId = list.get(list.size() - 1);
		return maxId;
	}

	public String createProducts(Products products) {
		Response response = restBase.post(products, productsUrl);

		String responseJson = response.getBody().asString();
		System.out.println(responseJson);
		JsonPath path = new JsonPath(responseJson);
		String statusMessage = path.get("operationStatus");
		return statusMessage;
	}

	private List<Products> getAllProducts() {

		Response response = restBase.get(productsUrl);
		response.then().assertThat().statusCode(200).and().body("operationStatus", equalTo("SUCCESS"));

		ProductsResult productResponse = response.getBody().as(ProductsResult.class);

		List<Products> products = productResponse.getProductItems();

		return products;
	}
}
