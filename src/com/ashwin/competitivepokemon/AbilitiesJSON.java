package com.ashwin.competitivepokemon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ashwin.competitivepokemon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;


public class AbilitiesJSON {
	
	String summary;
	String viability;
	Context ctx;
	String name;
	ArrayList<String> pokemon;
	
	public AbilitiesJSON(Context c, String n){
		
		ctx = c;
		name = n;
		summary="";
		viability="";
		
		if(name.equals("Static")) name = "staticx";
		
		if(name.contains(" (Unreleased)")) name.replaceAll(" (Unreleased)", "");
		
		pokemon = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(name);
        boolean found = matcher.find();
        
		if(found == true)
        {
        	String myArray[] = name.split(" ");
            name = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
        }
        
        pattern = Pattern.compile("-");
        matcher = pattern.matcher(name);
        found = matcher.find();
        
        if(found == true)
        {
        	String myArray[] = name.split("-");
            name = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
        }
        
        name = name.toLowerCase(Locale.ENGLISH);
		readJSONFile(name);
		
	}
	
	public void readJSONFile(String name)
	{
		String result = null;
		InputStream io = null;
		int resourceID = -1;
		
		Field[] fields=R.raw.class.getFields();
		
	    for(int count=0; count < fields.length; count++)
	    {
	        if(fields[count].getName().equals(name.toLowerCase(Locale.ENGLISH)))
	        {
	        	try {
					resourceID=fields[count].getInt(fields[count]);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	    
		io = ctx.getResources().openRawResource(resourceID);
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(io, "UTF-8"), 8);
			StringBuilder sb = new StringBuilder();
			
			
			String line = null;
		    while ((line = reader.readLine()) != null)
		    {
		        sb.append(line + "\n");
		    }
		    result = sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			JSONObject j = new JSONObject(result);
			
			summary = j.getString("summary");
			viability = j.getString("viability");
			
			JSONArray pokemonList = j.getJSONArray("pokemon");
			
			for(int i = 0; i < pokemonList.length(); i++)
			{
				try{
					JSONObject oneObject = pokemonList.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	pokemon.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<String> getPokemon(){
			return pokemon;
	}
	public String getSummery()
	{
		return summary;
	}
	
	public String getViability()
	{
		return viability;
	}
	
	public String getName()
	{
		return name;
	}

}
