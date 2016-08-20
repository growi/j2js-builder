package org.j2js.json.adapter;

import java.util.Date;
import java.util.List;

import org.j2js.json.JSONEntity;
import org.j2js.json.values.*;

public class JSONEntityFactory {
	
	private final static JSONNullValue NULL_VALUE = JSONNullValue.getInstance();
	
	public static JSONEntity getAdapter( String value ){
		return value == null ? NULL_VALUE : new JSONStringValue( value );
	}
	
	public static JSONEntity getAdapter( Number value ){
		return value == null ? NULL_VALUE : new JSONNumberValue( value );
	}
	
	public static JSONEntity getAdapter( Boolean value ){
		return value == null ? NULL_VALUE : new JSONBooleanValue( value );
	}
	
	public static JSONEntity getAdapter( Date value ){
		return value == null ? NULL_VALUE : new JSONDateTimeValue( value );
	}

	public static JSONEntity getAdapter( List<?> value ){
		return value == null ? NULL_VALUE : new JSONListAdapter( (List<?>) value );
	}
}
