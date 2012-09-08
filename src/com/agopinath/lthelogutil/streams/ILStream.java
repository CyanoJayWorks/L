package com.agopinath.lthelogutil.streams;

public interface ILStream {
	void streamOpen();
	void streamClose();
	
	boolean isStreamOpen();
	
	String streamWrite(String output);
}
