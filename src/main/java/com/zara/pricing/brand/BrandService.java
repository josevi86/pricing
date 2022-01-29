package com.zara.pricing.brand;

import org.springframework.stereotype.Service;

@Service
public interface BrandService {

	Brand getBrand(long idBrand);
}
