package com.zara.pricing.price;

import java.util.Date;

public interface PriceService {
	
	Price getActivePriceByProductAndDate(int product, int brand, Date date);
	
}
