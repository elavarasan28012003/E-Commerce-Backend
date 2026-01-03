package com.elacode.elacart.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class ProductReview {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Min(value = 0)
	@Max(value=5)
	private Double rating=0.0;
	
	private String Comment;
     
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="product_id")
	private Product product;
    
	public ProductReview(Long id, @Min(0) @Max(5) Double rating, String comment, Product product) {
		super();
		this.id = id;
		this.rating = rating;
		Comment = comment;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	

	public ProductReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
