package com.ashwin.competitivepokemon;

import java.util.HashMap;
import com.ashwin.competitivepokemon.R;
import android.content.Context;


public class TypeBackgrounds {
	
	String[] typeArray;
	int[] backgroundColors;
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	Context ctx;
	
	public TypeBackgrounds(Context c)
	{
		ctx = c;
		typeArray = ctx.getResources().getStringArray(R.array.moves_type_array);
		backgroundColors = ctx.getResources().getIntArray(R.array.typeArray);
		doHashStuff();
	}

	private void doHashStuff() {
		
		for(int i = 0; i < typeArray.length; i++)
		{
			map.put(typeArray[i],backgroundColors[i]);
		}
	}
	
	public int getBackgroundColor(String type)
	{
		for(int i = 0; i < typeArray.length; i++)
		{
			if(typeArray[i].equals(type)) return map.get(typeArray[i]);
			
		}
		
		return 0;
	}
}
