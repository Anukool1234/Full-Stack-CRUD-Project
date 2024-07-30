package com.example.CURD_Assignment.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CURD_Assignment.model.Price;
import com.example.CURD_Assignment.model.Product;
import com.example.CURD_Assignment.objects.priceProductObject;
import com.example.CURD_Assignment.repository.priceRepository;
import com.example.CURD_Assignment.repository.productDefinitionsRepository;

@Service
public class productPriceService {

	
	private priceRepository repository;
	private final productDefinitionsRepository productdefinitionsRepository;
	
	@Autowired
	public productPriceService( priceRepository repository,productDefinitionsRepository productdefinitionsRepository)
	{
		this.repository = repository;
		this.productdefinitionsRepository = productdefinitionsRepository;
	}
	
	public priceProductObject createPriceProduct(Price price,Product product)
	{
		 UUID  productMasterUID = UUID.randomUUID();
		 product.setProductMasterUID(productMasterUID.toString());
		 price.setProductMasterUID(productMasterUID.toString());
		 repository.save(price);
		 productdefinitionsRepository.save(product);
		 priceProductObject newPriceProductObject = new priceProductObject(price,product);
		 return newPriceProductObject;
	}


	
}
