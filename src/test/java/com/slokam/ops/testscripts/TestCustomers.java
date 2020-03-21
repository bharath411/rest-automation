package com.slokam.ops.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.slokam.ops.commons.listeners.CustomListener;
import com.slokam.ops.commons.pojo.Customer;
import com.slokam.ops.commons.rest.CustomerController;
import com.slokam.ops.commons.utils.AutomationUtils;

@Listeners(value=CustomListener.class)
public class TestCustomers extends BaseTest {

	@Test(groups= {"smoke"})
	public void verifyGetCustomersContainsASpecificCustomer() {
		String lastName = "Owens";
		boolean status = false;
		test.debug("testdata - lastname is " + lastName);
		CustomerController customersController = new CustomerController();

		Customer[] customers = customersController.getAllCustomers();
		test.debug("customers - Retrured number of customers " + customers.length);
		for (Customer customer : customers) {
			if (customer.getLastName().equals(lastName)) {
				status = true;
				break;
			}
		}

		Assert.assertTrue(status, "Customer with " + lastName + " not available");
		test.pass("verifyGetCustomersContainsASpecificCustomer is successful");
	}

	@Test(groups= {"smoke","regression"})
	public void verifyCreateNewCustomer() {
		String expectedStatusMessage = "SUCCESS";
		test.debug("expectedStatusMessage - is " + expectedStatusMessage);
		CustomerController customersController = new CustomerController();
		int maxId = customersController.getMaxCustomerId();
		int nextId = maxId + 1;
		String randomString = AutomationUtils.getRandomAlphabet(5);

		String firstName = "Bharath" + randomString;
		String lastName = "Kristipati " + randomString;
		String email = "Bharath." + randomString + "@gmail.com";

		Customer customer = new Customer();
		customer.setId(nextId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhone("1231231231");
		customer.setPostalCode(12312);
		customer.setState("TEL");
		customer.setCountry("INDIA");
		customer.setAddress1("sdfs12");
		customer.setAddress2("sdfds123");

		String actualStatusMessage = customersController.createCustomer(customer);
		test.debug("actualStatusMessage - is " + actualStatusMessage);
		Assert.assertEquals(actualStatusMessage, expectedStatusMessage, " Returned - " + actualStatusMessage);
		test.pass("verifyCreateNewCustomer is successful");
	}

	@Test(groups= {"regression"})
	public void verifyCreateNewCustomerWithInvalidDetils() {
		
		String expectedStatusMessage = "ERROR dsfsd";
		test.debug("expectedStatusMessage - is " + expectedStatusMessage);
		CustomerController customersController = new CustomerController();
		int maxId = customersController.getMaxCustomerId();
		int nextId = 100;
		test.debug("next Id - is " + nextId);
		String randomString = AutomationUtils.getRandomAlphabet(5);

		String firstName = "Bharath" + randomString;
		String lastName = "Kristipati " + randomString;
		String email = "Bharath." + randomString + "@gmail.com";

		Customer customer = new Customer();
		customer.setId(nextId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhone("1231231231");
		customer.setPostalCode(12312);
		customer.setState("TEL");
		customer.setCountry("INDIA");
		customer.setAddress1("sdfs12");
		customer.setAddress2("sdfds123");

		String actualStatusMessage = customersController.createCustomer(customer);
		test.debug("actualStatusMessage - is " + actualStatusMessage);
		Assert.assertEquals(actualStatusMessage, expectedStatusMessage, " Returned - " + actualStatusMessage);
		test.pass("verifyCreateNewCustomerWithInvalidDetils is successful");
	}
}
