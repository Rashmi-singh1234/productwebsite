package com.library.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sno;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "product_Code")
	private String productCode;
	
	@Column(name = "rating")
	private Double rating;
	
	@Column(name = "status")
	private Boolean status;

	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Review(Integer sno, String comment, String email, String productCode, Double rating, Boolean status) {
		super();
		this.sno = sno;
		this.comment = comment;
		this.email = email;
		this.productCode = productCode;
		this.rating = rating;
		this.status = status;
	}



	public Integer getSno() {
		return sno;
	}



	public void setSno(Integer sno) {
		this.sno = sno;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public Double getRating() {
		return rating;
	}



	public void setRating(Double rating) {
		this.rating = rating;
	}



	public Boolean getStatus() {
		return status;
	}



	public void setStatus(Boolean status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Review [sno=" + sno + ", comment=" + comment + ", email=" + email + ", productCode=" + productCode
				+ ", rating=" + rating + ", status=" + status + "]";
	}


	

}
