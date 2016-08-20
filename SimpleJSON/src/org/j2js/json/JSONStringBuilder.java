package org.j2js.json;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import org.j2js.json.values.JSONDateTimeValue;
import org.j2js.json.values.JSONNumberValue;

public class JSONStringBuilder
{
	private final String m_datePattern;
	private final Locale m_locale;

	public JSONStringBuilder()
	{
		this(null, null);
	}

	public JSONStringBuilder(final String datePattern)
	{
		this(datePattern, null);
	}

	public JSONStringBuilder(final Locale locale)
	{
		this(null, locale);
	}

	public JSONStringBuilder(final String datePattern, final Locale locale)
	{
		m_datePattern = datePattern;
		m_locale      = locale == null ? Locale.getDefault() : locale;
	}

	public String write(final JSONEntity input) throws IllegalArgumentException
	{
		if( input instanceof JSONArray )
		{
			return write( (JSONArray)input );
		}
		else if( input instanceof JSONObject )
		{
			return write( (JSONObject)input );
		}
		else if( input instanceof JSONValue )
		{
			return write( (JSONValue)input );
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	public String write(final JSONArray input)
	{
		StringBuilder builder = new StringBuilder();

		builder.append('[');

		for( Iterator<JSONEntity> it = input.iterator(); it.hasNext(); )
		{
			builder.append( write( it.next() ) );

			if( it.hasNext() )
			{
				builder.append(',');
			}
		}

		builder.append(']');

		return builder.toString();
	}

	public String write(final JSONObject input)
	{
		StringBuilder builder = new StringBuilder();

		builder.append('{');

		for( Iterator<String> it = input.properties(); it.hasNext(); )
		{
			builder.append( write( input.get( it.next() ) ) );

			if( it.hasNext() )
			{
				builder.append(',');
			}
		}

		builder.append('}');

		return builder.toString();
	}

	public String write(final JSONValue input)
	{
		if( input instanceof JSONNumberValue )
		{
			return ((JSONNumberValue)input).getValue();
		}
		else if( input instanceof JSONDateTimeValue )
		{
			SimpleDateFormat sdf = null;

			if( m_datePattern == null )
			{
				sdf = new SimpleDateFormat();
			}
			else if( m_locale == null )
			{
				sdf = new SimpleDateFormat(m_datePattern);
			}
			else
			{
				sdf = new SimpleDateFormat(m_datePattern, m_locale);
			}

			return ((JSONDateTimeValue) input).getValue(sdf);
		}
		else
		{
			return input.getValue();
		}
	}
}
