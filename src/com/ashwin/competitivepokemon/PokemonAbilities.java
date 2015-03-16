package com.ashwin.competitivepokemon;

import java.util.ArrayList;
import java.util.Locale;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class PokemonAbilities extends Fragment {
	
	ListView grid;
	PokedexAdapter pokemon;
	Context ctx;
	String name;
	AbilitiesJSON ability;
	ArrayList<String> pokemonList;
	String[] a;
	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle bundle)
	{
		View rootView = inflater.inflate(R.layout.compatible_pokemon, container,false);
		
		pokemonList = new ArrayList<String>();
		
		grid = (ListView) rootView.findViewById(R.id.gridView1);
		
		ctx = getActivity().getApplicationContext();
        
        bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name");
        
        ability = new AbilitiesJSON(ctx,name);
        
        pokemonList = ability.getPokemon();
        
        a = new String[pokemonList.size()];
        
        for(int i = 0; i < a.length; i++)
        {
        	a[i] = pokemonList.get(i);
        }
        
        pokemon = new PokedexAdapter(ctx,a);
        
        grid.setAdapter(pokemon);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

    			@Override
    			public void onItemClick(AdapterView<?> parent, View view,
    					int position, long id) {
    				
    				
    				PokemonCheck thecheck = new PokemonCheck (pokemon.getItem(position).toString(),ctx);
    				String check = thecheck.getCheck();
    				
    				if(check.equals("0"))
    				{
    					Intent intent = new Intent(ctx, Tabs.class);
        				intent.putExtra("name", a[position].toLowerCase(Locale.ENGLISH));
                        startActivity(intent);
    				}
    				else
    				{
    					Intent intent = new Intent(ctx, CheckClass.class);
    	                startActivity(intent);
    				}
    			}
    			
    	});

		return rootView;
	}

}
