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

package com.agopinath.lthelogutil;

import java.util.Iterator;

import com.agopinath.lthelogutil.streams.LConsoleStream;
import com.agopinath.lthelogutil.streams.LStream;

/**
 * Provides logging functionality designed with very brief method calls
 * to prevent unnecessary verbosity, and takes care of otherwise tedious
 * code to log in a variety of different ways.
 * 
 * @author Ajay
 *
 */
public final class L {
	private static final LStreamList STREAMS;
	
	// prevent instantiation
	private L() {}
	
	static {
		STREAMS = new LStreamList(5);
		STREAMS.addLStream(LConsoleStream.getInstance());
	}
	
	public static final void addLStream(LStream newStream) {
		STREAMS.addLStream(newStream);
	}
	
	public static final void remoteLStream(String lStreamID) {
		STREAMS.removeLStream(lStreamID);
	}
	
	/**
	 * Logs the given String to the registered <code>LStream</code>s
	 * @param toPrint - the String to be logged.
	 * @return The same String that was logged.
	 */
	public static final String og(final String toPrint) {
		Iterator<LStream> lStreamsIt = STREAMS.getLStreamIterator();
		
		for(;lStreamsIt.hasNext(); ) {
			LStream currStream = lStreamsIt.next();
			currStream.streamWrite(toPrint);
		}
		
		return toPrint;
	}
	
	/**
	 * Logs the given String to the registered <code>LStream</code>s
	 * Differs from the method <code>og</code> in that
	 * "ERROR: " is appended to the beginning of the text, and should
	 * be used to debug errors.
	 * @param toPrint - the String to be logged.
	 * @return The same String that was logged.
	 */
	public static final String err(final String toPrint) {
		Iterator<LStream> lStreamsIt = STREAMS.getLStreamIterator();
		
		for(;lStreamsIt.hasNext(); ) {
			LStream currStream = lStreamsIt.next();
			currStream.streamWrite("ERROR: " + toPrint);
		}
		
		return toPrint;
	}
	
	/**
	 * Logs the given String to the registered <code>LStream</code>s
	 * Differs from the method <code>og</code> in that
	 * "DEBUG: " is appended to the beginning of the text, and should
	 * be used for general command-debugging.
	 * @param toPrint - the String to be logged.
	 * @return The same String that was logged.
	 */
	public static final String dbg(final String toPrint) {
		Iterator<LStream> lStreamsIt = STREAMS.getLStreamIterator();
		
		for(;lStreamsIt.hasNext(); ) {
			LStream currStream = lStreamsIt.next();
			currStream.streamWrite("DEBUG: " + toPrint);
		}
		
		return toPrint;
	}
}
