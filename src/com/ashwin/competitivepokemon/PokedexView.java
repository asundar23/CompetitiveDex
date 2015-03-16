package com.ashwin.competitivepokemon;

import java.util.ArrayList;
import java.util.Locale;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Spinner;


public class PokedexView extends Fragment{
	
	Spinner typeSpinner;
	Spinner regionSpinner;
	String[] listPokemon;
	PokedexAdapter pokedexAdapter;
	ListView pokedexListView;
	String[] newListPokemon;
	boolean isAllTypes=false;
	boolean isAllRegions=false;
	pokedexList pl;
	Pokemon pokemon;
	Context ctx;
	SearchView mSearchView;
	View rootView;
	String[] listArray;
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle bundle)
	{
		
		rootView = inflater.inflate(R.layout.pokedex_view, container,false);
		ctx = getActivity();

		populateListPokemonArray(isAllTypes,isAllRegions);
		addItemsOnSpinner1();
		addItemsOnSpinner2();
		addListenerOnButton();
		setupSearchView();
		
		listArray = new String[0];
		
		return rootView;
	}
	
	 private void setupSearchView()
	    {
		 	mSearchView = (SearchView) rootView.findViewById(R.id.search);
	        mSearchView.setIconifiedByDefault(false);
	        mSearchView.setOnQueryTextListener(new OnQueryTextListener(){

				@Override
				public boolean onQueryTextChange(String arg0) {
					if (TextUtils.isEmpty(arg0)) {
			            pokedexListView.clearTextFilter();
			            listArray = new String[0];
			            populateListPokemonArray(false,false);
			        } else {
			        	
			        	ArrayList<String> list = new ArrayList<String>();
			        	
			            for(int i = 0; i < listPokemon.length; i++)
			            {
			            	if(listPokemon[i].toLowerCase(Locale.ENGLISH).startsWith(arg0)) list.add(listPokemon[i]);
			            }
			            
			            listArray = new String[list.size()];
			            
			            for(int i = 0; i < listArray.length; i++)
			            {
			            	listArray[i] = list.get(i);
			            }
			            
			            pokedexAdapter = new PokedexAdapter(ctx,listArray);
			            pokedexListView.setAdapter(pokedexAdapter);
			            pokedexAdapter.notifyDataSetChanged();
			        }
			        return true;
				}

				@Override
				public boolean onQueryTextSubmit(String arg0) {
					// TODO Auto-generated method stub
					return false;
				}
	        	
	        });
	        mSearchView.setSubmitButtonEnabled(false);
	        mSearchView.setQueryHint("Search Here");
	    }

	private void populateListPokemonArray(boolean f,boolean r) {
		
		if(f==true && r==false)
		{
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Grass"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.grass_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapGrassTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ground"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.ground_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapGroundTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Bug"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.bug_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapBugTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fire"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.fire_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapFireTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Steel"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.steel_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapSteelTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Rock"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.rock_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapRockTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fairy"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.fairy_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapFairyTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dark"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.dark_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapDarkTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fighting"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.fighting_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapFightingTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Normal"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.normal_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapNormalTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Psychic"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.psychic_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapPsychicTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ghost"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.ghost_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapGhostTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Electric"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.electric_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapElectricTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Flying"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.flying_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapFlyingTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Water"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.water_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapWaterTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dragon"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.dragon_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapDragonTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ice"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.ice_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapIceTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Normal"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.normal_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapNormalTypes();
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Poison"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.poison_pokemon);
				pl = new pokedexList(listPokemon);
				pl.mapPoisonTypes();
			}
		}
		
		if(f==false && r==true)
		{
			if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.kanto);
				pl = new pokedexList(listPokemon);
				pl.mapKanto();
			}
			if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.johto);
				pl = new pokedexList(listPokemon);
				pl.mapJohto();
			}
			if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.hoenn);
				pl = new pokedexList(listPokemon);
				pl.mapHoenn();
			}
			if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.sinnoh);
				pl = new pokedexList(listPokemon);
				pl.mapSinnoh();
			}
			if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.unova);
				pl = new pokedexList(listPokemon);
				pl.mapUnova();
			}
			if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
			{
				listPokemon = ctx.getResources().getStringArray(R.array.kalos);
				pl = new pokedexList(listPokemon);
				pl.mapKalos();
			}
		}
		
		if(f==true && r==true)
		{
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fire"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_fire);
					pl = new pokedexList(listPokemon);
					pl.mapKantoFire();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_fire);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoFire();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_fire);
					pl = new pokedexList(listPokemon);
					pl.mapHoennFire();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_fire);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohFire();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_fire);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaFire();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_fire);
					pl = new pokedexList(listPokemon);
					pl.mapKalosFire();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fighting"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_fighting);
					pl = new pokedexList(listPokemon);
					pl.mapKantoFighting();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_fighting);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoFighting();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_fighting);
					pl = new pokedexList(listPokemon);
					pl.mapHoennFighting();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_fighting);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohFighting();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_fighting);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaFighting();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_fighting);
					pl = new pokedexList(listPokemon);
					pl.mapKalosFighting();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Bug"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_bug);
					pl = new pokedexList(listPokemon);
					pl.mapKantoBug();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_bug);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoBug();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_bug);
					pl = new pokedexList(listPokemon);
					pl.mapHoennBug();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_bug);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohBug();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_bug);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaBug();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_bug);
					pl = new pokedexList(listPokemon);
					pl.mapKalosBug();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Water"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_water);
					pl = new pokedexList(listPokemon);
					pl.mapKantoWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_water);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_water);
					pl = new pokedexList(listPokemon);
					pl.mapHoennWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_water);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_water);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_water);
					pl = new pokedexList(listPokemon);
					pl.mapKalosWater();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Rock"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_rock);
					pl = new pokedexList(listPokemon);
					pl.mapKantoRock();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_rock);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoRock();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_rock);
					pl = new pokedexList(listPokemon);
					pl.mapHoennRock();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_rock);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohRock();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_rock);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaRock();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_rock);
					pl = new pokedexList(listPokemon);
					pl.mapKalosRock();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Steel"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_steel);
					pl = new pokedexList(listPokemon);
					pl.mapKantoSteel();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_steel);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoSteel();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_steel);
					pl = new pokedexList(listPokemon);
					pl.mapHoennSteel();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_steel);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohSteel();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_steel);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaSteel();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_steel);
					pl = new pokedexList(listPokemon);
					pl.mapKalosSteel();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fairy"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_fairy);
					pl = new pokedexList(listPokemon);
					pl.mapKantoFairy();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_fairy);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoFairy();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_fairy);
					pl = new pokedexList(listPokemon);
					pl.mapHoennFairy();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_fairy);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohFairy();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_fairy);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaFairy();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_fairy);
					pl = new pokedexList(listPokemon);
					pl.mapKalosFairy();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Poison"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_poison);
					pl = new pokedexList(listPokemon);
					pl.mapKantoPoison();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_poison);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoPoison();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_poison);
					pl = new pokedexList(listPokemon);
					pl.mapHoennPoison();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_poison);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohPoison();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_poison);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaPoison();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_poison);
					pl = new pokedexList(listPokemon);
					pl.mapKalosPoison();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Grass"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_grass);
					pl = new pokedexList(listPokemon);
					pl.mapKantoGrass();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_grass);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoGrass();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_grass);
					pl = new pokedexList(listPokemon);
					pl.mapHoennGrass();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_grass);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohGrass();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_grass);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaGrass();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_grass);
					pl = new pokedexList(listPokemon);
					pl.mapKalosGrass();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Water"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_water);
					pl = new pokedexList(listPokemon);
					pl.mapKantoWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_water);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_water);
					pl = new pokedexList(listPokemon);
					pl.mapHoennWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_water);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_water);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaWater();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_water);
					pl = new pokedexList(listPokemon);
					pl.mapKalosWater();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dark"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_dark);
					pl = new pokedexList(listPokemon);
					pl.mapKantoDark();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_dark);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoDark();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_dark);
					pl = new pokedexList(listPokemon);
					pl.mapHoennDark();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_dark);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohDark();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_dark);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaDark();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_dark);
					pl = new pokedexList(listPokemon);
					pl.mapKalosDark();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ghost"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_ghost);
					pl = new pokedexList(listPokemon);
					pl.mapKantoGhost();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_ghost);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoGhost();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_ghost);
					pl = new pokedexList(listPokemon);
					pl.mapHoennGhost();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_ghost);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohGhost();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_ghost);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaGhost();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_ghost);
					pl = new pokedexList(listPokemon);
					pl.mapKalosGhost();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Electric"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_electric);
					pl = new pokedexList(listPokemon);
					pl.mapKantoElectric();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_electric);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoElectric();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_electric);
					pl = new pokedexList(listPokemon);
					pl.mapHoennElectric();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_electric);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohElectric();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_electric);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaElectric();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_electric);
					pl = new pokedexList(listPokemon);
					pl.mapKalosElectric();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Normal"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_normal);
					pl = new pokedexList(listPokemon);
					pl.mapKantoNormal();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_normal);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoNormal();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_normal);
					pl = new pokedexList(listPokemon);
					pl.mapHoennNormal();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_normal);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohNormal();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_normal);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaNormal();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_normal);
					pl = new pokedexList(listPokemon);
					pl.mapKalosNormal();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dragon"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_dragon);
					pl = new pokedexList(listPokemon);
					pl.mapKantoDragon();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_dragon);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoDragon();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_dragon);
					pl = new pokedexList(listPokemon);
					pl.mapHoennDragon();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_dragon);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohDragon();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_dragon);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaDragon();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_dragon);
					pl = new pokedexList(listPokemon);
					pl.mapKalosDragon();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ice"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_ice);
					pl = new pokedexList(listPokemon);
					pl.mapKantoIce();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_ice);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoIce();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_ice);
					pl = new pokedexList(listPokemon);
					pl.mapHoennIce();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_ice);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohIce();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_ice);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaIce();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_ice);
					pl = new pokedexList(listPokemon);
					pl.mapKalosIce();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ground"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_ground);
					pl = new pokedexList(listPokemon);
					pl.mapKantoGround();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_ground);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoGround();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_ground);
					pl = new pokedexList(listPokemon);
					pl.mapHoennGround();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_ground);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohGround();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_ground);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaGround();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_ground);
					pl = new pokedexList(listPokemon);
					pl.mapKalosGround();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Psychic"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_psychic);
					pl = new pokedexList(listPokemon);
					pl.mapKantoPsychic();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_psychic);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoPsychic();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_psychic);
					pl = new pokedexList(listPokemon);
					pl.mapHoennPsychic();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_psychic);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohPsychic();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_psychic);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaPsychic();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_psychic);
					pl = new pokedexList(listPokemon);
					pl.mapKalosPsychic();
				}
			}
			if(String.valueOf(typeSpinner.getSelectedItem()).equals("Flying"))
			{
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kanto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kanto_flying);
					pl = new pokedexList(listPokemon);
					pl.mapKantoFlying();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Johto"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.johto_flying);
					pl = new pokedexList(listPokemon);
					pl.mapJohtoFlying();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Hoenn"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.hoenn_flying);
					pl = new pokedexList(listPokemon);
					pl.mapHoennFlying();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Sinnoh"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.sinnoh_flying);
					pl = new pokedexList(listPokemon);
					pl.mapSinnohFlying();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Unova"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.unova_flying);
					pl = new pokedexList(listPokemon);
					pl.mapUnovaFlying();
				}
				if(String.valueOf(regionSpinner.getSelectedItem()).equals("Kalos"))
				{
					listPokemon = ctx.getResources().getStringArray(R.array.kalos_flying);
					pl = new pokedexList(listPokemon);
					pl.mapKalosFlying();
				}
			}
		}
		
		if(f==false && r==false)
		{
			listPokemon = ctx.getResources().getStringArray(R.array.list_of_pokemon);
			pl = new pokedexList(listPokemon);
			pl.mapList();
		}
		
		pokedexAdapter = new PokedexAdapter (ctx,listPokemon);
		
		pokedexListView = (ListView) rootView.findViewById(R.id.listView);
		pokedexListView.setAdapter(pokedexAdapter);
		
		pokedexListView.setTextFilterEnabled(true);
        setupSearchView();
		
		registerOnClickListener();
		
		
	}
	
	
	
	private void registerOnClickListener() {
		
		pokedexListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				PokemonCheck thecheck = new PokemonCheck (pokedexAdapter.getItem(position).toString(),ctx);
				String check = thecheck.getCheck();
				
				if(check.equals("0"))
				{
					if(listArray.length == 0)
					{
						Intent intent = new Intent(ctx, Tabs.class);
	    				intent.putExtra("name", listPokemon[position].toLowerCase(Locale.ENGLISH));
	                    startActivity(intent);
					}
					else
					{
						Intent intent = new Intent(ctx, Tabs.class);
	    				intent.putExtra("name", listArray[position].toLowerCase(Locale.ENGLISH));
	                    startActivity(intent);
					}
				}
				else
				{
					Intent intent = new Intent(ctx, CheckClass.class);
	                startActivity(intent);
				}
			}
		});	
	}

	public void addItemsOnSpinner1()
	{
		typeSpinner = (Spinner) rootView.findViewById(R.id.pokedex_type_spinner);
		CustomSpinnerType typeAdapter = new CustomSpinnerType(ctx);
		typeSpinner.setAdapter(typeAdapter);
	}
	
	public void addItemsOnSpinner2()
	{
		regionSpinner = (Spinner) rootView.findViewById(R.id.pokedex_region_spinner);
		regionSpinner.setPrompt("Region");
		ArrayAdapter<CharSequence> regionAdapter = ArrayAdapter.createFromResource(ctx,
		        R.array.pokedex_region_array, android.R.layout.simple_spinner_item);
		
		regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		regionSpinner.setAdapter(regionAdapter);
	}
	
	private void addListenerOnButton() {
		
		typeSpinner = (Spinner) rootView.findViewById(R.id.pokedex_type_spinner);
		regionSpinner = (Spinner) rootView.findViewById(R.id.pokedex_region_spinner);
		
		typeSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				goToTypeList();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				//blank. do not put anything here
				
			}
			
		});
		
		regionSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				goToTypeList();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				//blank. do not put anything here
				
			}
			
		});
		
	}

	private void goToTypeList() {

		if(!String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)") &&
				!String.valueOf(regionSpinner.getSelectedItem()).equals("All (Region)"))
		{
			isAllTypes = true;
			isAllRegions = true;
		}
		if(!String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)") &&
				String.valueOf(regionSpinner.getSelectedItem()).equals("All (Region)"))
		{
			isAllTypes = true;
			isAllRegions = false;
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)") &&
				!String.valueOf(regionSpinner.getSelectedItem()).equals("All (Region)"))
		{
			isAllTypes = false;
			isAllRegions = true;
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)")&&
				String.valueOf(regionSpinner.getSelectedItem()).equals("All (Region)"))
		{
			isAllTypes = false;
			isAllRegions = false;
		}
		
		populateListPokemonArray(isAllTypes,isAllRegions);
	}

}
