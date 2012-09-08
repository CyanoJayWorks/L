package com.agopinath.lthelogutil.streams;


public abstract class LStream implements ILStream {
	public abstract void streamOpen() ;
	public abstract void streamClose();
	
	public abstract boolean isWritable();
	
	public abstract String streamWrite(String output);
}
