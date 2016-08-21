package org.j2js.json.adapter;

import java.util.Iterator;
import java.util.List;

import org.j2js.json.JSONArray;
import org.j2js.json.JSONEntity;

public class JSONListAdapter implements JSONArray {
	
	List<?> m_list;
	
	/**
	 * @param list
	 */
	public JSONListAdapter( List<?> list ){
		m_list = list;
	}

	/* (non-Javadoc)
	 * @see org.j2js.json.JSONArray#iterator()
	 */
	@Override
	public Iterator<JSONEntity> iterator() {
		return new Iterator<JSONEntity>(){
			
			int m_index = -1; 

			@Override
			public boolean hasNext() {
				return m_index < m_list.size() -1;
			}

			@Override
			public JSONEntity next() {
				return JSONEntityFactory.getInstance().getAdapter(  m_list.get( ++m_index ) );
			}
		};
	}
}
