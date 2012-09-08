package com.agopinath.lthelogutil.streams;

/**
 * Abstract class implementation of <code>ILStream</code> that
 * contains basic logging function declarations.
 * @author Ajay
 *
 */
public abstract class LStream implements ILStream {
	
	/**
	 * Template method for opening the stream.
	 */
	public abstract void streamOpen() ;
	
	/**
	 * Template method for closing the stream.
	 */
	public abstract void streamClose();
	
	/**
	 * Template method for checking if the stream can be logged/written to.
	 */
	public abstract boolean isWritable();
	
	/**
	 * Template method for writing to the stream.
	 */
	public abstract String streamWrite(String output);
}
