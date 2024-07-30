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
import com.example.CURD_Assignment.model.Product;
import com.example.CURD_Assignment.objects.priceProductObject;
import com.example.CURD_Assignment.objects.priceProductObjectList;
import com.example.CURD_Assignment.services.priceServiceImp;
import com.example.CURD_Assignment.services.productDefinitionsServiceImp;
import com.example.CURD_Assignment.services.productPriceService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class priceAndProductController {
	
    private final priceServiceImp priceImp;
    private final productDefinitionsServiceImp  productdefinitionsServiceImp;
	
    
    @Autowired
    private productPriceService productpriceservice;
	
	@Autowired
	public priceAndProductController(priceServiceImp priceImp,productDefinitionsServiceImp  productdefinitionsServiceImp)
	{
		this.priceImp = priceImp;
		this.productdefinitionsServiceImp = productdefinitionsServiceImp;
		
	}
	
   @PostMapping("priceProduct")
   public priceProductObject addPriceProduct(@RequestBody priceProductObject priceproduct)
   {
	   Price newPrice = priceproduct.getPrice();
	   Product newProduct = priceproduct.getProduct();
	   return productpriceservice.createPriceProduct(newPrice,newProduct);
	 
   }
	
   

   @PutMapping("updatePriceProduct/{id}")
   public priceProductObject updatePriceProduct(@RequestBody priceProductObject priceproduct,@PathVariable("id") String id)
   {
	   Price newPrice = priceproduct.getPrice();
	   Product newProduct = priceproduct.getProduct();
	   priceImp.updatePrice(newPrice, id);
	   productdefinitionsServiceImp.updateProduct(newProduct, id);
	   priceProductObject createpriceproduct = new priceProductObject(priceImp.getPrice(id),productdefinitionsServiceImp.getProduct(id));
	   return createpriceproduct;
   }
   
	@GetMapping("priceProduct/{id}")
	public priceProductObject getPriceProductById(@PathVariable("id") String id)
	{
		
		priceProductObject priceProduct = new priceProductObject(priceImp.getPrice(id),productdefinitionsServiceImp.getProduct(id));
		return priceProduct;
		
	}
	
	@GetMapping("priceProduct")
	public priceProductObjectList getPriceProductObject()
	{
		List<Price> prices = priceImp.getAllPrice();
		List<Product> product = productdefinitionsServiceImp.getAllProduct();	
		priceProductObjectList priceproductObjectList = new priceProductObjectList(prices,product);
		return priceproductObjectList;
	}
	
    @DeleteMapping("/deletePriceProduct/{id}")
    public String deletePriceProduct(@PathVariable("id") String id)
    {
    	priceImp.deletePrice(id);
    	productdefinitionsServiceImp.deleteProduct(id);
    	return "Elements with product id : " + id + "get deleted";
    }
}
