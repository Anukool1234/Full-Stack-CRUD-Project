package com.example.CURD_Assignment.services;

import java.util.List;

import com.example.CURD_Assignment.model.Product;

public interface productDefinitionsService {
	
	Product getProduct(String id);
	List<Product> getAllProduct();
	Product createProduct(Product product);
	Product updateProduct(Product product,String id);
	Product deleteProduct(String id);
	

}
