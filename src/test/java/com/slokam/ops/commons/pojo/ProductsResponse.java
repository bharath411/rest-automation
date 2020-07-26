package com.slokam.ops.commons.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsResponse {

	public List<Products> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<Products> productItems) {
		this.productItems = productItems;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	private String operationStatus;
	private String operationMessage;
	private Boolean first;
	private Boolean last;
	private Integer currentPageNumber;
	private Integer itemsInPage;
	private Integer pageSize;
	private Integer totalPages;
	private Integer totalItems;
	private Object sort;
	private List<Products> productItems = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getOperationStatus() {
	return operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
	this.operationStatus = operationStatus;
	}

	public String getOperationMessage() {
	return operationMessage;
	}

	public void setOperationMessage(String operationMessage) {
	this.operationMessage = operationMessage;
	}

	public Boolean getFirst() {
	return first;
	}

	public void setFirst(Boolean first) {
	this.first = first;
	}

	public Boolean getLast() {
	return last;
	}

	public void setLast(Boolean last) {
	this.last = last;
	}

	public Integer getCurrentPageNumber() {
	return currentPageNumber;
	}

	public void setCurrentPageNumber(Integer currentPageNumber) {
	this.currentPageNumber = currentPageNumber;
	}

	public Integer getItemsInPage() {
	return itemsInPage;
	}

	public void setItemsInPage(Integer itemsInPage) {
	this.itemsInPage = itemsInPage;
	}

	public Integer getPageSize() {
	return pageSize;
	}

	public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
	return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
	this.totalPages = totalPages;
	}

	public Integer getTotalItems() {
	return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
	this.totalItems = totalItems;
	}

	public Object getSort() {
	return sort;
	}

	public void setSort(Object sort) {
	this.sort = sort;
	}

	public List<Products> getItems() {
	return productItems;
	}

	public void setItems(List<Products> productItems) {
	this.productItems = productItems;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
