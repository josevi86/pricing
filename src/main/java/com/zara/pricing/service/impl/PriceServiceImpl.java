package com.zara.pricing.service.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zara.pricing.dto.PriceDTO;
import com.zara.pricing.model.Brand;
import com.zara.pricing.model.Price;
import com.zara.pricing.model.Product;
import com.zara.pricing.repository.PriceRepository;
import com.zara.pricing.service.BrandService;
import com.zara.pricing.service.PriceService;
import com.zara.pricing.service.ProductService;

@Service
public class PriceServiceImpl implements PriceService {
	
	private final PriceRepository priceRepository;
	private final BrandService brandService;
	private final ProductService productService;
	
	@Autowired
	public PriceServiceImpl(PriceRepository priceRepository, BrandService brandService, ProductService productService) {
		this.priceRepository = priceRepository;
		this.brandService = brandService;
		this.productService = productService;
	}

	@Override
	public PriceDTO getActivePriceByProductAndBrandAndDate(int idProduct, int idBrand, Date date) {
		Brand brand = brandService.getBrand(idBrand);
		Product product = productService.getProduct(idProduct);
		List<Price> prices = priceRepository.findByProductAndBrandAndStartDateLessThanAndEndDateGreaterThan(product, brand, date, date);
		if(prices.isEmpty()) {
			return new PriceDTO();
		}else {
			Price price = prices.stream().max(Comparator.comparingInt(Price::getPriority)).orElse(null);
			PriceDTO priceDTO = new PriceDTO(price.getStartDate(),price.getEndDate(),price.getProduct().getId(),price.getBrand().getId(),price.getPrice());
			return priceDTO;	
		}
		
		
	}

}
