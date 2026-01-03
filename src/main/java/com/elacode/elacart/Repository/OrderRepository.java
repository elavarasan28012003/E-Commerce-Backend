package com.elacode.elacart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elacode.elacart.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	 Optional<Order> findByReferenceId(String reference_id);
}
