package com.zara.pricing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zara.pricing.dto.PriceDTO;
import com.zara.pricing.exception.NoPriceException;
import com.zara.pricing.model.Brand;
import com.zara.pricing.model.Price;
import com.zara.pricing.model.Product;
import com.zara.pricing.repository.PriceRepository;
import com.zara.pricing.service.BrandService;
import com.zara.pricing.service.ProductService;
import com.zara.pricing.service.impl.PriceServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceServiceImplTest {

	@MockBean
	private PriceRepository priceRepository;
	@MockBean
	private BrandService brandService;
	@MockBean
	private ProductService productService;

	private PriceServiceImpl priceService;

	@BeforeEach
	void init() {
		priceService = new PriceServiceImpl(priceRepository, brandService, productService);
	}

	@Test
	void whenValidDataEntry_thenReturnPrice() throws ParseException {
		long idProduct = 35455;
		long idBrand = 1;
		long idRateType = 1;
		float result = 23.3F;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-14 10:00",formatter);

		Product product = Mockito.mock(Product.class);
		when(product.getId()).thenReturn(idProduct);
		when(productService.getProduct(idProduct)).thenReturn(product);

		Brand brand = Mockito.mock(Brand.class);
		when(brand.getId()).thenReturn(idBrand);
		when(brandService.getBrand(idBrand)).thenReturn(brand);

		Price price = Mockito.mock(Price.class);
		when(price.getStartDate()).thenReturn(dateTime);
		when(price.getEndDate()).thenReturn(dateTime);
		when(price.getProduct()).thenReturn(product);
		when(price.getBrand()).thenReturn(brand);
		when(price.getId()).thenReturn(idRateType);
		when(price.getPriceProduct()).thenReturn(result);
		// price.get().getStartDate(),price.get().getEndDate(),price.get().getProduct().getId(),price.get().getBrand().getId(),price.get().getPriceProduct()
		List<Price> prices = new ArrayList<Price>();
		prices.add(price);
		when(priceRepository.findByProductAndBrandAndStartDateLessThanAndEndDateGreaterThan(product, brand, dateTime, dateTime))
				.thenReturn(prices);
		PriceDTO resultPriceDto = priceService.getActivePriceByProductAndBrandAndDate((int) idProduct, (int) idBrand,
				dateTime);

		assertNotNull(resultPriceDto);
		assertEquals(idProduct, resultPriceDto.getProductId());
		assertEquals(idBrand, resultPriceDto.getBrandId());
		assertEquals(result, resultPriceDto.getPrice(), 2);
		assertEquals(idRateType, resultPriceDto.getRateToApply());
		
	}

	@Test
	void whenPriceNotExists_thenNoPriceException() throws ParseException {
		long idProduct = 35455;
		long idBrand = 1;
		String messageException = "idProduct: "+idProduct;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-14 10:00",formatter);

		Product product = Mockito.mock(Product.class);
		when(productService.getProduct(idProduct)).thenReturn(product);

		Brand brand = Mockito.mock(Brand.class);
		when(brandService.getBrand(idBrand)).thenReturn(brand);

		List<Price> prices = new ArrayList<Price>();
		when(priceRepository.findByProductAndBrandAndStartDateLessThanAndEndDateGreaterThan(product, brand, dateTime, dateTime))
				.thenReturn(prices);

		NoPriceException thrown = assertThrows(NoPriceException.class, () -> {
			priceService.getActivePriceByProductAndBrandAndDate((int) idProduct, (int) idBrand, dateTime);
		});
		assertEquals(thrown.getMessage(), messageException);
		
	}

}
