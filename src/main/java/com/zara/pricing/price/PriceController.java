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

	@Autowired
	private PriceService priceService;
	
	@GetMapping(value = "/activePrice")
    public PriceDTO getPriceByProductAndDates(@RequestParam int idProduct, @RequestParam int idBrand, Date date) {
        return priceService.getActivePriceByProductAndBrandAndDate(idProduct, idBrand, date);
    }
	
}
