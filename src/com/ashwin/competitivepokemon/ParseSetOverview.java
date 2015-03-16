package com.ashwin.competitivepokemon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ashwin.competitivepokemon.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;


public class ParseSetOverview {
	
	String name;
	Context ctx;
	
	String[] strengths;
	String[] weaknesses;
	
	public ParseSetOverview(Context c, String n)
	{
		ctx = c;
		name = n;
		
		Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(name);
        boolean found = matcher.find();
		
		if(found == true)
        {
        	String myArray[] = name.split(" ");
        	name = "";
        	for(int i = 0; i < myArray.length; i++)
        	{
        		name += myArray[i].toLowerCase(Locale.ENGLISH);
        	}
        }
		
		pattern = Pattern.compile("-");
        matcher = pattern.matcher(name);
        found = matcher.find();
		
		if(found == true)
        {
        	String myArray[] = name.split("-");
        	name = "";
        	for(int i = 0; i < myArray.length; i++)
        	{
        		name += myArray[i].toLowerCase(Locale.ENGLISH);
        	}
            
        }
		
		readJSONFile(name+"_set");
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
			
			JSONArray st = j.getJSONArray("strengths");
			strengths = new String[st.length()];
			
			JSONArray we = j.getJSONArray("weaknesses");
			weaknesses = new String[we.length()];
			
			for(int i = 0; i < strengths.length; i++)
			{
				try{
					String x = st.getString(i);
					strengths[i] = x;
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < weaknesses.length; i++)
			{
				try{
					String x = we.getString(i);
					weaknesses[i] = x;
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String[] getStrengths()
	{
		return strengths;
	}
	
	public String[] getWeaknesses()
	{
		return weaknesses;
	}

}
