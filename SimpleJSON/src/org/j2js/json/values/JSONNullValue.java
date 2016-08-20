package org.j2js.json.values;

import org.j2js.json.JSONValue;

public class JSONNullValue extends JSONValue {
	
	private static JSONNullValue m_instance;
	
	private JSONNullValue(){
		m_instance = this;
	}
	
	public static JSONNullValue getInstance(){
		return m_instance == null ? new JSONNullValue() : m_instance;
	}
	
	@Override
	public String getValue() {
		return JSONValue.getNull(); 
	}
}
