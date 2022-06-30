package com.library.application.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.application.dao.Loginrepo;
import com.library.application.dao.Productrepo;
import com.library.application.dao.Registerrepo;
import com.library.application.entities.Product;
import com.library.application.entities.UserLogin;
import com.library.application.entities.UserRegistration;
import com.library.application.service.LoginAuthentication;
import com.library.application.service.RegisterAuthentication;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	@Autowired
	Loginrepo loginrepo;
	
	@Autowired
	Registerrepo registerrepo;
	
	@Autowired
	LoginAuthentication authentication;
	
	@Autowired
	RegisterAuthentication registerAuthentication;
	
	@Autowired
	Productrepo productrepo;
	@GetMapping("/")
	public String home()
	{
		return "spring boot is working";
	}
	
	@PostMapping("/add")
	public void image(@RequestBody Product product) throws IOException
	{
		
		
		String ad="src/main/resources/images/8.jpg";
		FileInputStream fis=new FileInputStream(ad);
		byte[] data=new byte[fis.available()];
		product.setImage(data);
		fis.read(data);
//		Product product =new Product("111","tshirt","nike",data,st);
		productrepo.save(product);
	}
	
	@PostMapping("/register")
	public Boolean register(@RequestBody UserRegistration userRegistration)
	{
		UserLogin userLogin =new UserLogin();
		userLogin.setEmail(userRegistration.getEmail());
		userLogin.setPassword(userRegistration.getPassword());
		if(userLogin.getPassword().equals("12345"))
		userLogin.setType("admin");
		else {
			userLogin.setType("user");
		}
		if(registerAuthentication.authenicate(userRegistration))
		{
			registerrepo.save(userRegistration);
			loginrepo.save(userLogin);
			return true;
		}
		
		return false;
	}
}
