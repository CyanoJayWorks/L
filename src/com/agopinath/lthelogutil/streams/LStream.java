package com.agopinath.lthelogutil.streams;

/**
 * Abstract class implementation of <code>ILStream</code> that
 * contains basic logging function declarations.
 * @author Ajay
 *
 */
public abstract class LStream implements ILStream {
	public abstract void streamOpen() ;
	public abstract void streamClose();
	
	public abstract boolean isWritable();
	
	public abstract String streamWrite(String output);
}
