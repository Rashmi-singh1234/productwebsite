package com.library.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.application.dao.Reviewrepo;
import com.library.application.entities.Review;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

	@Autowired
	Reviewrepo reviewrepo;
	
	
	@PostMapping("/products/{id}")
	public void  review(@PathVariable("id") String code,@RequestBody Review review) {
		
		reviewrepo.save(review);
		
	}
	
	@PutMapping("/products/{id}")
	public void adminreview(@PathVariable("id") String id,@RequestBody Review review)
	{
		Review originalReview=reviewrepo.findByCode(Integer.parseInt(id));
			originalReview.setStatus(review.getStatus());
			
			reviewrepo.save(originalReview);
	}
	
	@GetMapping("/products/{id}")
	public Iterable<Review> details(@PathVariable("id") String code)
	{
		Iterable<Review> review=reviewrepo.findByProductCode(code);
		
		return review;
	}
	
	@GetMapping("/products/status/{id}")
	public Iterable<Review> statusReview(@PathVariable("id") String code)
	
	{
		Iterable<Review> review=reviewrepo.findByStat(code);
		
		return review;
		
	}
	 
	
}
