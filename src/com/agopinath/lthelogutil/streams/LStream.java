package com.agopinath.lthelogutil.streams;

/**
 * Abstract class implementation of <code>ILStream</code> that
 * contains basic logging function declarations.
 * @author Ajay
 *
 */
public abstract class LStream implements ILStream {
	
	/**
	 * Method for opening the stream. Some implementations
	 * don't require this.
	 */
	public abstract void streamOpen() ;
	
	/**
	 * Method for closing the stream. Some implementations
	 * don't require this.
	 */
	public abstract void streamClose();
	
	/**
	 * Method for checking if the stream can be logged/written to. Some implementations
	 * don't support this functionality.
	 */
	public abstract boolean streamIsWritable();
	
	/**
	 * Method for writing to the stream. All implementations <b>must</b> support this functionality.
	 */
	public abstract String streamWrite(final String output);
}
