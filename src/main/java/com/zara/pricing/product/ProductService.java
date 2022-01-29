package com.zara.pricing.product;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

	Product getProduct(long idProduct);
}
