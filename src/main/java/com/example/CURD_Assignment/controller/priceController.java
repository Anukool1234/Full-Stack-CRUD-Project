package com.example.CURD_Assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CURD_Assignment.model.Price;
import com.example.CURD_Assignment.request.priceRequest;
import com.example.CURD_Assignment.response.priceResponse;
import com.example.CURD_Assignment.services.priceServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class priceController {
	
	private final priceServiceImp priceImp;
	
	@Autowired 
	public priceController(priceServiceImp priceImp)
	{
		this.priceImp = priceImp;
	}
	
	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping("/price/{id}")
	public priceResponse getPrice(@PathVariable("id") String priceId)
	{
		
		 Price price = priceImp.getPrice(priceId);
		 priceResponse createResponse = mapper.convertValue(price, priceResponse.class);
		 return createResponse;
	}
	
	@GetMapping("/prices")
	public List<Price> getAllPrice()
	{

		 return priceImp.getAllPrice();
		 
	}
	
	@PostMapping("/price")
	public priceResponse addPrice(@RequestBody priceRequest pricerequest)
	{

		Price newPrice = mapper.convertValue(pricerequest, Price.class);
		priceImp.createPrice(newPrice);
		priceResponse createResponse  = mapper.convertValue(newPrice, priceResponse.class);
		 return createResponse;
	}
	
	@DeleteMapping("/deletePrice/{id}")
	public String deletePrice(@PathVariable("id") String id)
	{
		priceImp.deletePrice(id);
		return "Price with id : "+ id + " get deleted";
	}
	
	@PutMapping("updatePrice/{id}")
	public priceResponse updatePrice(@RequestBody priceRequest pricerequest,@PathVariable("id") String id)
	{
		Price newPrice =  mapper.convertValue(pricerequest, Price.class);
		Price createPrice = priceImp.updatePrice(newPrice, id);
		priceResponse createResponse  = mapper.convertValue(createPrice, priceResponse.class);
		return createResponse;
	}
	

}
