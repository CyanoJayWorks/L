package com.agopinath.lthelogutil;

public final class L {
	// prevent instantiation
	private L() {}
	
	public static String std(String toPrint) {
		System.out.println(toPrint);
		return toPrint;
	}
	
	public static String err(String toPrint) {
		System.out.println("ERROR: " + toPrint);
		return toPrint;
	}
	
	public static String dbg(String toPrint) {
		System.out.println("DEBUG: " + toPrint);
		return toPrint;
	}
}
