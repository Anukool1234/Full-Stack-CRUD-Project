package com.example.CURD_Assignment.services;

import java.util.List;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CURD_Assignment.exception.resourcesNotFoundException;
import com.example.CURD_Assignment.model.Product;
import com.example.CURD_Assignment.repository.productDefinitionsRepository;

@Service
public class productDefinitionsServiceImp implements productDefinitionsService {
	
	private final productDefinitionsRepository productdefinitionsRepository;
	
     
	
	  @Autowired
	    public productDefinitionsServiceImp( productDefinitionsRepository productdefinitionsRepository) {
	        this.productdefinitionsRepository = productdefinitionsRepository;
	    }

	@Override
	public Product getProduct(String id) {
		
		 Product productOptional = productdefinitionsRepository.findById(id).orElseThrow(() -> new resourcesNotFoundException(id));
	        return productOptional;
		
	}

	@Override
	public Product createProduct(Product product) {
		
		 if (product == null) {
	            return null;
	        }
		 UUID  productMasterUID = UUID.randomUUID();
		 product.setProductMasterUID(productMasterUID.toString());
	     return productdefinitionsRepository.save(product);
		
	}

	@Override
	public Product updateProduct(Product product,String id) {
		
		
		        Product newProduct = getProduct(id);
		
				if(product.getSkuid() != 0)
				{
					newProduct.setSkuid(product.getSkuid());
				}

				if(product.getName() != null)
				{
					newProduct.setName(product.getName());
				}
				

				if(product.getDisplayName() != null)
				{
					newProduct.setDisplayName(product.getDisplayName());
				}
				
				if(product.getDiscription() != null)
				{
					newProduct.setDiscription(product.getDiscription());
				}
				if(product.getMetaData() != null)
				{
					newProduct.setMetaData(product.getMetaData());
				}
				if(product.getTaxation() != null)
				{
					newProduct.setTaxation(product.getTaxation());
				}
			   productdefinitionsRepository.save(newProduct);
		       return newProduct;
	}

	@Override
	public Product deleteProduct(String id) {
		
		Product newProduct = getProduct(id);
		
		productdefinitionsRepository.delete(newProduct);
	    return null;	
	}

	@Override
	public List<Product> getAllProduct() {
	
		return productdefinitionsRepository.findAll();
		
	}


}
