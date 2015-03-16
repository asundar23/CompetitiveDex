package com.ashwin.competitivepokemon;

import java.util.List;

public final class MovedexList {
	
	String[] movedex;
	String[] moveTypeDex;
	String[] powerDex;
	String[] accuracyDex;
	String x = null;
	MapStringList map = new MapStringList();
	boolean flag;
	int i;
	
	public MovedexList(String[] p,String[] s,String[] x,String[] a)
	{
		accuracyDex = a;
		movedex = p;
		moveTypeDex = s;
		powerDex = x;
		mapList();
	}

	public List<?> getTypes(int pos)
	{
		return map.getValues(movedex[pos]);
	}
	
	public void mapList()
	{
		for(int i = 0; i < movedex.length; i++)
		{
			map.add(movedex[i], moveTypeDex[i]);
			map.add(movedex[i], powerDex[i]);
			map.add(movedex[i], accuracyDex[i]);
		}
		
	}

}
