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
 * Abstract class implementation of <code>ILStream</code> that
 * contains basic logging function declarations.
 * @author Ajay
 *
 */
public abstract class LStream implements ILStream {
	protected String lStreamID;

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
	
	public void setLStreamID(String newLStreamID) {
		this.lStreamID = newLStreamID;
	}
	
	public String getLStreamID() {
		return this.lStreamID;
	}
}
