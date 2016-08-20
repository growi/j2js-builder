package org.j2js.json;

import java.util.Iterator;

public interface JSONObject {

	public Iterator<String> properties();
	
	public Object get( String property );
		
}
