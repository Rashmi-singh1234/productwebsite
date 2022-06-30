package com.library.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.library.application.dao.Productrepo;
import com.library.application.entities.Product;


@SpringBootApplication
public class ProductapiApplication {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProductapiApplication.class, args);


		
		
	}

	
	
	
}
