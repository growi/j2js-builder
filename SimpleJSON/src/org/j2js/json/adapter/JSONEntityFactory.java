package org.j2js.json.adapter;

import java.util.Date;
import java.util.List;

import org.j2js.json.JSONEntity;
import org.j2js.json.values.*;

public class JSONEntityFactory {
	
	protected static JSONEntityFactory m_instance;
	protected final static JSONNullValue NULL_VALUE = JSONNullValue.getInstance();
	
	protected JSONEntityFactory(){
	}
	
	public static JSONEntityFactory getInstance(){
		if( m_instance == null ){
			m_instance = new JSONEntityFactory();	
		}
		return m_instance;
	}
	
	public JSONEntity getAdapter( Object o ){
		if( o == null ) return NULL_VALUE;
		if( o instanceof String ) return getAdapter( (String)o );
		if( o instanceof Number ) return getAdapter( (Number)o );
		if( o instanceof Boolean )return getAdapter( (Boolean)o );
		if( o instanceof Date ) return getAdapter( (Date)o );
		if( o instanceof List<?> )return getAdapter( (List<?>)o );
		return null;
	}
	
	public JSONEntity getAdapter( String value ){
		return value == null ? NULL_VALUE : new JSONStringValue( value );
	}
	
	public JSONEntity getAdapter( Number value ){
		return value == null ? NULL_VALUE : new JSONNumberValue( value );
	}
	
	public JSONEntity getAdapter( Boolean value ){
		return value == null ? NULL_VALUE : new JSONBooleanValue( value );
	}
	
	public JSONEntity getAdapter( Date value ){
		return value == null ? NULL_VALUE : new JSONDateTimeValue( value );
	}

	public JSONEntity getAdapter( List<?> value ){
		return value == null ? NULL_VALUE : new JSONListAdapter( (List<?>) value );
	}
}
