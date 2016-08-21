package org.j2js.json;

import java.util.Iterator;

public interface JSONObject extends JSONEntity {

	/**
	 * Returns an iterator over all property names for the json object. 
	 * 
	 * @return	the iterator
	 */
	public Iterator<String> properties();

	/**
	 * Retrieves the value for the given property 
	 * 
	 * @param property	the name of the property which value should be retrieved
	 * @return			the value of the given property
	 */
	public JSONEntity get( String property );

}
