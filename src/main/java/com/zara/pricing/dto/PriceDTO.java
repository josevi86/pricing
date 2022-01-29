package com.zara.pricing.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class PriceDTO {

	private Date startDate;
	private Date endDate;
	private long productId;
	private long brandId;
	private float price;
	
}

