package org.j2js.json.adapter;

import java.util.List;

import org.j2js.json.JSONEntity;

public class JSONAdapterFactory {
	
	public static JSONEntity  getAdapter( List<?> list ){
				
		return new JSONListAdapter( (List<?>)list );
		
	}

}
