package com.zara.pricing.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProduct(long idProduct) {
		return productRepository.findById(idProduct).orElse(null);
	}

}
