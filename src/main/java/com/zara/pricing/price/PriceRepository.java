package com.zara.pricing.price;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zara.pricing.brand.Brand;
import com.zara.pricing.product.Product;

public interface PriceRepository extends CrudRepository<Price, Long>{
	
	List<Price> findByProductAndBrandAndStartDateLessThanAndEndDateGreaterThan(Product product, Brand brand, Date startDate, Date endDate);

}
