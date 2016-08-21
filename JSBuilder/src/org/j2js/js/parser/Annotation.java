package org.j2js.js.parser;

public class Annotation
{
	private String m_annotationName;
	private Class<?> m_class;

	public Annotation(final String annotationName, final String className) throws ClassNotFoundException
	{
		if( annotationName == null || annotationName.isEmpty() || className == null || className.isEmpty() )
		{
			throw new IllegalArgumentException();
		}

		m_annotationName = annotationName;
		m_class = Class.forName(className);
	}

	public String getAnnotationName()
	{
		return m_annotationName;
	}

	public Class<?> getAnnotationClass()
	{
		return m_class;
	}
}
