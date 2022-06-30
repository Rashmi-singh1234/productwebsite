package com.library.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Registration")
public class UserRegistration {

	@Id
	@Column(name = "email_id")
	private String email;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "Password")
	private String password;

	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegistration(String email, String firstName, String lastName, String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRegestration [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}
	
	
	
}
