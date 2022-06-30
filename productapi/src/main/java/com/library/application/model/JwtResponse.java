package com.library.application.model;

public class JwtResponse {

	private String token;

	private String name;
	
	private String type;

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String token, String name, String type) {
		super();
		this.token = token;
		this.name = name;
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", name=" + name + ", type=" + type + "]";
	}

	
	

	
	
	
}
