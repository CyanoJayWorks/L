package com.agopinath.lthelogutil.streams;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LGuiStream extends LStream {
	private JFrame loggingFrame;
	private JTextArea loggingArea;
	private JPanel loggingPanel = new JPanel();
	
	public LGuiStream(int width, int height) {
		loggingFrame = new JFrame("Logging Window");
		loggingArea = new JTextArea(30, 30);
		
		loggingFrame.setSize(width, height);
		loggingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		loggingFrame.setVisible(true);
	}
	
	@Override
	public void streamOpen() {
		loggingPanel.add(loggingArea);
		loggingFrame.getContentPane().add(loggingPanel);
		
		loggingFrame.setVisible(true);
	}

	@Override
	public void streamClose() {
		loggingFrame.dispose();
	}

	@Override
	public boolean streamIsWritable() {
		return loggingFrame.isValid();
	}

	@Override
	public String streamWrite(String output) {
		loggingArea.append(output + "\n");
		return null;
	}
}
