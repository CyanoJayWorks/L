package com.agopinath.lthelogutil.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* Implementation of <code>LStream</code> that
* can log to a given file.
* @author Ajay
*
*/
public class LFileStream extends LStream {
	private FileWriter fileWriter;
	
	public LFileStream(File logFile, boolean append) {
		try {
			
			if(!logFile.exists()) logFile.createNewFile();
			
			fileWriter = new FileWriter(logFile, append);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LFileStream(String fileName, boolean append) {
		this(new File(fileName), append);
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
	public boolean isWritable() {
		try {
			fileWriter.write("");
		} catch(IOException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public String streamWrite(String output) {
		try {
			fileWriter.write("");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return output;
	}

}
