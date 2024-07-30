package com.example.CURD_Assignment.objects;

import com.example.CURD_Assignment.model.Price;
import com.example.CURD_Assignment.model.Product;

public class priceProductObject {
	
	public Product product;
	public Price price;
	
	
	
	public priceProductObject(Price price, Product product) {
		super();
		this.price = price;
		this.product = product;
	}
	@Override
	public String toString() {
		return "priceProductObject [price=" + price + ", product=" + product + "]";
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
