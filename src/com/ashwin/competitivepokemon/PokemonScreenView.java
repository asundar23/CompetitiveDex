package com.ashwin.competitivepokemon;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ashwin.competitivepokemon.R;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PokemonScreenView extends Fragment{

	ImageView image;
	boolean checker;
	Context ctx;
	String n;
	ArrayList<String> abilities;
	TextView evYield;
	ListView evYieldAnswer;
	TextView levelingRate;
	TextView levelingRateAnswer;
	TextView height;
	TextView heightAnswer;
	TextView weight;
	TextView weightAnswer;
	TextView eggGroup;
	ListView abilitiesList;
	String[] abilityArray;
	ListView eggGroupAnswer;
	TextView hatchTime;
	TextView hatchTimeAnswer;
	
	Pokemon thePokemon;
	BreedingGroupListViewAdapter breed;
	ArrayList<String> finalBreeding;
	
	View rootView;
	
	BreedingGroupListViewAdapter abilityAdapter;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup
			container, Bundle bundle)
	{
		super.onCreate(bundle);
		rootView = inflater.inflate(R.layout.pokemonscreenview, container,false);
		ctx = getActivity().getBaseContext();
		
		bundle = getActivity().getIntent().getExtras();
        n = bundle.getString("name");
        
        
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(n);
        boolean found = matcher.find();
        
        if(found == true)
        {
        	String myArray[] = n.split(" ");
        	n = "";
        	for(int i = 0; i < myArray.length; i++)
        	{
        		n+=myArray[i].toLowerCase(Locale.ENGLISH);
        	}
        }
        else{
        	n = n.toLowerCase(Locale.ENGLISH);
        }
		
		pattern = Pattern.compile("-");
        matcher = pattern.matcher(n);
        found = matcher.find();
		
		if(found == true)
        {
        	String myArray[] = n.split("-");
            n = myArray[0]+""+myArray[1];
        }else{
        	n = n.toLowerCase(Locale.ENGLISH);
        }
		
		image = (ImageView) rootView.findViewById(R.id.image);
		eggGroup = (TextView) rootView.findViewById(R.id.EG);
		eggGroupAnswer = (ListView) rootView.findViewById(R.id.EGanswer);
		hatchTime = (TextView) rootView.findViewById(R.id.HT);
		hatchTimeAnswer = (TextView) rootView.findViewById(R.id.HTanswer);
		height = (TextView) rootView.findViewById(R.id.height);
		weight = (TextView) rootView.findViewById(R.id.weight);
		heightAnswer = (TextView) rootView.findViewById(R.id.heightanswer);
		weightAnswer = (TextView) rootView.findViewById(R.id.weightanswer);
		evYield = (TextView) rootView.findViewById(R.id.evyield);
		evYieldAnswer = (ListView) rootView.findViewById(R.id.evyieldanswer);
		levelingRate = (TextView) rootView.findViewById(R.id.levelingrate);
		levelingRateAnswer = (TextView) rootView.findViewById(R.id.levelingrateanswer);
		
		eggGroup.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		hatchTime.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		height.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		weight.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		evYield.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		levelingRate.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
		
		
		Pokemon pokemon = new Pokemon(ctx,n);
		String[] egg = pokemon.getBreedGroups();
		
		String[] ev = pokemon.getEVYield();
		
		BreedingGroupListViewAdapter adapter = new
				BreedingGroupListViewAdapter (ev,ctx);
		evYieldAnswer.setAdapter(adapter);
		
		hatchTimeAnswer.setText(pokemon.getHatchTime());
		levelingRateAnswer.setText(pokemon.getLevelingRate());
		heightAnswer.setText(pokemon.getHeight());
		weightAnswer.setText(pokemon.getWeight());
		
		adapter = new BreedingGroupListViewAdapter(egg,ctx);
		eggGroupAnswer.setAdapter(adapter);
		
		
		checker = true;
		
		image.setImageDrawable(getResources().getDrawable(
	            getResources().getIdentifier(n, "drawable",
	                    ctx.getPackageName()))); 
		
		
		image.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(checker == true)
				{
					
					image.setImageDrawable(getResources().getDrawable(
				            getResources().getIdentifier(n+"_shiny", "drawable",
				                    ctx.getPackageName())));  
					checker = false;
				}
				else
				{
					image.setImageDrawable(getResources().getDrawable(
				            getResources().getIdentifier(n, "drawable",
				                    ctx.getPackageName())));  
					checker = true;
				}
					
			}
			
		});
		
		return rootView;
	}
}
