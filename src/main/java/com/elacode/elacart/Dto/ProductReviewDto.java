package com.elacode.elacart.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductReviewDto {
    
	@NotNull
	private Long productId;
	
	@NotBlank
	private String comment;
	private Double rating;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public ProductReviewDto(Long productId, String comment, Double rating) {
		super();
		this.productId = productId;
		this.comment = comment;
		this.rating = rating;
	}
	public ProductReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
