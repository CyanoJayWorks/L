package com.agopinath.lthelogutil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.agopinath.lthelogutil.streams.LStream;

public class LStreamList {
	private final List<LStream> internalStreams;
	
	public LStreamList(final int streamListSize) {
		internalStreams = Collections.synchronizedList(new ArrayList<LStream>(streamListSize));
	}
	
	public LStreamList() {
		this(5);
	}
	
	public void addLStream(final LStream newStream) {
		internalStreams.add(newStream);
	}
	
	public void removeLStream(final String lStreamID) {
		for(int i = 0; i < internalStreams.size(); i++) {
			LStream currLStream = internalStreams.get(i);
			
			if(currLStream.getLStreamID().equalsIgnoreCase(lStreamID)) 
				internalStreams.remove(i);
		}
	}
	
	public LStream getLStreamByName(final String lStreamID) {
		for(int i = 0; i < internalStreams.size(); i++) {
			LStream currLStream = internalStreams.get(i);
			
			if(currLStream.getLStreamID().equalsIgnoreCase(lStreamID)) 
				return currLStream;
		}
		
		return null;
	}
	
	public ListIterator<LStream> getLStreamIterator() {
		return internalStreams.listIterator();
	}
}
