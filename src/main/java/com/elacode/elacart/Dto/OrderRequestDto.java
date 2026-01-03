package com.elacode.elacart.Dto;

import java.util.List;



public class OrderRequestDto {
         
	private List<OrderItemDto> orderitem;

	public List<OrderItemDto> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<OrderItemDto> orderitem) {
		this.orderitem = orderitem;
	}

	public OrderRequestDto(List<OrderItemDto> orderitem) {
		super();
		this.orderitem = orderitem;
	}

	public OrderRequestDto() {
		super(); 
	}
	 
	
	
	
}
