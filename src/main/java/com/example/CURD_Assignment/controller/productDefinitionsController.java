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
import com.example.CURD_Assignment.model.Product;
import com.example.CURD_Assignment.request.productDefinitionsRequest;
import com.example.CURD_Assignment.response.ProductDefinitionsResponse;
import com.example.CURD_Assignment.services.productDefinitionsServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class productDefinitionsController {
	
	private final productDefinitionsServiceImp  productdefinitionsServiceImp;
	
	
	@Autowired
	public productDefinitionsController(productDefinitionsServiceImp  productdefinitionsServiceImp) {
		this.productdefinitionsServiceImp = productdefinitionsServiceImp;
	}
	
	 @Autowired
	 private ObjectMapper mapper;
	 
	 @GetMapping("/product/{id}")
	    public ProductDefinitionsResponse getProduct(@PathVariable("id") String productId) {
		 
	        Product product =productdefinitionsServiceImp.getProduct(productId);

	        ProductDefinitionsResponse productResponse = mapper.convertValue(product, ProductDefinitionsResponse.class);

	        return  productResponse;
	    }
	 
	 
	 @PostMapping("/product")
	    public  ProductDefinitionsResponse createProduct(@RequestBody  productDefinitionsRequest productRequest) {
		 
	        Product product = mapper.convertValue(productRequest, Product.class);
	        Product createdProduct =  productdefinitionsServiceImp.createProduct(product);
	        ProductDefinitionsResponse productResponse = mapper.convertValue(createdProduct, ProductDefinitionsResponse.class);

	        return productResponse;
	    }
	 
	 @GetMapping("/products")
	 public List<Product> getAllProducts(){
		 
		 return productdefinitionsServiceImp.getAllProduct();
		 
	 }
	 
	 @DeleteMapping("/deleteproduct/{id}")
	 public String deleteById(@PathVariable("id") String productId)
	 {
		 productdefinitionsServiceImp.deleteProduct(productId);
		 return "Element with id :" +  productId + "get deleted";
	 }
	 
	
	 @PutMapping("/updateproduct/{id}")
	 public ProductDefinitionsResponse updateProduct(@RequestBody  productDefinitionsRequest productRequest,@PathVariable("id") String productId)
	 {
		 
		 Product product = mapper.convertValue(productRequest, Product.class);
		 Product newProduct =  productdefinitionsServiceImp.updateProduct(product,productId);
		  ProductDefinitionsResponse productResponse = mapper.convertValue(newProduct, ProductDefinitionsResponse.class);
          return productResponse;

	 }

}
