package com.example.CURD_Assignment.objects;

import java.util.List;

import com.example.CURD_Assignment.model.Price;
import com.example.CURD_Assignment.model.Product;

public class priceProductObjectList {
	
	public List<Price>  prices;
	public List<Product> products;
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public priceProductObjectList(List<Price> prices, List<Product> products) {
		super();
		this.prices = prices;
		this.products = products;
	}
	@Override
	public String toString() {
		return "priceProductObjectList [prices=" + prices + ", products=" + products + "]";
	}
	
}
