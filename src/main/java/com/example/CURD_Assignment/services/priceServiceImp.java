package com.example.CURD_Assignment.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CURD_Assignment.exception.resourcesNotFoundException;
import com.example.CURD_Assignment.model.Price;
import com.example.CURD_Assignment.repository.priceRepository;

@Service
public class priceServiceImp implements priceService{
	
	private priceRepository repository;
	
	@Autowired 
	public priceServiceImp(priceRepository repository) {
		
		this.repository = repository;
		
	}

	@Override
	public Price getPrice(String id) {
		
		Price priceOptional = repository.findById(id).orElseThrow(() -> new resourcesNotFoundException(id));
		return priceOptional;
	}

	@Override
	public Price createPrice(Price price) {
		
		 if (price.currentPrice == 0 || price.regularPrice == 0) {
	            return null;
	        }
	     return repository.save(price);
		
		
	}

	@Override
	public void deletePrice(String id) {
		
		Price price = getPrice(id);
		
		repository.delete(price);
		
		
	}

	@Override
	public Price updatePrice(Price price, String id) {
		
		Price newPrice = getPrice(id);
		newPrice.setCurrentPrice(price.getCurrentPrice());
		newPrice.setRegularPrice(price.getRegularPrice());
		repository.save(newPrice);
		
		return newPrice;
	}

	@Override
	public List<Price> getAllPrice() {
	
		return repository.findAll();
		
	}
	
	public Price updatePriceService(String priceId, String id)
	{
		Price newPrice = getPrice(id);
		newPrice.setProductMasterUID(priceId);
		repository.save(newPrice);
		return newPrice;
	}
	
	
	
	
	

}
