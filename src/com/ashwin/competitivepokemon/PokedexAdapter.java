package com.ashwin.competitivepokemon;


import java.util.List;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class PokedexAdapter extends BaseAdapter{
	
	Context ctx;
	String[] listPokemon;
	TypeBackgrounds tb;
	List<String> list;
	pokedexList thePokedexList;
	
	
	public PokedexAdapter(Context c,String[] lP)
	{
		ctx = c;
		tb = new TypeBackgrounds(ctx);
		listPokemon = lP;
		thePokedexList = new pokedexList(listPokemon);
	}

	@Override
	public int getCount() {
		return listPokemon.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listPokemon[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater li;
		RelativeLayout rl;
		TextView tv;
		TextView type1;
		TextView type2;
		
		
		
		list = (List<String>) thePokedexList.getTypes(position);
		
		if(list == null) Log.d("tag", "This is a null list for "+ listPokemon[position]);
		
		
		rl = (RelativeLayout) convertView;
		
		if (rl == null) {
            li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.pokedex_text_view, rl, true);
        }
		
		
		
		tv = (TextView) rl.findViewById(R.id.pokedex_text_view);
		type1 = (TextView) rl.findViewById(R.id.type1);
		type2 = (TextView) rl.findViewById(R.id.type2);
		
		
		type1.setBackgroundColor(tb.getBackgroundColor(list.get(0)));
        if (list.size() > 1) 
    	{
        	type2.setBackgroundColor(tb.getBackgroundColor(list.get(1)));
    	}
		
		tv.setText(listPokemon[position]);
		type1.setText(list.get(0));
		if (list.size() > 1) type2.setText(list.get(1));
		else
		{
			type2.setText(null);
			type2.setBackgroundColor(Color.BLACK);
		}
		
		type1.setTextColor(Color.WHITE);
		type2.setTextColor(Color.WHITE);
		
		return rl;
	}
	
}
