package com.elacode.elacart.Dto;

public class OrderItemDto {
        
	private String name;
	private Double quantity;
	private Double price;
	private String image;
	private Long product_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public OrderItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public OrderItemDto(String name, Double quantity, Double price, String image, Long product_id) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.product_id = product_id;
	}
}
