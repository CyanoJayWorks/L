package com.agopinath.lthelogutil.streams;

/**
 * Interface that contains framework for basic
 * logging functions of different <code>LStream</code>s.
 * @author Ajay
 *
 */
public interface ILStream {
	void streamOpen();
	void streamClose();
	
	boolean isWritable();
	
	String streamWrite(String output);
}
