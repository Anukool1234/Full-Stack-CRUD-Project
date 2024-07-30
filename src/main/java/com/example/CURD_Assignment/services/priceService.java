package com.example.CURD_Assignment.services;

import java.util.List;

import com.example.CURD_Assignment.model.Price;

public interface priceService {

	List<Price> getAllPrice();
	Price getPrice(String id);
	Price createPrice(Price price);
	void deletePrice(String id);
	Price updatePrice(Price price, String id);
	
	
}
