package com.agopinath.lthelogutil.streams;

/**
 * Interface that contains framework for basic
 * logging functionality of different <code>LStream</code>s.
 * @author Ajay
 *
 */
public interface ILStream {
	void streamOpen();
	void streamClose();
	
	boolean streamIsWritable();
	
	String streamWrite(String output);
}
