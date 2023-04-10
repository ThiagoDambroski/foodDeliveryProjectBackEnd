package com.dambroski.foodDeliveryProject.error;

public class FoodNotFoundException extends RuntimeException{

	public FoodNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FoodNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FoodNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FoodNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
