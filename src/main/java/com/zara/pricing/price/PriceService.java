package com.zara.pricing.price;

import java.util.Date;


public interface PriceService {
	
	PriceDTO getActivePriceByProductAndBrandAndDate(int product, int brand, Date date);
	
}
