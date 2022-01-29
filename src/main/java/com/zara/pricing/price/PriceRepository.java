package com.zara.pricing.price;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zara.pricing.brand.Brand;
import com.zara.pricing.product.Product;

public interface PriceRepository extends CrudRepository<Price, Long>{
	
	List<Price> findByProductAndBrandAndStartDateLessAndStartDateGreater(Product product, Brand brand, LocalDateTime startDate, LocalDateTime endDate);

}
