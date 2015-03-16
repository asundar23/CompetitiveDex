package com.ashwin.competitivepokemon;

import java.util.ArrayList;

import com.ashwin.competitivepokemon.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;


public class AbilitiesPokemon extends Fragment{
	
	TextView text1;
	TextView text2;
	TextView text3;
	TextView summary1;
	TextView summary2;
	TextView summary3;
	
	String ability1;
	String ability2;
	String ability3;
	
	String type;
	ArrayList<String> abilities;
	int[] typeColors;
	Context ctx;
	String pokemonName;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		
		View rootView = inflater.inflate(R.layout.abilities, container, false);
		
		bundle = getActivity().getIntent().getExtras();
		pokemonName = bundle.getString("name");
		
		Pokemon pokemon = new Pokemon(getActivity(),pokemonName);
		type = pokemon.getType1();
		
		abilities = pokemon.getAbilities();
		
		for(int i = 0; i < abilities.size(); i++)
		{
			Log.d("tag",abilities.get(i));
		}
		
		typeColors = getActivity().getResources().getIntArray(R.array.typeArray);
		
		ctx = getActivity().getBaseContext();
		
		text1 = (TextView) rootView.findViewById(R.id.ability1);
		text2 = (TextView) rootView.findViewById(R.id.ability2);
		text3 = (TextView) rootView.findViewById(R.id.ability3);
		
		summary1 = (TextView) rootView.findViewById(R.id.summary1);
		summary2 = (TextView) rootView.findViewById(R.id.summary2);
		summary3 = (TextView) rootView.findViewById(R.id.summary3);
		
		summary2.setVisibility(View.GONE);
		summary3.setVisibility(View.GONE);
		
		text1.setText(abilities.get(0));
		
		ability1 = abilities.get(0);
		if(ability1.contains(" (Unreleased)")) ability1 = ability1.replace(" (Unreleased)", "");
		Log.d("tag",ability1);
		AbilitiesJSON sum1 = new AbilitiesJSON(ctx,ability1);
		summary1.setText(sum1.getSummery());
		
		text2.setVisibility(View.GONE);
		text3.setVisibility(View.GONE);
		
		if(abilities.size() == 2){
			text2.setVisibility(View.VISIBLE);
			text2.setText(abilities.get(1));
			summary2.setVisibility(View.VISIBLE);
			
			ability2 = abilities.get(1);
			if(ability2.contains(" (Unreleased)")) ability2 = ability2.replace(" (Unreleased)", "");
			Log.d("tag",ability2);
			AbilitiesJSON sum2 = new AbilitiesJSON(ctx,ability2);
			
			summary2.setText(sum2.getSummery());
			
			text3.setVisibility(View.GONE);
			summary3.setVisibility(View.GONE);
		}
		
		if(abilities.size() == 3){
			ability2 = abilities.get(1);
			text2.setVisibility(View.VISIBLE);
			text2.setText(abilities.get(1));
			summary2.setVisibility(View.VISIBLE);
			if(ability2.contains(" (Unreleased)")) ability2 = ability2.replace(" (Unreleased)", "");
			Log.d("tag",ability2);
			AbilitiesJSON sum2 = new AbilitiesJSON(ctx,ability2);
			
			summary2.setText(sum2.getSummery());
			
			ability3 = abilities.get(2);
			text3.setVisibility(View.VISIBLE);
			text3.setText(abilities.get(2));
			summary3.setVisibility(View.VISIBLE);
			if(ability3.contains(" (Unreleased)")) ability3 = ability3.replace(" (Unreleased)", "");
			Log.d("tag",ability3);
			AbilitiesJSON sum3 = new AbilitiesJSON(ctx,ability3);
			
			summary3.setText(sum3.getSummery());
		}
		
		setColors();
		setOnClickListeners();
		
		return rootView;
	}
	
	public void setOnClickListeners(){
		
		text1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ctx,TabsAbilities.class);
				intent.putExtra("name", ability1);
				startActivity(intent);
			}
			
		});
		
		if(abilities.size()==2){
			text2.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx,TabsAbilities.class);
					intent.putExtra("name", ability2);
					startActivity(intent);
				}
				
			});
		}
		
		if(abilities.size()==3){
			text2.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx,TabsAbilities.class);
					intent.putExtra("name", ability2);
					startActivity(intent);
				}
				
			});
			text3.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx,TabsAbilities.class);
					intent.putExtra("name", ability3);
					startActivity(intent);
				}
				
			});
		}
	}
	
	public void setColors(){
		
		if(type.equals(" Bug ")){
			text1.setTextColor(typeColors[0]);
			text2.setTextColor(typeColors[0]);
			text3.setTextColor(typeColors[0]);
		}
		
		if(type.equals(" Dark ")){
			text1.setTextColor(typeColors[1]);
			text2.setTextColor(typeColors[1]);
			text3.setTextColor(typeColors[1]);
		}
		
		if(type.equals(" Dragon ")){
			text1.setTextColor(typeColors[2]);
			text2.setTextColor(typeColors[2]);
			text3.setTextColor(typeColors[2]);
		}
		
		if(type.equals(" Electric ")){
			text1.setTextColor(typeColors[3]);
			text2.setTextColor(typeColors[3]);
			text3.setTextColor(typeColors[3]);
		}
		
		if(type.equals(" Fairy ")){
			text1.setTextColor(typeColors[4]);
			text2.setTextColor(typeColors[4]);
			text3.setTextColor(typeColors[4]);
		}
		
		if(type.equals(" Fighting ")){
			text1.setTextColor(typeColors[5]);
			text2.setTextColor(typeColors[5]);
			text3.setTextColor(typeColors[5]);
		}
		
		if(type.equals(" Fire ")){
			text1.setTextColor(typeColors[6]);
			text2.setTextColor(typeColors[6]);
			text3.setTextColor(typeColors[6]);
		}
		
		if(type.equals(" Flying ")){
			text1.setTextColor(typeColors[7]);
			text2.setTextColor(typeColors[7]);
			text3.setTextColor(typeColors[7]);
		}
		
		if(type.equals(" Ghost ")){
			text1.setTextColor(typeColors[8]);
			text2.setTextColor(typeColors[8]);
			text3.setTextColor(typeColors[8]);
		}
		
		if(type.equals(" Grass ")){
			text1.setTextColor(typeColors[9]);
			text2.setTextColor(typeColors[9]);
			text3.setTextColor(typeColors[9]);
		}
		
		if(type.equals(" Ground ")){
			text1.setTextColor(typeColors[10]);
			text2.setTextColor(typeColors[10]);
			text3.setTextColor(typeColors[10]);
		}
		
		if(type.equals(" Ice ")){
			text1.setTextColor(typeColors[11]);
			text2.setTextColor(typeColors[11]);
			text3.setTextColor(typeColors[11]);
		}
		if(type.equals(" Normal ")){
			text1.setTextColor(typeColors[12]);
			text2.setTextColor(typeColors[12]);
			text3.setTextColor(typeColors[12]);
		}
		
		if(type.equals(" Poison ")){
			text1.setTextColor(typeColors[13]);
			text2.setTextColor(typeColors[13]);
			text3.setTextColor(typeColors[13]);
		}
		
		if(type.equals(" Psychic ")){
			text1.setTextColor(typeColors[14]);
			text2.setTextColor(typeColors[14]);
			text3.setTextColor(typeColors[14]);
		}
		
		if(type.equals(" Rock ")){
			text1.setTextColor(typeColors[15]);
			text2.setTextColor(typeColors[15]);
			text3.setTextColor(typeColors[15]);
		}
		
		if(type.equals(" Steel ")){
			text1.setTextColor(typeColors[16]);
			text2.setTextColor(typeColors[16]);
			text3.setTextColor(typeColors[16]);
		}
		
		if(type.equals(" Water ")){
			text1.setTextColor(typeColors[17]);
			text2.setTextColor(typeColors[17]);
			text3.setTextColor(typeColors[17]);
		}
		
		
	}

}
