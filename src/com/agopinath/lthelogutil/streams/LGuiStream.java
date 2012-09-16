package com.agopinath.lthelogutil.streams;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.agopinath.lthelogutil.Fl;

public class LGuiStream extends LStream {
	private JFrame logFrame;
	private JTextArea logArea;
	private JPanel logPanel = new JPanel();
	
	private final int width, height;
	
	public LGuiStream(int width, int height) {
		if(GraphicsEnvironment.isHeadless()) {
			Fl.og("INTERNAL L ERROR: creating new LGuiStream on headless system ");
		}
		
		this.width = width;
		this.height = height;
	}
	
	public LGuiStream() {
		this(550, 400);
	}
	
	@Override
	public void streamOpen() {
		if(isStreamOpen) {
			Fl.og("INTERNAL L ERROR: trying to re-open alreadyopen stream ");
			return;
		}
		
		logFrame = new JFrame("Logging Window");
		logArea = new JTextArea();
		logArea.setEditable(false);
		
		logFrame.setSize(width, height);
		logFrame.setResizable(false);
		logFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JScrollPane logAreaScroller = new JScrollPane(logArea);
		logAreaScroller.setSize(logFrame.getSize());
		logAreaScroller.setPreferredSize(new Dimension((logFrame.getWidth()*3)/4, 
													   (logFrame.getHeight()*3)/4));
		
		logPanel.add(logAreaScroller);
		logFrame.getContentPane().add(logPanel);
		
		logFrame.setVisible(true);
		
		isStreamOpen = true;
	}

	@Override
	public void streamClose() {
		logFrame.dispose();
		isStreamOpen = false;
	}

	@Override
	public boolean streamIsWritable() {
		return logFrame.isValid();
	}

	@Override
	public String streamWrite(String output) {
		logArea.append("  " + output + "\n");
		
		return output;
	}
}
