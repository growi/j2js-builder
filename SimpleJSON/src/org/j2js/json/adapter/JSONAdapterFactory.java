package org.j2js.json.adapter;

import java.util.List;

public class JSONAdapterFactory {
	
	public static Object  getAdapter( List<?> list ){
				
		return new JSONListAdapter( (List<?>)list );
		
	}

}
