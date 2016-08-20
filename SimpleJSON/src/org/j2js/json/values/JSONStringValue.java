package org.j2js.json.values;

import org.j2js.json.JSONValue;

public class JSONStringValue implements JSONValue {

	String m_value;
	
	JSONStringValue( String s ){
		m_value = s;
	}
	
	@Override
	public String getValue() {
		return "'" + m_value + "'";
	}

}
