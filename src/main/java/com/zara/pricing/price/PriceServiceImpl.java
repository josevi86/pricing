package com.zara.pricing.price;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zara.pricing.brand.Brand;
import com.zara.pricing.brand.BrandService;
import com.zara.pricing.product.Product;
import com.zara.pricing.product.ProductService;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ProductService productService;

	@Override
	public PriceDTO getActivePriceByProductAndBrandAndDate(int idProduct, int idBrand, Date date) {
		Brand brand = brandService.getBrand(idBrand);
		Product product = productService.getProduct(idProduct);
		List<Price> prices = priceRepository.findByProductAndBrandAndStartDateLessThanAndEndDateGreaterThan(product, brand, date, date);
		Price price = prices.stream().max(Comparator.comparingInt(Price::getPriority)).orElse(null);
		PriceDTO priceDTO = new PriceDTO(price.getStartDate(),price.getEndDate(),price.getProduct().getId(),price.getBrand().getId(),price.getPrice());
		return priceDTO;
	}

}
