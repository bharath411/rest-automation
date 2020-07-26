package com.slokam.ops.testscripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.slokam.ops.commons.pojo.Products;
import com.slokam.ops.commons.rest.ProductsController;

public class TestProducts extends BaseTest {

	@Test(groups= {"regression"})
	public void verifyCreateProductsTest() {
		
		test.info("Test is started");
		String expectedTestdata = "SUCCESS";
		String actualTestdate = "";
		
		Products product = new Products();
		product.setId(2999);
		product.setCategory("CAM");
		product.setProductCode("sddsf");
		product.setListPrice(120);
		product.setProductName("campe1");
		product.setDiscontinued(0);
		product.setStandardCost(122);
		product.setMinimumReorderQuantity(1);
		
		ProductsController productsController = new ProductsController();
		String actualString = productsController.createProducts(product);
		test.debug("actual message - " + actualString);
		Assert.assertEquals(actualString, expectedTestdata);
		test.pass("verifyCreateProductsTest is successful");

	}
}
