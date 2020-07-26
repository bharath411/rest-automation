package com.slokam.ops.commons.pojo;

import java.util.HashMap;
import java.util.Map;

public class Products {

	private String category;
	private String description;
	private Integer discontinued;
	private Integer id;
	private Integer listPrice;
	private Integer minimumReorderQuantity;
	private String productCode;
	private String productName;
	private String quantityPerUnit;
	private Integer reorderLevel;
	private Integer standardCost;
	private Integer targetLevel;
	 
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getCategory() {
	return category;
	}

	public void setCategory(String category) {
	this.category = category;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(String description) {
	this.description = description;
	}

	public Integer getDiscontinued() {
	return discontinued;
	}

	public void setDiscontinued(Integer discontinued) {
	this.discontinued = discontinued;
	}

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}

	public Integer getListPrice() {
	return listPrice;
	}

	public void setListPrice(Integer listPrice) {
	this.listPrice = listPrice;
	}

	public Integer getMinimumReorderQuantity() {
	return minimumReorderQuantity;
	}

	public void setMinimumReorderQuantity(Integer minimumReorderQuantity) {
	this.minimumReorderQuantity = minimumReorderQuantity;
	}

	public String getProductCode() {
	return productCode;
	}

	public void setProductCode(String productCode) {
	this.productCode = productCode;
	}

	public String getProductName() {
	return productName;
	}

	public void setProductName(String productName) {
	this.productName = productName;
	}

	public String getQuantityPerUnit() {
	return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
	this.quantityPerUnit = quantityPerUnit;
	}

	public Integer getReorderLevel() {
	return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
	this.reorderLevel = reorderLevel;
	}

	public Integer getStandardCost() {
	return standardCost;
	}

	public void setStandardCost(Integer standardCost) {
	this.standardCost = standardCost;
	}

	public Integer getTargetLevel() {
	return targetLevel;
	}

	public void setTargetLevel(Integer targetLevel) {
	this.targetLevel = targetLevel;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}
