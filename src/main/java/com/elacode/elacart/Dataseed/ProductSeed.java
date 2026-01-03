package com.elacode.elacart.Dataseed;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.elacode.elacart.Repository.ProductRepository;
import com.elacode.elacart.entity.Product;

@Component
public class ProductSeed implements CommandLineRunner {
	
	@Autowired
	ProductRepository productrepository;

	@Override
	public void run(String... args) throws Exception {
		
		if(productrepository.count()==0) {
			   
			List<Product> products = 
				    List.of(
				        new Product(null, "Samsung Galaxy A2", 18999.00, "Affordable Android smartphone", "Phone", 4.1, "Flipkart", 8, List.of("/products/1.jpg")),
				        new Product(null, "Redmi Note 12", 15999.50, "Powerful budget smartphone", "Phone", 4.3, "Amazon", 12, List.of("/products/2.jpg")),
				        new Product(null, "Realme Narzo 60", 17499.99, "Mid-range performance mobile", "Phone", 4.2, "Amazon", 7, List.of("/products/3.jpg")),
				        new Product(null, "OnePlus Nord CE", 24999.00, "Premium mid-range smartphone", "Phone", 4.5, "Flipkart", 6, List.of("/products/4.jpg")),
				        new Product(null, "Samsung Smart TV 43\"", 32999.00, "Full HD Smart LED TV", "TV", 4.4, "Amazon", 4, List.of("/products/5.jpg")),
				        new Product(null, "LG UHD TV 50\"", 45999.00, "4K Ultra HD Smart TV", "TV", 4.6, "Flipkart", 3, List.of("/products/6.jpg")),
				        new Product(null, "Boat Airdopes 141", 1299.00, "Wireless Bluetooth earbuds", "Earphone", 4.0, "Amazon", 20, List.of("/products/7.jpg")),
				        new Product(null, "Realme Buds Air 3", 3499.00, "Noise cancellation earbuds", "Earphone", 4.3, "Flipkart", 15, List.of("/products/8.jpg")),
				        new Product(null, "Sony WH-1000XM4", 22999.00, "Premium noise cancelling headphones", "Headphone", 4.8, "Amazon", 5, List.of("/products/9.jpg")),
				        new Product(null, "Samsung Double Door Fridge", 28999.00, "Energy efficient refrigerator", "Fridge", 4.2, "Amazon", 2, List.of("/products/10.jpg"))
				    );
				


			
			
			productrepository.saveAll(products);
			System.out.println("Demo Product Seeded");

		}
		else {
			System.out.println("Demo products Already there");
		}
		
		
	}
	
	

}
