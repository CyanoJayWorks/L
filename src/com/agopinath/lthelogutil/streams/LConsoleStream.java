/**  
 * L - the light-weight Java logging utility designed for brevity and simplicity.
 * Copyright (C) 2012 Ajay Gopinath
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/

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
	
	private static final LConsoleStream INSTANCE;
	
	static {
		 INSTANCE = new LConsoleStream();
		 INSTANCE.setLStreamID("stdOutput");
	}
	
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
