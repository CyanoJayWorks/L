package com.agopinath.lthelogutil.streams;

/**
 * Implementation of <code>LStream</code> that
 * writes to the default system console. Instantiation
 * of this class is prevented as only one console output
 * exists.
 * @author Ajay
 *
 */
public class LConsoleStream extends LStream {
	
	private static final LConsoleStream INSTANCE = new LConsoleStream();
	
	// prevent instantiation
	private LConsoleStream() {}
	
	/**
	 * Returns an instance of <code>LConsoleStream</code>.
	 * @return
	 */
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
	public boolean streamIsWritable() {
		return System.out.checkError();
	}

	@Override
	public String streamWrite(final String output) {
		System.out.println(output);
		
		return output;
	}
}
