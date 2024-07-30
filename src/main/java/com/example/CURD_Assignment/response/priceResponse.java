package com.example.CURD_Assignment.response;

public class priceResponse {

	
	public String productMasterUID;
	public int regularPrice;
	public int currentPrice;
	
	public String getProductMasterUID() {
		return productMasterUID;
	}
	public void setProductMasterUID(String productMasterUID) {
		this.productMasterUID = productMasterUID;
	}
	public int getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(int regularPrice) {
		this.regularPrice = regularPrice;
	}
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
	@Override
	public String toString() {
		return "priceResponse [productMasterUID=" + productMasterUID + ", regularPrice=" + regularPrice
				+ ", currentPrice=" + currentPrice + "]";
	}
	public priceResponse(String productMasterUID, int regularPrice, int currentPrice) {
		super();
		this.productMasterUID = productMasterUID;
		this.regularPrice = regularPrice;
		this.currentPrice = currentPrice;
	}
	
	
	
	
}
