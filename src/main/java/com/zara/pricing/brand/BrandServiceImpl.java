package com.zara.pricing.brand;

import org.springframework.beans.factory.annotation.Autowired;

public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand getBrand(long idBrand) {
		return brandRepository.findById(idBrand).orElse(null);
	}

}
