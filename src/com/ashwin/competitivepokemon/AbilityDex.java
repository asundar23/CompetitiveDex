package com.ashwin.competitivepokemon;

import com.ashwin.competitivepokemon.R;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class AbilityDex extends Fragment{
	
	String[] number;
	String[] ability;
	ListView abilitieslv;
	AbilityDexAdapter adapter;
	Context ctx;
	View rootView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup
			container, Bundle bundle)
	{
		rootView = inflater.inflate(R.layout.abilitydex, container,false);
		ctx = getActivity();

		number = getResources().getStringArray(R.array.pokemonperabilitiy);
		ability = getResources().getStringArray(R.array.abilties_list);
		
		abilitieslv = (ListView) rootView.findViewById(R.id.abilityListView);
		adapter = new AbilityDexAdapter(number,ability,ctx);
		abilitieslv.setAdapter(adapter);
		
		registerOnClickListener();
		
		return rootView;
	}
	
	public void registerOnClickListener()
	{
		abilitieslv.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(ctx, TabsAbilities.class);
				intent.putExtra("name", adapter.getItem(position).toString());
                startActivity(intent);
				
			}
			
		});
	}

}
