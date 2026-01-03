package com.elacode.elacart.specification;

import org.springframework.data.jpa.domain.Specification;

import com.elacode.elacart.entity.Product;


public class ProductSpecification  {
           
	public static Specification<Product> hasCategory(String category){
		     
		return (root,query,cb)-> category==null? null:cb.equal(root.get("Category"), category);
	}

	public static Specification<Product> pricefilter(Double minPrice, Double maxPrice) {
		   
		return (root,query,cb)-> {
			  if(minPrice==null && maxPrice==null) return null;
			  if(minPrice==null) return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
			  if(maxPrice==null) return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
			  return cb.between(root.get("price"), minPrice, maxPrice);
		};
	}
	public static Specification<Product> keywordfilter(String keyword){
  	  return (root,query,cb)->{
  		    if(keyword==null || keyword.isEmpty()) return null;
  		     
  		      return cb.or(cb.like(root.get("name"),"%"+keyword.toLowerCase()+"%"),
  		    		cb.like(root.get("description"),"%"+keyword.toLowerCase()+"%"));
  	  };
  }

	public static Specification<Product> ratingsfilter(Double ratings) {
		    
		 return (root,query,cb)->{
			 if (ratings == null) return null;
			   return cb.greaterThanOrEqualTo(root.get("ratings"), ratings);
		 };
	}
}
    
