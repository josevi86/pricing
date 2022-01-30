package com.zara.pricing.service;

import java.time.LocalDateTime;

import com.zara.pricing.dto.PriceDTO;

public interface PriceService {
	PriceDTO getActivePriceByProductAndBrandAndDate(int product, int brand, LocalDateTime date);
}
