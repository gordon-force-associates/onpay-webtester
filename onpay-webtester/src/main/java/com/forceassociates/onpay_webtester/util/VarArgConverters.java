package com.forceassociates.onpay_webtester.util;

/**
 * Use this class for adapting variable argument support with existing methods that do not 
 * support them, e.g., slf4j logging methods. 
 * 
 * @author Gordon Force
 */
public class VarArgConverters {
	
	/**
	 * Use this method to convert a variable argument list into an array of Objects. 
	 * Inspired by an article on Roy's musings blog. 
	 * 
	 * @param params the arguments to express an array of Objects.
	 * @return params as an array of Objects.
	 * 
	 * @see <a href="http://royontechnology.blogspot.com/2010/07/logging-three-or-more-arguments-in.html">Logging Three or More Arguments</a>
	 */
	public static Object[] asArray(Object... params) {
		return params;
	}

}
