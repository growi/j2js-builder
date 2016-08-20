package org.j2js.json;

public abstract class JSONValue implements JSONEntity {

	public static final char QUOTE_CHAR	= '\'';
	public static final String NULL_VALUE	= "null";
	
	public abstract String getValue();
	
	protected String quote( String value ){
		return QUOTE_CHAR + value + QUOTE_CHAR;
	}
	
	protected static String getNull(){
		return NULL_VALUE;
	}
	
}
