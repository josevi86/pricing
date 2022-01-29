package com.zara.pricing.service;

import java.util.Date;

import com.zara.pricing.dto.PriceDTO;


public interface PriceService {
	
	PriceDTO getActivePriceByProductAndBrandAndDate(int product, int brand, Date date);
	
}
