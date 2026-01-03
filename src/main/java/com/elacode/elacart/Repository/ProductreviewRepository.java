package com.elacode.elacart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elacode.elacart.entity.ProductReview;

@Repository
public interface ProductreviewRepository extends JpaRepository<ProductReview, Long>{

}
