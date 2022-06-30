package com.library.application.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.application.dao.Productrepo;
import com.library.application.entities.Product;
import com.library.application.service.SearchProduct;

import net.bytebuddy.asm.Advice.Return;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	SearchProduct searchProduct;
	
	@Autowired
	Productrepo productrepo;
	
	@PostMapping("/products")
	public Iterable<Product> getProduct(@RequestBody Product product)
	{
		
		

		return searchProduct.search(product);
	}
	
	
	@GetMapping("/products")
	public Iterable<Product> status()
	{
		
		return productrepo.statusProduct();

		
	}
	
	@PostMapping("products/approved")
	public void approve(@RequestBody Product product)
	{
		productrepo.save(product);
	}
	
	
	
	@DeleteMapping("products/{id}")
	public void deleteProduct(@PathVariable("id") String id)
	{
		productrepo.deleteById(id);
	}
	
//	@RequestParam("brand") String brand,@RequestParam("name") String name,@RequestParam("productCode") String code

}
