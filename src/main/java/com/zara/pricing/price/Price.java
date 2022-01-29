package com.zara.pricing.price;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.zara.pricing.brand.Brand;
import com.zara.pricing.currency.Currency;
import com.zara.pricing.product.Product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class Price {
	
	private @Id Long id;
	
	@Column(columnDefinition = "TIMESTAMP")
	private Date startDate;
	
	@Column(columnDefinition = "TIMESTAMP")
	private Date endDate;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Brand brand;
	
	@Column
	private int priority;
	
	@Column
	private float price;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Currency currency;
	
}
