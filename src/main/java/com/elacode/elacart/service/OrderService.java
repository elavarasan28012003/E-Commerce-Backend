package com.elacode.elacart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elacode.elacart.Dto.OrderItemDto;
import com.elacode.elacart.Dto.OrderRequestDto;
import com.elacode.elacart.Repository.OrderRepository;
import com.elacode.elacart.Repository.ProductRepository;
import com.elacode.elacart.entity.Order;
import com.elacode.elacart.entity.OrderItem;
import com.elacode.elacart.entity.Product;

@Service
public class OrderService {
	

	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	ProductRepository prorep;

	public List<String> addOrder(OrderRequestDto order) {

	    Order orders = new Order();

	    double totalItemAmount = 0.0;
	    double totalTaxAmount = 0.0;
	    double totalAmount = 0.0;

	    String status = "Completed";

	    for (OrderItemDto itemdto : order.getOrderitem()) {

	        OrderItem item = new OrderItem();
	        item.setName(itemdto.getName());
	        item.setImage(itemdto.getImage());
	        item.setPrice(itemdto.getPrice());
	        item.setQuantity(itemdto.getQuantity());

	        Product product = prorep.findById(itemdto.getProduct_id())
	                .orElseThrow(() -> new RuntimeException("there is no product with this id"));

	        item.setProduct(product);

	        // ✅ item level calculation
	        double itemTotal = itemdto.getPrice() * itemdto.getQuantity();
	        double itemTax = itemTotal * 0.10; // 10% tax

	        totalItemAmount += itemTotal;
	        totalTaxAmount += itemTax;
	    }

	    totalAmount = totalItemAmount + totalTaxAmount;

	    orders.setTotalItemsAmount(totalItemAmount);
	    orders.setTaxAmount(totalTaxAmount);
	    orders.setTotalAmount(totalAmount);
	    orders.setStatus(status);

	    String reference = UUID.randomUUID().toString();
	    orders.setReferenceId(reference);

	    orderrepo.save(orders);

	    return List.of(reference);
	}

	public Optional<Order> GetOrder(String refid) {
		 return   orderrepo.findByReferenceId(refid);
		
	}
	 
	
        
}
