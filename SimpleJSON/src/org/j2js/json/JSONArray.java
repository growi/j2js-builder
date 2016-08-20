package org.j2js.json;

import java.util.Iterator;

public interface JSONArray extends JSONEntity, Iterable{
	
	public abstract Iterator iterator();
	
}
