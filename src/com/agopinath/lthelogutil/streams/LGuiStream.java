package com.agopinath.lthelogutil.streams;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LGuiStream extends LStream {
	private JFrame logFrame;
	private JTextArea logArea;
	private JPanel logPanel = new JPanel();
	
	public LGuiStream(int width, int height) {
		logFrame = new JFrame("Logging Window");
		logArea = new JTextArea();
		logArea.setEditable(false);
		
		logFrame.setSize(width, height);
		logFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		logFrame.setVisible(false);
	}
	
	@Override
	public void streamOpen() {
		JScrollPane logAreaScroller = new JScrollPane(logArea);
		logAreaScroller.setSize(logFrame.getSize());
		logAreaScroller.setPreferredSize(logFrame.getSize());
		
		logPanel.add(logAreaScroller);
		logFrame.getContentPane().add(logPanel);
		
		logFrame.setVisible(true);
	}

	@Override
	public void streamClose() {
		logFrame.dispose();
	}

	@Override
	public boolean streamIsWritable() {
		return logFrame.isValid();
	}

	@Override
	public String streamWrite(String output) {
		logArea.append(output + "\n");
		
		return output;
	}
}
