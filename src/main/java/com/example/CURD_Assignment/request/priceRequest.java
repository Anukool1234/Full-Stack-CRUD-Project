package com.example.CURD_Assignment.request;

public class priceRequest {
	
	public String productMasterUID;
	public int regularPrice;
	public int currentPrice;
	
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
		return "priceRequest [regularPrice=" + regularPrice + ", currentPrice=" + currentPrice + "]";
	}
	public priceRequest(int regularPrice, int currentPrice) {
		super();
		this.regularPrice = regularPrice;
		this.currentPrice = currentPrice;
	}

	
}
