package com.dareen.web.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.dom4j.swing.XMLTableColumnDefinition;

@Entity
@Table(name = "products")
public class Product {

	@Column(name = "productName")
	private String productName;

	@Column(name = "productCode")
	@Id
	private String productCode;

	@Column(name = "productLine")
	private String productLine;

//	@Column(name = "productScale")
//	private String productScale;
//
//	@Column(name = "productVendor")
//	private String productVendor;

	@Column(name = "productDescription")
	private String productDescription;

	@Column(name = "quantityInStock")
	private int quantityInStock;

	@Column(name = "buyPrice")
	private float buyPrice;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;

//	@Column(name = "MSRP")
//	private long MSRP;


	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

//	public void setProductScale(String productScale) {
//		this.productScale = productScale;
//	}
//
//	public void setProductVendor(String productVendor) {
//		this.productVendor = productVendor;
//	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

//	public void setMSRP(long mSRP) {
//		MSRP = mSRP;
//	}

	public String getProductName() {
		return productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductLine() {
		return productLine;
	}

//	public String getProductScale() {
//		return productScale;
//	}
//
//	public String getProductVendor() {
//		return productVendor;
//	}

	public String getProductDescription() {
		return productDescription;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public float getBuyPrice() {
		return buyPrice;
	}
//
//	public long getMSRP() {
//		return MSRP;
//	}

}
