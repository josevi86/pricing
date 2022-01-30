package com.zara.pricing.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zara.pricing.model.Brand;
import com.zara.pricing.model.Price;
import com.zara.pricing.model.Product;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long>{
	
	List<Price> findByProductAndBrandAndStartDateLessThanAndEndDateGreaterThan(Product product, Brand brand, LocalDateTime startDate, LocalDateTime endDate);

}
