package com.ashwin.competitivepokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapStringList
{
	private HashMap<String, List<String>> map;
	public MapStringList()
	{
		map = new HashMap<String, List<String>>();
	}

	public void add(String key, String value)
	{
		if(map.containsKey(key))
		{
			List<String> values = (List<String>)map.get(key);
			values.add(value);
		}
		else
		{
			List<String> values = new ArrayList<String>();
			values.add(value);
			map.put(key,values);
		}
	}
	
	public List<?> getValues(String key)
	{
		return (List<?>)map.get(key);
	}
}
