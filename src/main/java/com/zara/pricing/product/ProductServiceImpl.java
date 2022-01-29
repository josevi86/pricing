package com.zara.pricing.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
