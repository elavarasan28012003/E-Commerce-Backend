package com.elacode.elacart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elacode.elacart.entity.Product;
import com.elacode.elacart.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
    
	@Autowired
	private ProductService productservice;
	
	@GetMapping
	public Map<String, Object> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size) {
		
		return productservice.getAllProducts(page,size);
		
	}
	
	 
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productservice.getProductById(id);
    }
    
    @GetMapping("/search")
    public List<Product> SearchFilter(@RequestParam(required = false)String category,@RequestParam(required = false) Double minPrice,@RequestParam(required = false)Double maxPrice,@RequestParam(required = false)String keyword,
    		@RequestParam(required=false)Double ratings){
    	  
    	 return productservice.SearchProducts(category, minPrice, maxPrice, keyword,ratings);
    }
}
