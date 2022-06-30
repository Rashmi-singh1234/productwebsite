package com.library.application.entities;


import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "code")
	private String productCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name = "status")
	private Boolean status;
	
	@Lob
	private byte[] image;
		
	@Transient
	private String base64Image;


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String productCode, String name, String brand, Boolean status, byte[] image, String base64Image) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.brand = brand;
		this.status = status;
		this.image = image;
		this.base64Image = base64Image;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getBase64Image() {
		return base64Image;
	}


	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}



	

}
