package com.zara.pricing;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zara.pricing.dto.PriceDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTestIT {

	@Autowired
	private MockMvc mockMvc;

	@ParameterizedTest
	@CsvSource({ "35455, 1, 2020-06-14 10:00, 35.50", "35455, 1, 2020-06-14 16:00, 25.45",
			"35455, 1, 2020-06-14 21:00, 35.50", "35455, 1, 2020-06-15 10:00, 30.50",
			"35455, 1, 2020-06-16 21:00, 38.95" })
	void givenTestPetition1_whenGetProductPrices_thenStatus200_and_correctpriceParametrized(String idProduct,
			String idBrand, String date, double expectedPrice) throws Exception {
		// Test 1
		int precision = 2;
		// double expectedPrice = 35.50;
		MvcResult result = this.mockMvc.perform(
				get("/price/active").param("idProduct", idProduct).param("idBrand", idBrand).param("date", date))
				.andDo(print()).andExpect(status().isOk()).andReturn();
		String resultJson = result.getResponse().getContentAsString();
		PriceDTO priceDto = new ObjectMapper().readValue(resultJson, PriceDTO.class);
		assertEquals(idProduct, String.valueOf(priceDto.getProductId()));
		assertEquals(idBrand, String.valueOf(priceDto.getBrandId()));
		assertEquals(expectedPrice, priceDto.getPrice(), precision);
	}

}
