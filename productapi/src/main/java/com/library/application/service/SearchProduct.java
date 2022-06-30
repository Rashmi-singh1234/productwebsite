package com.library.application.service;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.application.dao.Productrepo;
import com.library.application.entities.Product;


@Component
public class SearchProduct {

	@Autowired
	Productrepo productrepo;
	
	public Iterable<Product> search(Product product) {
		

		if(product.getProductCode()!="")
		{
		Iterable<Product> val1=productrepo.findAllByName(product.getBrand(),product.getName(),product.getProductCode());
//		System.out.println("value "+val1);
		return val1;
		}
		else {
			Iterable<Product> val1=productrepo.findAllByName(product.getBrand(),product.getName());
			return val1;
		}
		
		
	}
}
