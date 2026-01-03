package com.elacode.elacart.service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elacode.elacart.Dto.ProductDto;
import com.elacode.elacart.Dto.ProductImageDto;
import com.elacode.elacart.Dto.ProductReviewDto;
import com.elacode.elacart.Repository.ProductRepository;
import com.elacode.elacart.Repository.ProductreviewRepository;
import com.elacode.elacart.entity.Product;
import com.elacode.elacart.entity.ProductReview;
import com.elacode.elacart.specification.ProductSpecification;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	ProductreviewRepository productreviewrepo;
	


	public Map<String, Object> getAllProducts(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
		    Page<Product> products = productrepository.findAll(pageable);
		    
		    List<ProductDto> productdto =  products.stream().map(this::convertToDto).collect(Collectors.toList());
		    
		    Map<String, Object> response = new LinkedHashMap<>(); 
		    response.put("ProductsCount", productdto.size());
		    response.put("Products", productdto);
		    return response;
	}
	
	 public ProductDto convertToDto(Product product) {
		    ProductDto dtos = new ProductDto();
		    dtos.setCategory(product.getCategory());
		    dtos.setDescription(product.getDescription());
		    dtos.setId(product.getId());
		    dtos.setName(product.getName());
		    dtos.setNumberOfReviews(product.getNumberofreviews());
		    dtos.setPrice(product.getPrice());
		    dtos.setRatings(product.getRatings());
		    dtos.setSeller(product.getSeller());
		    dtos.setStock(product.getStock());
		    
		//    dtos.setReviews(product.getReviews());
		    
		 List<ProductReviewDto> Reviews  = product.getReviews().stream().map(review->{
		    	  ProductReviewDto reviewdto = new  ProductReviewDto();
		    	  reviewdto.setProductId(review.getId());
		    	  reviewdto.setComment(review.getComment());
		    	  reviewdto.setRating(review.getRating());
		    	  return reviewdto;
		    }).collect(Collectors.toList());
         dtos.setReviews(Reviews);
      List<ProductImageDto>  imageDtos=  product.getImages().stream().map(images -> {
        	     ProductImageDto imagedto = new ProductImageDto();
        	     imagedto.setUrl(images.getPublicId());
        	     return imagedto;
           }).collect(Collectors.toList());
      
      dtos.setImages(imageDtos);
		    
		    return dtos;
	 }
	
	 

	public Product getProductById(Long id) {
		  return productrepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("There is no product with this " + id));
	}
	
	public List<Product> SearchProducts(String Category,Double minPrice , Double maxPrice,String KeyWord,Double ratings) {
		   
		Specification<Product> spec= Specification.where(ProductSpecification.hasCategory(Category))
				.and(ProductSpecification.pricefilter(minPrice,maxPrice))
				.and(ProductSpecification.keywordfilter(KeyWord))
				.and(ProductSpecification.ratingsfilter(ratings));
		return productrepository.findAll(spec);
	}


	public ResponseEntity<?> addReviews(ProductReviewDto reviews) {
		     
		  Product product =  productrepository.findById(reviews.getProductId()).orElseThrow(()->new RuntimeException("There is no product with this id"+reviews.getProductId()));
		  ProductReview productreview = new ProductReview();
		  productreview.setComment(reviews.getComment());
		  productreview.setRating(reviews.getRating());
		  productreview.setProduct(product);
		  productreviewrepo.save(productreview);
		  
		return ResponseEntity.status(HttpStatus.CREATED).body("Review is added");   
		  
		  
	}
}














