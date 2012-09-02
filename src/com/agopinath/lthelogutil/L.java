package com.agopinath.lthelogutil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public final class L {
	
	// prevent instantiation
	private L() {}
	
	public static final String og(final String toPrint) {
		System.out.println(toPrint);
		return toPrint;
	}
	
	public static final String err(final String toPrint) {
		System.out.println("ERROR: " + toPrint);
		return toPrint;
	}
	
	public static final String dbg(final String toPrint) {
		System.out.println("DEBUG: " + toPrint);
		return toPrint;
	}
	
	public static final String vis(final String toDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, toDisplay);
			}
		});
		
		return toDisplay;
	}
	
	public static final String out(final OutputStream out, final String toStream) {
		try {
			out.write(toStream.getBytes(Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return toStream;
	}
}
