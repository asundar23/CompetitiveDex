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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class PokemonMoves extends Fragment{
	
	ListView grid;
	PokedexAdapter pokemon;
	Context ctx;
	String name;
	MovesJSON move;
	ArrayList<String> pokemonList;
	Spinner spinner;
	ArrayList<String> empty;
	TextView note;
	String[] x;
	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle bundle)
	{
		View rootView = inflater.inflate(R.layout.moves_pokemon, container,false);
		
		empty = new ArrayList<String>();
		
		pokemonList = new ArrayList<String>();
		
		grid = (ListView) rootView.findViewById(R.id.listView);
		note = (TextView) rootView.findViewById(R.id.note);
		
		
		
		ctx = getActivity().getApplicationContext();
        
        bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name");
        
        
        move = new MovesJSON(ctx,name);
        spinner = (Spinner) rootView.findViewById(R.id.moves_pokemon);
        populateSpinner();
        registerOnClickListener();

		return rootView;
	}
	
	public void populateSpinner()
	{
		ArrayList<String> something = new ArrayList<String>();

			if(!move.getPokemonHM().isEmpty() &&
					!move.getPokemonLevel().isEmpty() &&
					move.getPokemonTM().isEmpty() &&
					move.getPokemonBreeding().isEmpty() &&
					move.getPokemonTutor().isEmpty())
			{
				something.add("Level");
				something.add("HM");
			}
			else if(!move.getPokemonHM().isEmpty() &&
					move.getPokemonLevel().isEmpty() &&
					move.getPokemonTM().isEmpty() &&
					move.getPokemonBreeding().isEmpty() &&
					move.getPokemonTutor().isEmpty())
			{
				something.add("HM");
			}
			else if(move.getPokemonLevel().isEmpty() &&
					!move.getPokemonBreeding().isEmpty() &&
					move.getPokemonHM().isEmpty() &&
					!move.getPokemonTM().isEmpty() &&
					!move.getPokemonTutor().isEmpty() )
			{
				something.add("Breeding");
				something.add("TM");
				something.add("Tutor");
			}
			else if(!move.getPokemonLevel().isEmpty() &&
					!move.getPokemonBreeding().isEmpty() &&
					move.getPokemonHM().isEmpty() &&
					move.getPokemonTM().isEmpty() &&
					!move.getPokemonTutor().isEmpty() )
			{
				something.add("Level");
				something.add("Breeding");
				something.add("Tutor");
			}
			else if(move.getPokemonTutor().isEmpty() &&
					!move.getPokemonBreeding().isEmpty() &&
					move.getPokemonHM().isEmpty() &&
					!move.getPokemonTM().isEmpty() &&
					!move.getPokemonLevel().isEmpty() )
			{
				something.add("Level");
				something.add("Breeding");
				something.add("TM");
			}
			else if(move.getPokemonTM().isEmpty() 
					&& (move.getPokemonTutor().isEmpty())
					&& !move.getPokemonBreeding().isEmpty() &&
					move.getPokemonHM().isEmpty()
					&& !move.getPokemonLevel().isEmpty())
			{
				something.add("Level");
				something.add("Breeding");
			}
			else if(move.getPokemonTM().isEmpty() 
					&& !(move.getPokemonTutor().isEmpty())
					&& move.getPokemonBreeding().isEmpty() &&
					move.getPokemonHM().isEmpty()
					&& !move.getPokemonLevel().isEmpty())
			{
				something.add("Level");
				something.add("Tutor");
			}
			else if(move.getPokemonTM().isEmpty() && 
					(move.getPokemonTutor().isEmpty()) && 
					move.getPokemonHM().isEmpty() &&
					(move.getPokemonBreeding().isEmpty())
					&& !move.getPokemonLevel().isEmpty())
			{
				something.add("Level");
				if(name.equals("Attract") || 
						name.equals("Frustration"))
				{
					something.add("TM");
				}
			}
			else if(!move.getPokemonTM().isEmpty() && 
					(move.getPokemonTutor().isEmpty()) && 
					move.getPokemonHM().isEmpty() &&
					(move.getPokemonBreeding().isEmpty())
					&& !move.getPokemonLevel().isEmpty())
			{
				something.add("Level");
				something.add("TM");
			}
			else if(!move.getPokemonTM().isEmpty() && 
					(move.getPokemonTutor().isEmpty()) && 
					move.getPokemonHM().isEmpty() &&
					(move.getPokemonBreeding().isEmpty())
					&& move.getPokemonLevel().isEmpty())
			{
				something.add("TM");
			}
			else if(!move.getPokemonTutor().isEmpty() && 
					(move.getPokemonTM().isEmpty()) && 
					move.getPokemonHM().isEmpty() &&
					(move.getPokemonBreeding().isEmpty())
					&& move.getPokemonLevel().isEmpty())
			{
				something.add("Tutor");
			}
			
			ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(ctx, 
					android.R.layout.simple_spinner_item,something);
			spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			spinner.setAdapter(spinnerAdapter);
			spinnerAdapter.notifyDataSetChanged();
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(String.valueOf(spinner.getSelectedItem()).equals("Level")) pokemonList = move.getPokemonLevel();
				if(String.valueOf(spinner.getSelectedItem()).equals("Breeding")) pokemonList = move.getPokemonBreeding();
				if(String.valueOf(spinner.getSelectedItem()).equals("TM")) pokemonList = move.getPokemonTM();
				if(String.valueOf(spinner.getSelectedItem()).equals("Tutor")) pokemonList = move.getPokemonTutor();
				if(String.valueOf(spinner.getSelectedItem()).equals("HM")) pokemonList = move.getPokemonHM();
				
				if(name.equals("Attract") || name.equals("Frustration"))
				{
					if(String.valueOf(spinner.getSelectedItem()).equals("TM"))
					{
						grid.setAlpha((float) .20);
						note.setVisibility(View.VISIBLE);
						note.setText(move.getNote());
					}
					else
					{
						grid.setAlpha((float) 1);
						note.setVisibility(View.GONE);
					}
				}
				
				x = new String[pokemonList.size()];
				
				for(int i = 0; i < pokemonList.size(); i++)
				{
					x[i] = pokemonList.get(i);
				}
				
				pokemon = new PokedexAdapter(ctx,x);
				
				
		        
		        grid.setAdapter(pokemon);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	public void registerOnClickListener()
	{
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				
				PokemonCheck thecheck = new PokemonCheck (pokemon.getItem(position).toString(),ctx);
				String check = thecheck.getCheck();
				
				if(check.equals("0"))
				{
					Intent intent = new Intent(ctx, Tabs.class);
    				intent.putExtra("name", x[position].toLowerCase(Locale.ENGLISH));
                    startActivity(intent);
				}
				else
				{
					Intent intent = new Intent(ctx, CheckClass.class);
	                startActivity(intent);
				}
			}
			
		});
	}
		

}
