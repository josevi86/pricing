package com.zara.pricing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zara.pricing.model.Product;
import com.zara.pricing.repository.ProductRepository;
import com.zara.pricing.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product getProduct(long idProduct) {
		return productRepository.findById(idProduct).orElse(null);
	}

}
