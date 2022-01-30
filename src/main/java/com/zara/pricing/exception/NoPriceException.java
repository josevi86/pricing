package com.zara.pricing.exception;

public class NoPriceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoPriceException(int idProduct) {
	        super("idProduct: "+idProduct);
	 }
}
