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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.agopinath.lthelogutil.streams.LStream;

/**
 * Represents a list of <code>LStream</code>s
 * to be iterated over when logging.
 * @author Ajay
 *
 */
public class LStreamList {
	private final List<LStream> internalStreams;
	
	public LStreamList(final int streamListSize) {
		internalStreams = Collections.synchronizedList(new ArrayList<LStream>(streamListSize));
	}
	
	public LStreamList() {
		this(5);
	}
	
	/**
	 * Adds the specified <code>LStream</code> to the internal
	 * list of <code>LStream</code>s.
	 * @param newStream - the <code>LStream</code> to add.
	 */
	public void addLStream(final LStream newStream) {
		internalStreams.add(newStream);
	}
	
	/**
	 * Removes the <code>LStream</code> with the specified
	 * ID.
	 * @param lStreamID - ID of the <code>LStream</code> to remove.
	 */
	public void removeLStream(final String lStreamID) {
		for(int i = 0; i < internalStreams.size(); i++) {
			LStream currLStream = internalStreams.get(i);
			
			if(currLStream.getLStreamID().equalsIgnoreCase(lStreamID)) 
				internalStreams.remove(i);
		}
	}
	
	/**
	 * Returns an <code>LStream</code> by the specified ID.
	 * @param lStreamID - ID of the <code>LStream</code> to retrieve.
	 */
	public LStream getLStreamByName(final String lStreamID) {
		for(int i = 0; i < internalStreams.size(); i++) {
			LStream currLStream = internalStreams.get(i);
			
			if(currLStream.getLStreamID().equalsIgnoreCase(lStreamID)) 
				return currLStream;
		}
		
		return null;
	}
	
	/**
	 * Returns an <code>ListIterator</code> over the
	 * <code>LStream</code>s in the internal list of <code>LStream</code>s.
	 */
	public ListIterator<LStream> getLStreamIterator() {
		synchronized(internalStreams) {
			return internalStreams.listIterator();
		}
	}
}
