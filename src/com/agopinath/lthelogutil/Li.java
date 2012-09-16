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

/**
 * Contains logging methods to be used
 * internally only. Instantiation
 * of this class is prevented because it is inconsistent
 * with the program design. The class name "Li" stands for
 * "<b>L</b>og for <b>I</b>nternal Use".
 * @author Ajay
 *
 */

@Deprecated
public final class Li {
	
	// prevent instantiation
	private Li() {}
	
	@Deprecated
	public static final String internalErr(final String errorMessage) {
		System.out.println("INTERNAL L ERROR: " + errorMessage);
		
		return errorMessage;
	}
}
