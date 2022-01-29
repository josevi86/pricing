package com.zara.pricing.price;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.zara.pricing.currency.Currency;
import com.zara.pricing.product.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Price {
	
	private @Id Long id;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime startDate;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime endDate;
	
	@ManyToOne
	private Product product;
	
	@Column
	private long priority;
	
	@Column
	private float price;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Currency currency;
	
}
