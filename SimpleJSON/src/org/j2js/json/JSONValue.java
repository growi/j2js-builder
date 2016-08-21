package org.j2js.json;

public abstract class JSONValue implements JSONEntity {

	public static final char QUOTE_CHAR	= '\'';
	public static final String NULL_VALUE	= "null";
	
	public abstract String getValue();
	
	/**
	 * encloses a given string ion quotation marks
	 * 
	 * @param value	the string that should be enclosed in quotation marks 
	 * @return		the string enclosed in quotation marks
	 */
	protected String quote( String value ){
		return QUOTE_CHAR + value + QUOTE_CHAR;
	}
	
	/**
	 * retrieves a string representation for the null reference
	 * 
	 * @return 	a string representing the null reference
	 */
	protected static String getNull(){
		return NULL_VALUE;
	}
	
}
