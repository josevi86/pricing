package com.zara.pricing.price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
	
	Price getActivePriceByProductAndDate(int product, int brand, LocalDateTime dateTime);
	
}
