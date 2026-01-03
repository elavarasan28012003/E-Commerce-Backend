package com.elacode.elacart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elacode.elacart.Dto.ProductReviewDto;
import com.elacode.elacart.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/products/reviews")
public class ProductReviewController {
	 
	    @Autowired
	 private ProductService productservice;
	
	@PostMapping
	public ResponseEntity<?> addReview(@RequestBody  @Valid ProductReviewDto reviews ){
		
		return productservice.addReviews(reviews);
	}

}
