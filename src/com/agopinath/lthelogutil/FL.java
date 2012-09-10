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
public final class Fl {
	
	// prevent instantiation
	private Fl() {}
	
	/**
	 * Logs the given String on-the-fly to
	 * the "standard" console system output.
	 * @param toPrint - the String to be logged.
	 * @return The same String that was logged.
	 */
	public static final String og(final String toPrint) {
		System.out.println(toPrint);
		
		return toPrint;
	}
	
	/**
	 * Logs the given String on-the-fly to
	 * the "standard" console system output.
	 * Differs from the method <code>og</code> in that
	 * "ERROR: " is appended to the beginning of the text, and should
	 * be used to debug errors.
	 * @param toPrint - the String to be logged.
	 * @return The same String that was logged.
	 */
	public static final String err(final String toPrint) {
		System.out.println("ERROR: " + toPrint);
		
		return toPrint;
	}
	
	/**
	 * Logs the given String on-the-fly to
	 * the "standard" console system output.
	 * Differs from the method <code>og</code> in that
	 * "DEBUG: " is appended to the beginning of the text, and should
	 * be used for general command-debugging.
	 * @param toPrint - the String to be logged.
	 * @return The same String that was logged.
	 */
	public static final String dbg(final String toPrint) {
		System.out.println("DEBUG: " + toPrint);
		
		return toPrint;
	}

	/**
	 * Displays a String graphically on-the-fly using <code>JOptionPane.showMessageDialog</code>
	 * as a graphic alternative to other logging functionalities
	 * @param toDisplay - the String to be displayed.
	 * @return The same String that was displayed.
	 */
	public static final String vis(final String toDisplay) {
		if(GraphicsEnvironment.isHeadless()) {
			Li.internalErr("calling vis(java.lang.String) on headless system");
			return null;
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, toDisplay);
			}
		});
		
		return toDisplay;
	}
	
	/**
	 * Prints out a String on-the-fly to the specified <code>OutputStream</code>,
	 * using <code>UTF-8</code> as the default encoding.
	 * @param out - the <code>OutputStream</code> to write the String to.
	 * @param toStream - the String to be written to the stream.
	 * @return The same String that was written to stream.
	 */
	public static final String out(final OutputStream out, final String toStream) {
		try {
			out.write(toStream.getBytes(Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return toStream;
	}
	
	/**
	 * Prints out a String on-the-fly to the specified <code>OutputStream</cod e>,
	 * using the specified encoding.
	 * @param out - the <code>OutputStream</code> to write the String to.
	 * @param toStream - the String to be written to the stream.
	 * @param encoding - the String representing the encoding to be used.
	 * @return The same String that was written to stream.
	 */
	public static final String out(final OutputStream out, final String toStream, final String encoding) {
		try {
			out.write(toStream.getBytes(encoding));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return toStream;
	}
}
