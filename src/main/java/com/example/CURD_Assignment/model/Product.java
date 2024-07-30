package com.example.CURD_Assignment.model;



import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.CURD_Assignment.objects.metadataObject;
import com.example.CURD_Assignment.objects.taxationObject;

import lombok.Data;


@Document(collection = "myProduct")
@Data
public class Product {
	
	 @Id
	 private String productMasterUID;
	 private Integer skuid;
	 private String name;
	 private String displayName;
     private String discription;
	 private List<metadataObject> metaData;
	 private List<taxationObject> taxation;
	 
	 
	public Product(String productMasterUID, Integer skuid, String name, String displayName, String discription,
			List<metadataObject> metaData, List<taxationObject> taxation) {
		
		super();
		this.productMasterUID = productMasterUID;
		this.skuid = skuid;
		this.name = name;
		this.displayName = displayName;
		this.discription = discription;
		this.metaData = metaData;
		this.taxation = taxation;
	}
	public String getProductMasterUID() {
		return productMasterUID;
	}
	public void setProductMasterUID(String productMasterUID) {
		this.productMasterUID = productMasterUID;
	}
	public Integer getSkuid() {
		return skuid;
	}
	public void setSkuid(Integer skuid) {
		this.skuid = skuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<metadataObject> getMetaData() {
		return metaData;
	}
	public void setMetaData(List<metadataObject> metaData) {
		this.metaData = metaData;
	}
	public List<taxationObject> getTaxation() {
		return taxation;
	}
	public void setTaxation(List<taxationObject> taxation) {
		this.taxation = taxation;
	}
	 
	 
	
	 
	 
	

}
