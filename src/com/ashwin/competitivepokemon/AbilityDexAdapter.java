package com.ashwin.competitivepokemon;

import com.ashwin.competitivepokemon.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AbilityDexAdapter extends BaseAdapter{
	
	String[] numberOfPokemon;
	String[] abilityName;
	Context ctx;
	
	public AbilityDexAdapter(String[] n, String[] a, Context ctx)
	{
		numberOfPokemon = n;
		abilityName = a;
		this.ctx = ctx;
		
		
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return abilityName.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return abilityName[position];
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater li;
		RelativeLayout rl;
		TextView n;
		TextView a;
		
		rl = (RelativeLayout) convertView;
		
		if(rl == null)
		{
			li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.abilities_text_view, rl, true);
		}
		
		a = (TextView) rl.findViewById(R.id.ability_text_view);
		n = (TextView) rl.findViewById(R.id.number_of_pokemon);
		
		a.setText(abilityName[position]);
		n.setText(numberOfPokemon[position]);
		
		return rl;
	}
	

}
