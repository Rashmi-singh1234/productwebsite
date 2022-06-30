package com.library.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "login")
public class UserLogin {

	@Id
	@Column(name = "email_id")
	private String email;
	@Column(name = "password")
	private String password;
	
	@Column(name = "auth_detail")
	private String type;
	
	public String getEmail() {
		return email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public UserLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	
	
}
