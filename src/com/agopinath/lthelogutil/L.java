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

import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Convenience class for on-the-fly logging to
 * "standard" console output and for other convenient
 * logging functinality. Instantiation
 * of this class is prevented because it is inconsistent
 * with the program design. The class name "FL" stands for
 * "<b>F</b>ast <b>L</b>og".
 * @author Ajay
 *
 */
public final class L {
	
	// prevent instantiation
	private L() {}
	
	/**
	 * Logs the given String on-the-fly to
	 * the "standard" console system output.
	 * @param toPrint - the String to be logged.
	 */
	public static final void og(final String toPrint) {
		System.out.println(toPrint);
	}
	
	/**
	 * Logs the given String on-the-fly to
	 * the "standard" console system output.
	 * Differs from the method <code>og</code> in that
	 * "ERROR: " is appended to the beginning of the text, and should
	 * be used to debug errors.
	 * @param toPrint - the String to be logged.
	 */
	public static final void err(final String toPrint) {
		og("ERROR: " + toPrint);
	}
	
	/**
	 * Logs the given String on-the-fly to
	 * the "standard" console system output.
	 * Differs from the method <code>og</code> in that
	 * "DEBUG: " is appended to the beginning of the text, and should
	 * be used for general command-debugging.
	 * @param toPrint - the String to be logged.
	 */
	public static final void dbg(final String toPrint) {
		og("DEBUG: " + toPrint);
	}

	/**
	 * Displays a String graphically on-the-fly using <code>JOptionPane.showMessageDialog</code>
	 * as a graphic alternative to other logging functionalities
	 * @param toDisplay - the String to be displayed.
	 */
	public static final void vis(final String toDisplay) {
		if(GraphicsEnvironment.isHeadless()) {
			L.err("INTERNAL L ERROR: creating new LGuiStream on headless system ");
			return;
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, toDisplay);
			}
		});
	}
	
	/**
	 * Prints out a String on-the-fly to the specified <code>OutputStream</code>,
	 * using <code>UTF-8</code> as the default encoding.
	 * @param out - the <code>OutputStream</code> to write the String to.
	 * @param toStream - the String to be written to the stream.
	 */
	public static final void out(final OutputStream out, final String toStream) {
		try {
			out.write(toStream.getBytes(Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints out a String on-the-fly to the specified <code>OutputStream</cod e>,
	 * using the specified encoding.
	 * @param out - the <code>OutputStream</code> to write the String to.
	 * @param toStream - the String to be written to the stream.
	 * @param encoding - the String representing the encoding to be used.
	 */
	public static final void out(final OutputStream out, final String toStream, final String encoding) {
		try {
			out.write(toStream.getBytes(encoding));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final void og(final boolean toPrint) {
		og(""+toPrint);
	}
	
	public static final void og(final char toPrint) {
		og(""+toPrint);
	}
	
	public static final void og(final int toPrint) {
		og(""+toPrint);
	}
	
	public static final void og(final float toPrint) {
		og(""+toPrint);
	}
	
	public static final void og(final double toPrint) {
		og(""+toPrint);
	}
	
	public static final void og(final Object toPrint) {
		og(toPrint.toString());
	}
}