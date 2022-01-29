package com.zara.pricing.price;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {

	private final PriceService priceService;
	
	@Autowired
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}
	
	
	@GetMapping(value = "/active")
    public PriceDTO getPriceByProductAndDates(@RequestParam int idProduct, @RequestParam int idBrand, Date date) {
        return priceService.getActivePriceByProductAndBrandAndDate(idProduct, idBrand, date);
    }
	
}
