package org.j2js.json;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import org.j2js.json.values.JSONDateTimeValue;
import org.j2js.json.values.JSONNumberValue;

public class JSONStringBuilder
{
	private StringBuilder m_builder = new StringBuilder();

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
		m_locale      = locale;
	}

	@Override
	public String toString()
	{
		return m_builder.length() == 0 ? "{}" : m_builder.toString();
	}

	/**
	 * Flushes the intern string buffer.
	 */
	public void flush()
	{
		m_builder = new StringBuilder();
	}

	/**
	 * Builds and writes stringified JSON to the intern string buffer. Call toString method to get the result.
	 * @param input
	 * @throws IllegalStateException If write before flush
	 * @throws IllegalArgumentException If the input is an unknown JSONEntity
	 */
	public void write(final JSONEntity input) throws IllegalStateException, IllegalArgumentException
	{
		if( m_builder.length() > 0 )
		{
			throw new IllegalStateException("JSONStringBuilder can not be reused until flushed");
		}

		if( input instanceof JSONArray )
		{
			write( (JSONArray)input );
		}
		else if( input instanceof JSONObject )
		{
			write( (JSONObject)input );
		}
		else if( input instanceof JSONValue )
		{
			write( (JSONValue)input );
		}
		else
		{
			throw new IllegalArgumentException(input + " is an unknown JSONEntity");
		}
	}

	private void write(final JSONArray input)
	{
		m_builder.append('[');

		for( Iterator<JSONEntity> it = input.iterator(); it.hasNext(); )
		{
			write( it.next() );

			if( it.hasNext() )
			{
				m_builder.append( ',' );
			}
		}

		m_builder.append( ']' );
	}

	private void write(final JSONObject input)
	{
		m_builder.append( '{' );

		for( Iterator<String> it = input.properties(); it.hasNext(); )
		{
			final String property = it.next();
			m_builder.append( '"' );
			m_builder.append( property );
			m_builder.append( '"' );
			m_builder.append( ':' );
			write( input.get( property ) );

			if( it.hasNext() )
			{
				m_builder.append( ',' );
			}
		}

		m_builder.append( '}' );
	}

	private void write(final JSONValue input)
	{
		if( input instanceof JSONNumberValue )
		{
			if( m_locale == null )
			{
				m_builder.append( ((JSONNumberValue) input).getValue() );
			}
			else
			{
				m_builder.append( ((JSONNumberValue) input).getValue( m_locale ) );
			}
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
				sdf = new SimpleDateFormat( m_datePattern );
			}
			else
			{
				sdf = new SimpleDateFormat( m_datePattern, m_locale );
			}

			m_builder.append(  ((JSONDateTimeValue) input).getValue( sdf ) );
		}
		else
		{
			m_builder.append( input.getValue() );
		}
	}
}
