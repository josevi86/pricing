package com.zara.pricing.exception;

import java.util.Date;

public class NoPriceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoPriceException(int idProduct, int idBrand, Date date) {
	        super("No data for Product: "+idProduct+"  Brand: "+idBrand+ "  Date: "+date.toString());
	 }
}
