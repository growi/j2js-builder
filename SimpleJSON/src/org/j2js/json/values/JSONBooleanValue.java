package org.j2js.json.values;

import org.j2js.json.JSONValue;

public class JSONBooleanValue extends JSONValue {

	Boolean m_boolean;
	
	public JSONBooleanValue( Boolean b ){
		m_boolean = b;
	}
		
	@Override
	public String getValue() {
		return m_boolean  == null ? this.getNull() : m_boolean.toString();
	}

}
