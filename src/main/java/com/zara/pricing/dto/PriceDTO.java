package com.zara.pricing.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class PriceDTO {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private long productId;
	private long brandId;
	private float price;
	private long rateToApply;
	
}

