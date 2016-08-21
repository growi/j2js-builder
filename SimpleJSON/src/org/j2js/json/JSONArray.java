package org.j2js.json;

import java.util.Iterator;

public interface JSONArray extends JSONEntity, Iterable<JSONEntity>{
	
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public abstract Iterator<JSONEntity> iterator();
	
}
