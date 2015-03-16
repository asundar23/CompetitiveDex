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
import android.util.Log;


public class MovesJSON {
	
	String name;
	Context ctx;
	ArrayList<String> pokemonLevel;
	ArrayList<String> pokemonBreeding;
	ArrayList<String> pokemonTutor;
	ArrayList<String> pokemonByTM;
	ArrayList<String> pokemonByHM;
	String power;
	String type;
	String accuracy;
	String summary;
	String viability;
	String pp;
	String note;
	String category;
	
	public MovesJSON(Context c, String n)
	{
		name = n;
		
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
            name = myArray[0]+""+myArray[1];
        }
		
		pattern = Pattern.compile("'");
        matcher = pattern.matcher(name);
        found = matcher.find();
		
		if(found == true)
        {
        	String myArray[] = name.split("-");
            name = myArray[0]+""+myArray[1];
        }
		
		ctx = c;
		power="";
		type="";
		pp="";
		accuracy="";
		summary="";
		viability="";
		category ="";
		note = "";
		pokemonLevel = new ArrayList<String>();
		pokemonBreeding = new ArrayList<String>();
		pokemonTutor = new ArrayList<String>();
		pokemonByTM = new ArrayList<String>();
		pokemonByHM = new ArrayList<String>();
		readJSONFile(name);
		
	}
	
	public void readJSONFile(String name)
	{
		String result = null;
		InputStream io = null;
		int resourceID = -1;
		
		Field[] fields=R.raw.class.getFields();
		
		if(name.equals("Return"))
		{
			name = "returnmove";
		}
		
		Log.d("tag",name);
		
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

			type = j.getString("type");
			category = j.getString("category");
			pp = j.getString("pp");
			note = j.getString("note");
			power = j.getString("power");
			accuracy = j.getString("accuracy");
			summary = j.getString("summary");
			viability = j.getString("viability");
			
			JSONArray level = j.getJSONArray("pokemonByLevel");
			
			JSONArray breed = j.getJSONArray("pokemonByBreeding");
			
			JSONArray tutor = j.getJSONArray("pokemonByTutor");
			
			JSONArray tm = j.getJSONArray("pokemonByTM");
			
			JSONArray hm = j.getJSONArray("pokemonByHM");
			
			
			for(int i = 0; i < level.length(); i++)
			{
				try{
					JSONObject oneObject = level.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	pokemonLevel.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < breed.length(); i++)
			{
				try{
					JSONObject oneObject = breed.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	pokemonBreeding.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < tutor.length(); i++)
			{
				try{
					JSONObject oneObject = tutor.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	pokemonTutor.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < hm.length(); i++)
			{
				try{
					JSONObject oneObject = hm.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	pokemonByHM.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < tm.length(); i++)
			{
				try{
					JSONObject oneObject = tm.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	pokemonByTM.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getPower()
	{
		return power;
	}
	
	public String getAccuracy()
	{
		return accuracy;
	}
	
	public String getSummary()
	{
		return summary;
	}
	
	public String getViability()
	{
		return viability;
	}
	
	public String getPP()
	{
		return pp;
	}
	
	public ArrayList<String> getPokemonLevel()
	{
		return pokemonLevel;
	}
	
	public ArrayList<String> getPokemonTM()
	{
		return pokemonByTM;
	}
	
	public ArrayList<String> getPokemonHM()
	{
		return pokemonByHM;
	}
	
	public ArrayList<String> getPokemonBreeding()
	{
		return pokemonBreeding;
	}
	
	public String getNote()
	{
		return note;
	}
	
	public ArrayList<String> getPokemonTutor()
	{
		return pokemonTutor;
	}

}
