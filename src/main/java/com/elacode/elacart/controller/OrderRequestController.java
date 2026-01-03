package com.elacode.elacart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elacode.elacart.Dto.OrderRequestDto;
import com.elacode.elacart.entity.Order;
import com.elacode.elacart.service.OrderService;

@RestController
@RequestMapping("/api/products/orders")
public class OrderRequestController {
	
	@Autowired
	OrderService orderservice;
	
	@PostMapping
	public ResponseEntity<?> addOrder(@RequestBody OrderRequestDto order){
		   
		List<String> referenceid=   orderservice.addOrder(order);
		
		return ResponseEntity.ok().body(referenceid);
		  
		  
	}
	
	@GetMapping("/{refid}")
	public Optional<Order> GetOrder(@PathVariable String refid) {
		
		return orderservice.GetOrder(refid);
		  
	}

}
