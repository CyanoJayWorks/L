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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
* Implementation of <code>LStream</code> that
* can log to a given file.
* @author Ajay
*
*/
public class LFileStream extends LStream {
	private Writer fileWriter;
	private long writeCount;
	private long flushInterval;
	
	/**
	 * Creates a new <code>LFileStream</code> that writes to the given
	 * file using, appending dependent on parameter passed.
	 * Sets the default flushing interval to every write.
	 * @param logFile - file to write to
	 * @param append - whether or not to append to file
	 */
	public LFileStream(File logFile, boolean append) {
		try {
			
			if(!logFile.exists()) logFile.createNewFile();
			
			fileWriter = new BufferedWriter(new FileWriter(logFile, append));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		writeCount = 0;
		flushInterval = 1;
	}
	
	/**
	 * Creates a new <code>LFileStream</code> that writes to the given
	 * file using, appending dependent on parameter passed.
	 * Sets the default flushing interval to every write.
	 * @param fileName - filename representing file to write to
	 * @param append - whether or not to append to file
	 */
	public LFileStream(String fileName, boolean append) {
		this(new File(fileName), append);
	}
	
	/**
	 * Sets the flush interval (number of writes required to be called before
	 * flushing the stream) to the given parameter.
	 * @param newFlushInterval - the new interval to flush at.
	 */
	public void setFlushInterval(final long newFlushInterval) {
		flushInterval = newFlushInterval;
	}
	
	@Override
	public void streamOpen() {
		// do nothing
	}

	@Override
	public void streamClose() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean streamIsWritable() {
		try {
			fileWriter.write("");
		} catch(IOException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public String streamWrite(final String output) {
		try {
			fileWriter.write(output + "\r\n");
			writeCount++;
			
			if(writeCount % flushInterval == 0)
				fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return output;
	}
}
