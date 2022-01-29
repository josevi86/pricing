package com.zara.pricing.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zara.pricing.dto.PriceDTO;
import com.zara.pricing.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	private final PriceService priceService;
	
	@Autowired
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}
	
	
	@GetMapping(value = "/active")
    public PriceDTO getPriceByProductAndDates(@RequestParam int idProduct, @RequestParam int idBrand, @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date date) {
        return priceService.getActivePriceByProductAndBrandAndDate(idProduct, idBrand, date);
    }
	
}
