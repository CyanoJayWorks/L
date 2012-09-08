package com.agopinath.lthelogutil.streams;


public interface ILStream {
	void streamOpen();
	void streamClose();
	
	boolean isWritable();
	
	String streamWrite(String output);
}
