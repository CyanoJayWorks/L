package com.agopinath.lthelogutil;

public class LErr {
	protected static final String internalErr(final String errorMessage) {
		System.out.println("INTERNAL L ERROR: " + errorMessage);
		
		return errorMessage;
	}
}
