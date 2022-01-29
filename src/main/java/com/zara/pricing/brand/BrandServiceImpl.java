package com.zara.pricing.brand;

import org.springframework.beans.factory.annotation.Autowired;

public class BrandServiceImpl implements BrandService {
	
	private final BrandRepository brandRepository;
	
	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public Brand getBrand(long idBrand) {
		return brandRepository.findById(idBrand).orElse(null);
	}

}
