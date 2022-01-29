package com.zara.pricing.price;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface PriceService {
	
	PriceDTO getActivePriceByProductAndBrandAndDate(int product, int brand, Date date);
	
}
