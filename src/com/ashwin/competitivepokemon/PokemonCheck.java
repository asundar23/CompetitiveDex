package com.ashwin.competitivepokemon;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ashwin.competitivepokemon.R;
import org.json.*;

import android.content.Context;


public class PokemonCheck {
	
	String name;
	Context ctx;
	String check;

	public PokemonCheck(String n,Context c)
	{
		name = n;
		ctx = c;
		
		if(name.equals("Flabébé")) name = "flabebe";
		else if(name.equals("Farfetch'd")) name = "farfetchd";
		else if(name.equals("Mr. Mime")) name = "mrmime";
		else if (name.equals("Mime Jr.")) name = "mimejr";
		else if(name.equals("Nidoran♀")) name = "nidoranf";
		else if(name.equals("Nidoran♂")) name = "nidoranm";
		else{
        
	        Pattern pattern = Pattern.compile("\\s");
	        Matcher matcher = pattern.matcher(name);
	        boolean found = matcher.find();

	        if(found == true)
	        {
	        	String myArray[] = name.split(" ");
	            if(myArray.length == 2) name = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
	            else if(myArray.length == 3) name = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH)
	            		+myArray[2].toLowerCase(Locale.ENGLISH);
	            
	        }
	        
	        pattern = Pattern.compile("-");
	        matcher = pattern.matcher(name);
	        found = matcher.find();
	        
	        if(found == true)
	        {
	        	String myArray[] = name.split("-");
	            name = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
	        }
		}
		
		
		readJSONFile();
	}
	public void readJSONFile()
	{
		String result = null;
		InputStream io = null;
		int resourceID = -1;
		
		Field[] fields=R.raw.class.getFields();
		
		
	    for(int count=0; count < fields.length; count++)
	    {
	    	
	        if(fields[count].getName().equals(name.toLowerCase(Locale.ENGLISH) + "_check"))
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
		
		 try {
				JSONObject j = new JSONObject(result);
				
				check = j.getString("check");
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public String getCheck()
	{
		return check;
	}

}
