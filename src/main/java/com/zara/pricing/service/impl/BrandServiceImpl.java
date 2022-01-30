package com.zara.pricing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zara.pricing.model.Brand;
import com.zara.pricing.repository.BrandRepository;
import com.zara.pricing.service.BrandService;

@Service
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
