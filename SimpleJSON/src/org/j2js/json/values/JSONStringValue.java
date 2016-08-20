package org.j2js.json.values;

import org.j2js.json.JSONValue;

public class JSONStringValue extends JSONValue {

	String m_value;
	
	public JSONStringValue( String s ){
		m_value = s;
	}
	
	@Override
	public String getValue() {
		return m_value == null ? JSONStringValue.getNull() : this.quote( m_value );
	}
}
