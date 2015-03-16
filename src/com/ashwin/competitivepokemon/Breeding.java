package com.ashwin.competitivepokemon;

import com.ashwin.competitivepokemon.R;

import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


public class Breeding extends Fragment{
	
	Pokemon pokemon;
	TextView eggGroup1;
	TextView eggGroup2;
	ListView eggMoves;
	String name;
	Context ctx;
	String[] breedMoves;
	String[] breedTypes;
	TextView note;
	int[] backgroundTypes;
	View rootView;
	TextView nameHeader;
	TextView typeHeader;
	
	ArrayList<ArrayList<String>> pokemonList;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle bundle)
	{
		super.onCreate(bundle);
		rootView = inflater.inflate(R.layout.breeding, container,false);
        
        ctx = getActivity().getApplicationContext();
        
        bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name");
        
        pokemon = new Pokemon (ctx,name);
        
        
        pokemonList = new ArrayList<ArrayList<String>>();
        
        
		
		eggGroup1 = (TextView) rootView.findViewById(R.id.egg_group_type);
		eggGroup2 = (TextView) rootView.findViewById(R.id.egg_group_type2);
		nameHeader = (TextView) rootView.findViewById(R.id.nameHeaderEgg);
		typeHeader = (TextView) rootView.findViewById(R.id.typeEgg);
		
		breedMoves = pokemon.getBreedMoves();
		breedTypes = pokemon.getBreedTypes();

		String[] breedGroups = pokemon.getBreedGroups();

		String a = breedGroups[0];
		String b = breedGroups[1];
		
		backgroundTypes = getActivity().getResources().getIntArray(R.array.typeArray);

		eggGroup1.setText(a);
		eggGroup1.setTextColor(Color.WHITE);
		eggGroup2.setText(b);
		eggGroup2.setTextColor(Color.WHITE);
		
		BreedingAdapter adapter = new BreedingAdapter(ctx,breedMoves,breedTypes,backgroundTypes,name);
		eggMoves = (ListView) rootView.findViewById(R.id.eggListView);
		note = (TextView) rootView.findViewById(R.id.note1);
		
		ViewGroup.LayoutParams params = eggMoves.getLayoutParams();
	    params.height = breedMoves.length*90;
	    eggMoves.setLayoutParams(params);
	    eggMoves.requestLayout();
	    
	    if(breedMoves.length==0)
		{
			eggMoves.setAlpha((float) .20);
			note.setText(name+" does not learn any moves by breeding.");
			note.setVisibility(View.VISIBLE);
			nameHeader.setVisibility(View.GONE);
			typeHeader.setVisibility(View.GONE);
		}
	    else
	    {
	    	note.setVisibility(View.GONE);
	    }
		
		eggMoves.setAdapter(adapter);
		
		pokemonList = pokemon.getPokemonArray();
		
		registerOnClickListener();
		
		return rootView;
	}
	
	private void registerOnClickListener()
	{
		
		eggMoves.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				view.setBackgroundColor(Color.RED);
				
			}
		});
		
		eggMoves.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
		{
			
			

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				AlertDialog.Builder dialog;
				
				GridView grid = new GridView(ctx);
				
				grid.setNumColumns(3);
				grid.setBackgroundColor(Color.BLACK);
				
				final CompatibleAdapter adapter = new CompatibleAdapter(getActivity(),pokemonList.get(position));
				
				grid.setAdapter(adapter);
				
				grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

	    			@Override
	    			public void onItemClick(AdapterView<?> parent, View view,
	    					int position, long id) {
	    				
	    				
	    				Intent intent = new Intent(ctx, Tabs.class);
	    				intent.putExtra("name", adapter.getItem(position).toString());
	                    startActivity(intent);
	    			}
	    			
		        });
				
				dialog  =  new AlertDialog.Builder(getActivity());
				
	
				
		        dialog.setView(grid);
		        dialog.setTitle("Compatible Pokemon for "+breedMoves[position]);
		        
		        
		        dialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		                dialog.cancel();
		            }
		        });
		        
		        dialog.show();
				
				return false;
			}
			
			

			
		});
	}
	
	
	

}
