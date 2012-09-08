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

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.agopinath.lthelogutil.streams.LStream;

/**
 * Represents a set of <code>LStream</code>s
 * to be iterated over when logging.
 * @author Ajay
 *
 */
public class LStreamSet {
	private final Set<LStream> internalStreams;
	
	public LStreamSet(final int streamListSize) {
		internalStreams = Collections.synchronizedSet(new HashSet<LStream>(streamListSize));
	}
	
	public LStreamSet() {
		this(5);
	}
	
	/**
	 * Adds the specified <code>LStream</code> to the internal
	 * set of <code>LStream</code>s. Duplicate <code>LStream</code>s
	 * (determined by the IDs) are not allowed;
	 * @param newStream - the <code>LStream</code> to add.
	 * @return whether or not the operation succeeded.
	 */
	public boolean addLStream(final LStream newStream) {
		return internalStreams.add(newStream);
	}
	
	/**
	 * Removes the <code>LStream</code> with the specified
	 * ID.
	 * @param lStreamID - ID of the <code>LStream</code> to remove.
	 * @return whether or not the operation succeeded.
	 */
	public boolean removeLStream(final String lStreamID) {
		for(LStream currLStream : internalStreams) {
			if(currLStream.getLStreamID().equals(lStreamID)) {
				internalStreams.remove(currLStream);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns an <code>LStream</code> by the specified ID.
	 * @param lStreamID - ID of the <code>LStream</code> to retrieve.
	 */
	public LStream getLStreamByName(final String lStreamID) {
		for(LStream currLStream : internalStreams) {
			if(currLStream.getLStreamID().equals(lStreamID)) 
				return currLStream;
		}
		
		return null;
	}
	
	/**
	 * Returns an <code>Iterator</code> over the
	 * <code>LStream</code>s in the internal set of <code>LStream</code>s.
	 */
	public Iterator<LStream> getLStreamIterator() {
		synchronized(internalStreams) {
			return internalStreams.iterator();
		}
	}
}
