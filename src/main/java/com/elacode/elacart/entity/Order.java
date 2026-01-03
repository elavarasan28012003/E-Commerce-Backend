package com.elacode.elacart.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	
	 @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	 @JoinColumn(name="order_id")
	private List<OrderItem> orderitem = new ArrayList<>();
	 
	private Double TotalItemsAmount;
	private Double TaxAmount;
	private Double TotalAmount;
	private String status="pending";
	private String referenceId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderItem> getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(List<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}
	public Double getTotalItemsAmount() {
		return TotalItemsAmount;
	}
	public void setTotalItemsAmount(Double totalItemsAmount) {
		TotalItemsAmount = totalItemsAmount;
	}
	public Double getTaxAmount() {
		return TaxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		TaxAmount = taxAmount;
	}
	public Double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public Order(Long id, List<OrderItem> orderitem, Double totalItemsAmount, Double taxAmount, Double totalAmount,
			String status, String referenceId) {
		super();
		this.id = id;
		this.orderitem = orderitem;
		TotalItemsAmount = totalItemsAmount;
		TaxAmount = taxAmount;
		TotalAmount = totalAmount;
		this.status = status;
		this.referenceId = referenceId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
