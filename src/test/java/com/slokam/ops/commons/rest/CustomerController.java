package com.slokam.ops.commons.rest;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Collections;

import com.slokam.ops.commons.core.RestBase;
import com.slokam.ops.commons.pojo.Customer;
import com.slokam.ops.commons.pojo.CustomerResult;
import com.slokam.ops.commons.utils.RestConstants;
import com.slokam.ops.testscripts.BaseTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CustomerController {

	public Customer[] getAllCustomers() {

		Customer[] customers = getCustomers();
		return customers;

	}

	public Customer getCustomer(String firstName, String lastName) {

		Customer[] customers = getCustomers();
		Customer customerToReturn = null;
		for (Customer customer : customers) {
			if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
				customerToReturn = customer;
				break;
			}
		}

		return customerToReturn;
	}

	public int getMaxCustomerId() {

		String customersUrl = BaseTest.baseUrl + RestConstants.CUSTOMERS;

		RestBase restBase = new RestBase();
		Response response = restBase.get(customersUrl);
		response.then().assertThat().statusCode(200).and().body("operationStatus", equalTo("SUCCESS"));
		String json = response.getBody().asString();

		JsonPath path = new JsonPath(json);
		ArrayList<Integer> list = (ArrayList<Integer>) path.get("items.id");
		System.out.println(list.size());

		Collections.sort(list);

		int maxId = list.get(list.size() - 1) ;
		return maxId;
	}
	
	public String createCustomer(Customer customer) {
		String customersUrl = BaseTest.baseUrl + RestConstants.CUSTOMERS;
		RestBase restBase = new RestBase();
		
		Response response =  restBase.post(customer, customersUrl);
		
		String responseJson = response.getBody().asString();
		System.out.println(responseJson);
		JsonPath path = new JsonPath(responseJson);
		String statusMessage = path.get("operationStatus");
		return statusMessage;
	}

	private Customer[] getCustomers() {
		String customersUrl = BaseTest.baseUrl + RestConstants.CUSTOMERS;

		RestBase restBase = new RestBase();
		Response response = restBase.get(customersUrl);
		response.then().assertThat().statusCode(200).and().body("operationStatus", equalTo("SUCCESS"));

		CustomerResult customerResult = response.getBody().as(CustomerResult.class);

		Customer[] customers = customerResult.getItems();

		return customers;
	}
}
