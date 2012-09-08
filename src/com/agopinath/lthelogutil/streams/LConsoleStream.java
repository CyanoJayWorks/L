package com.agopinath.lthelogutil.streams;

/**
 * Implementation of <code>LStream</code> that
 * writes to the default system console.
 * @author Ajay
 *
 */
public class LConsoleStream extends LStream {
	
	private static final LConsoleStream INSTANCE = new LConsoleStream();
	
	// prevent instantiation
	private LConsoleStream() {}
	
	public static final LConsoleStream getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void streamOpen() {
		// do nothing
	}

	@Override
	public void streamClose() {
		// do nothing
	}

	@Override
	public boolean isWritable() {
		return System.out.checkError();
	}

	@Override
	public String streamWrite(String output) {
		System.out.println(output);
		
		return output;
	}
}
