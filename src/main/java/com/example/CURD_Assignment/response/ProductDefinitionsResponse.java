package com.example.CURD_Assignment.response;

import java.util.List;

import com.example.CURD_Assignment.objects.metadataObject;
import com.example.CURD_Assignment.objects.taxationObject;

public class ProductDefinitionsResponse {
	
	     private String productMasterUID;
	     private int skuid;
	     private String name;
		 private String displayName;
	     private String discription;
	     private List<metadataObject> metaData;
	     private List<taxationObject> taxation;
	     
	     
		public ProductDefinitionsResponse(String productMasterUID, int skuid, String name, String displayName,
				String discription, List<metadataObject> metaData, List<taxationObject> taxation) {
			super();
			this.productMasterUID = productMasterUID;
			this.skuid = skuid;
			this.name = name;
			this.displayName = displayName;
			this.discription = discription;
			this.metaData = metaData;
			this.taxation = taxation;
		}
		@Override
		public String toString() {
			return "ProductDefinitionsResponse [productMasterUID=" + productMasterUID + ", skuid=" + skuid + ", name="
					+ name + ", displayName=" + displayName + ", discription=" + discription + ", metaData=" + metaData
					+ ", taxation=" + taxation + "]";
		}
		public String getProductMasterUID() {
			return productMasterUID;
		}
		public void setProductMasterUID(String productMasterUID) {
			this.productMasterUID = productMasterUID;
		}
		public int getSkuid() {
			return skuid;
		}
		public void setSkuid(int skuid) {
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
