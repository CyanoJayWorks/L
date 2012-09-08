package com.agopinath.lthelogutil.streams;

public abstract class LStream implements ILStream {
	protected abstract void openStream();
	protected abstract void closeStream();
	
	public abstract boolean isStreamOpen();
	
	public abstract String streamWrite(String output);
}
