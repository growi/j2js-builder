package org.j2js.json.values;

import java.text.NumberFormat;
import java.util.Locale;

import org.j2js.json.JSONValue;

public class JSONNumberValue extends JSONValue {

	Number m_number;
	
	public JSONNumberValue( Number number){
		m_number = number;
	}
	
	@Override
	public String getValue() {
		return m_number  == null ? JSONNumberValue.getNull() : NumberFormat.getNumberInstance().format( m_number );
	}

	public String getValue( Locale locale ) {
		return m_number  == null ? JSONNumberValue.getNull() : NumberFormat.getNumberInstance( locale ).format( m_number );
	}
}
