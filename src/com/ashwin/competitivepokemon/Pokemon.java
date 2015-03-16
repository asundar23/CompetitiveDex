package com.ashwin.competitivepokemon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ashwin.competitivepokemon.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;


public class Pokemon {
	
	String name;
	int hp,att,def,spa,spd,spe;
	Context ctx;
	ArrayList<String> abilities;
	
	HashMap<String,String[]> XlocationMap;
	HashMap<String,String[]> YlocationMap;
	HashMap<String,String[]> ASlocationMap;
	HashMap<String,String[]> ORlocationMap;
	
	String hatchTime;
	String[] evYield;
	String height;
	String weight;
	String levelingRate;
	
	String pokedexNumber;
	
	String[] setName;
	ArrayList<String> items;
	String[] ability;
	ArrayList<String> ev;
	String[] pokemonList;
	
	String[] XlocationTypeArray;
	String[] XlocationArray;
	
	String[] YlocationTypeArray;
	String[] YlocationArray;
	
	String[] ORlocationTypeArray;
	String[] ORlocationArray;
	
	String[] ASlocationTypeArray;
	String[] ASlocationArray;
	
	String setCheck;
	
	ArrayList<String> natures;
	ArrayList<String> moves;
	
	ArrayList<String> alternativeMoves;
	
	ArrayList<ArrayList<String>> allAlternativeMoves;
	
	String[] setEx;
	String[] cc;
	String[] damc;
	
	String pokemon;
			
	ArrayList<ArrayList<String>> allItems;
	ArrayList<ArrayList<String>> allEV;
	ArrayList<ArrayList<String>> allNatures;
	ArrayList<ArrayList<String>> allMoves;
	
	String move;
	
	ArrayList<String> preevolution;
	ArrayList<String> postevolution;
	ArrayList<String> evolutionType;
	
	String[] levelArray;
	String[] levelMoveArray;
	String[] levelTypeArray;
	String[] breedType;
	
	String[] breedGroup = new String[2];
	
	ArrayList<String> pA;
	String[] breedingMoves;
	
	ArrayList<ArrayList<String>> listOfPokemonArray;
	
	String[] tmArrayMoves;
	String[] tmArrayTypes;
	String[] tmArray;

	String[] tutorArray;
	String[] tutorType;
	String[] tutorGame;
	
	String[] ORASLevelArray;
	String[] ORASMoveArray;
	String[] ORASTypeArray;
	
	String[] ORASTMArray;
	String[] ORASTMMoveArray;
	String[] ORASTMTypeArray;
	
	String[] types = new String[2];
	
	HashMap<Integer,String> map;
	HashMap<String,String> map2;
	ArrayList<String> tutorMoves;
	
	HashMap<String,String> tutorMap;
	HashMap<String,String> tutorGameMap;
	
	ArrayList<String> locationsGame;
	
	int i = 0;
	
	
	public Pokemon(Context c,String n)
	{
		
		
		
		hp=0;
		att=0;
		def=0;
		spa=0;
		spd=0;
		spe=0;
		
		allItems = new ArrayList<ArrayList<String>>();
		allEV = new ArrayList<ArrayList<String>>();
		allNatures = new ArrayList<ArrayList<String>>();
		allMoves = new ArrayList<ArrayList<String>>();
		allAlternativeMoves = new ArrayList<ArrayList<String>>();
		
		preevolution = new ArrayList<String>();
		postevolution = new ArrayList<String>();
		evolutionType = new ArrayList<String>();
		
		setCheck = "";
		
		breedGroup[0] = "";
		breedGroup[1] = "";
		locationsGame = new ArrayList<String>();
		
		ctx = c;
		name = n;
		
		if(name.equals("Flabébé")) name = "flabebe";
		else if(name.equals("Farfetch'd")) name = "farfetchd";
		else if(name.equals("Mr. Mime")) name = "mrmime";
		else if (name.equals("Mime Jr.")) name = "mimejr";
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
        
		types[0] = "";
		types[1] = "";
		
		abilities = new ArrayList<String>();
		
		
		
		tutorMoves = new ArrayList<String>();
		map2 = new HashMap<String,String>();
		listOfPokemonArray = new ArrayList<ArrayList<String>>();
		tutorMap = new HashMap<String,String>();
		tutorGameMap = new HashMap<String,String>();
		
		
		tutorMap.put("Bind"," Normal ");
		tutorMap.put("Snore"," Normal ");
		tutorMap.put("Water Pulse"," Water ");
		tutorMap.put("Shock Wave"," Electric ");
		tutorMap.put("Bug Bite"," Bug ");
		tutorMap.put("Covet"," Normal ");
		tutorMap.put("Low Kick"," Fighting ");
		tutorMap.put("Signal Beam"," Bug ");
		tutorMap.put("Giga Drain"," Grass ");
		tutorMap.put("Thunder Punch"," Electric ");
		tutorMap.put("Fire Punch"," Fire ");
		tutorMap.put("Ice Punch"," Ice ");
		tutorMap.put("Drain Punch"," Fighting ");
		tutorMap.put("Knock Off"," Dark ");
		tutorMap.put("Super Fang"," Normal ");
		tutorMap.put("Dual Chop"," Dragon ");
		tutorMap.put("Endeavor"," Normal ");
		tutorMap.put("Uproar"," Normal ");
		tutorMap.put("Iron Tail"," Steel ");
		tutorMap.put("Bounce"," Flying ");
		tutorMap.put("Drill Run"," Ground ");
		tutorMap.put("Iron Head"," Steel ");
		tutorMap.put("Zen Headbutt"," Psychic ");
		tutorMap.put("Aqua Tail"," Water ");
		tutorMap.put("Dragon Pulse"," Dragon ");
		tutorMap.put("Seed Bomb"," Grass ");
		tutorMap.put("Heat Wave"," Fire ");
		tutorMap.put("Last Resort"," Normal ");
		tutorMap.put("Hyper Voice"," Normal ");
		tutorMap.put("Foul Play"," Dark ");
		tutorMap.put("Earth Power"," Ground ");
		tutorMap.put("Outrage"," Dragon ");
		tutorMap.put("Superpower"," Fighting ");
		tutorMap.put("Gunk Shot"," Poison ");
		tutorMap.put("Sky Attack"," Flying ");
		tutorMap.put("Focus Punch"," Fighting ");
		tutorMap.put("Block"," Normal ");
		tutorMap.put("Skill Swap"," Psychic ");
		tutorMap.put("Synthesis"," Grass ");
		tutorMap.put("Role Play"," Psychic ");
		tutorMap.put("Pain Split"," Normal ");
		tutorMap.put("Gastro Acid"," Poison ");
		tutorMap.put("Worry Seed"," Grass ");
		tutorMap.put("Spite"," Ghost ");
		tutorMap.put("After You"," Normal ");
		tutorMap.put("Helping Hand"," Normal ");
		tutorMap.put("Trick"," Psychic ");
		tutorMap.put("Recycle"," Normal ");
		tutorMap.put("Snatch"," Dark ");
		tutorMap.put("Magic Coat"," Psychic ");
		tutorMap.put("Magnet Rise"," Electric ");
		tutorMap.put("Iron Defense"," Steel ");
		tutorMap.put("Heal Bell"," Normal ");
		tutorMap.put("Tailwind"," Flying ");
		tutorMap.put("Magic Room"," Psychic ");
		tutorMap.put("Wonder Room"," Psychic ");
		tutorMap.put("Stealth Rock"," Rock ");
		tutorMap.put("Gravity"," Psychic ");
		tutorMap.put("Electroweb"," Electric ");
		tutorMap.put("Icy Wind"," Ice ");
		tutorMap.put("Frenzy Plant", " Grass ");
		tutorMap.put("Blast Burn"," Fire ");
		tutorMap.put("Hydro Cannon"," Water ");
		tutorMap.put("Grass Pledge", " Grass ");
		tutorMap.put("Fire Pledge", " Fire ");
		tutorMap.put("Water Pledge", " Water ");
		tutorMap.put("Relic Song", " Normal ");
		tutorMap.put("Secret Sword", " Fighting ");
		tutorMap.put("Draco Meteor", " Dragon ");
		tutorMap.put("Dragon Ascent", " Flying ");
		
		tutorMap.put("Bind"," ORAS ");
		tutorMap.put("Snore"," ORAS ");
		tutorMap.put("ORAS Pulse"," ORAS ");
		tutorMap.put("Shock Wave"," ORAS ");
		tutorMap.put("ORAS Bite"," ORAS ");
		tutorMap.put("Covet"," ORAS ");
		tutorMap.put("Low Kick"," ORAS ");
		tutorMap.put("Signal Beam"," ORAS ");
		tutorMap.put("Giga Drain"," ORAS ");
		tutorMap.put("Thunder Punch"," ORAS ");
		tutorMap.put("ORAS Punch"," ORAS ");
		tutorMap.put("ORAS Punch"," ORAS ");
		tutorMap.put("Drain Punch"," ORAS ");
		tutorMap.put("Knock Off"," ORAS ");
		tutorMap.put("Super Fang"," ORAS ");
		tutorMap.put("Dual Chop"," ORAS ");
		tutorMap.put("Endeavor"," ORAS ");
		tutorMap.put("Uproar"," ORAS ");
		tutorMap.put("Iron Tail"," ORAS ");
		tutorMap.put("Bounce"," ORAS ");
		tutorMap.put("Drill Run"," ORAS ");
		tutorMap.put("Iron Head"," ORAS ");
		tutorMap.put("Zen Headbutt"," ORAS ");
		tutorMap.put("Aqua Tail"," ORAS ");
		tutorMap.put("ORAS Pulse"," ORAS ");
		tutorMap.put("Seed Bomb"," ORAS ");
		tutorMap.put("Heat Wave"," ORAS ");
		tutorMap.put("Last Resort"," ORAS ");
		tutorMap.put("Hyper VoORAS"," ORAS ");
		tutorMap.put("Foul Play"," ORAS ");
		tutorMap.put("Earth Power"," ORAS ");
		tutorMap.put("Outrage"," ORAS ");
		tutorMap.put("Superpower"," ORAS ");
		tutorMap.put("Gunk Shot"," ORAS ");
		tutorMap.put("Sky Attack"," ORAS ");
		tutorMap.put("Focus Punch"," ORAS ");
		tutorMap.put("Block"," ORAS ");
		tutorMap.put("Skill Swap"," ORAS ");
		tutorMap.put("Synthesis"," ORAS ");
		tutorMap.put("Role Play"," ORAS ");
		tutorMap.put("Pain Split"," ORAS ");
		tutorMap.put("Gastro Acid"," ORAS ");
		tutorMap.put("Worry Seed"," ORAS ");
		tutorMap.put("Spite"," ORAS ");
		tutorMap.put("After You"," ORAS ");
		tutorMap.put("Helping Hand"," ORAS ");
		tutorMap.put("Trick"," ORAS ");
		tutorMap.put("Recycle"," ORAS ");
		tutorMap.put("Snatch"," ORAS ");
		tutorMap.put("Magic Coat"," ORAS ");
		tutorMap.put("Magnet Rise"," ORAS ");
		tutorMap.put("Iron Defense"," ORAS ");
		tutorMap.put("Heal Bell"," ORAS ");
		tutorMap.put("Tailwind"," ORAS ");
		tutorMap.put("Magic Room"," ORAS ");
		tutorMap.put("Wonder Room"," ORAS ");
		tutorMap.put("Stealth ORAS"," ORAS ");
		tutorMap.put("Gravity"," ORAS ");
		tutorMap.put("Electroweb"," ORAS ");
		tutorMap.put("Icy Wind"," ORAS ");
		tutorMap.put("Frenzy Plant", "XY/ORAS");
		tutorMap.put("Blast Burn","XY/ORAS");
		tutorMap.put("Hydro Cannon","XY/ORAS");
		tutorMap.put("Grass Pledge", "XY/ORAS");
		tutorMap.put("Fire Pledge", "XY/ORAS");
		tutorMap.put("Water Pledge", "XY/ORAS");
		tutorMap.put("Relic Song", "XY/ORAS");
		tutorMap.put("Secret Sword", "XY/ORAS");
		tutorMap.put("Draco Meteor", "XY/ORAS");
		tutorMap.put("Dragon Ascent", "ORAS");
		
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
	    	if(name.equals("Nidoran♀")) name = "nidoranf";
	    	if(name.equals("Nidoran♂")) name = "nidoranm";
	    	if(name.equals("mr.mime")) name = "mrmime";
	    	if(name.equals("mimejr.")) name = "mimejr";
	    	
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
		 
		 try {
			JSONObject j = new JSONObject(result);
			
			JSONArray typePokemon = j.getJSONArray("types");
			
			for(int i = 0; i < typePokemon.length(); i++)
			{
				setTypes(typePokemon.getString(i));
			}
			
			JSONArray breedingGroup = j.getJSONArray("eggGroup");
			
			for(int i = 0; i < breedingGroup.length(); i++)
			{
				setEggGroups(breedingGroup.getString(i));
			}
			
			JSONArray stats = j.getJSONArray("stats");
			
			setStats(stats.getInt(0),
					stats.getInt(1),
					stats.getInt(2),
					stats.getInt(3),
					stats.getInt(4),
					stats.getInt(5));
			
			JSONArray moveList = j.getJSONArray("moveList");
			
			pokedexNumber = j.getString("pokedexNumber");
			levelingRate = j.getString("levelingRate");
			height = j.getString("height");
			weight = j.getString("weight");
			hatchTime = j.getString("hatchTime");
			
			JSONArray orasmovelist = j.getJSONArray("ORASMoveList");
			
			
			
			levelArray = new String[moveList.length()];
			levelMoveArray = new String[moveList.length()];
			levelTypeArray = new String[moveList.length()];
			
			ORASLevelArray = new String[orasmovelist.length()];
			ORASMoveArray = new String[orasmovelist.length()];
			ORASTypeArray = new String[orasmovelist.length()];
			
			JSONArray pre = j.getJSONArray("preEvolution");
			JSONArray post = j.getJSONArray("evolutionPokémon");
			JSONArray evo = j.getJSONArray("evolutionType");
			
			JSONArray tmMoveList = j.getJSONArray("tmMoveList");

			JSONArray hmMoveList = j.getJSONArray("hmMoveList");
			
			tmArray = new String[tmMoveList.length()+hmMoveList.length()];
			tmArrayTypes = new String[tmMoveList.length()+hmMoveList.length()];
			tmArrayMoves = new String[tmMoveList.length()+hmMoveList.length()];
			
			JSONArray ORASTMMoveList = j.getJSONArray("ORASTMMoveList");

			JSONArray ORASHMMoveList = j.getJSONArray("ORASHMMoveList");
			
			ORASTMArray = new String[ORASTMMoveList.length()+ORASHMMoveList.length()];
			ORASTMMoveArray = new String[ORASTMMoveList.length()+ORASHMMoveList.length()];
			ORASTMTypeArray = new String[ORASTMMoveList.length()+ORASHMMoveList.length()];
			
			tmArray = new String[tmMoveList.length()+hmMoveList.length()];
			tmArrayTypes = new String[tmMoveList.length()+hmMoveList.length()];
			tmArrayMoves = new String[tmMoveList.length()+hmMoveList.length()];
			
			JSONArray breedMoveList = j.getJSONArray("breedMoveList");
			
			breedingMoves = new String[breedMoveList.length()];
			breedType = new String[breedMoveList.length()];
			
			JSONArray tutorMoves = j.getJSONArray("tutorMoveList");
			
			tutorArray = new String[tutorMoves.length()];
			tutorType = new String[tutorMoves.length()];
			tutorGame = new String[tutorMoves.length()];
			
			JSONArray abilities2 = j.getJSONArray("abilities");
			
			
			for(int i = 0; i < abilities2.length(); i++)
			{
				abilities.add(abilities2.getString(i));
			}
			
			for(int i = 0; i < tutorMoves.length(); i++)
			{
				String idx = tutorMoves.getString(i);
				tutorArray[i] = idx;
				tutorType[i] = tutorMap.get(idx);
				tutorGame[i] = tutorGameMap.get(idx);
			}
			
			JSONArray Xlocations = j.getJSONArray("XLocations");
			XlocationTypeArray = new String[Xlocations.length()];
			
			JSONArray EV = j.getJSONArray("evYield");
			evYield = new String[EV.length()];
			for(int i = 0; i < evYield.length; i++)
			{
				evYield[i] = EV.getString(i);
			}
			
			
			
			
			XlocationMap = new HashMap<String,String[]>();
			
			for(int i = 0; i < Xlocations.length(); i++)
			{
				try{
					
					JSONObject oneObject = Xlocations.getJSONObject(i);
					
					String locationType = oneObject.getString("locationtype");
					
					XlocationTypeArray[i] = locationType;
					
					JSONArray location = oneObject.getJSONArray("location");
					XlocationArray = new String[location.length()];
					
					for(int z = 0; z < location.length(); z++)
					{
						XlocationArray[z] = location.getString(z);
					}
					
					XlocationMap.put(locationType, XlocationArray);
					
				}catch (JSONException e){
					
				}
			}
			
			JSONArray YLocations = j.getJSONArray("YLocations");
			YlocationTypeArray = new String[YLocations.length()];
			
			YlocationMap = new HashMap<String,String[]>();
			
			for(int i = 0; i < YLocations.length(); i++)
			{
				try{
					
					JSONObject oneObject = YLocations.getJSONObject(i);
					
					String locationType = oneObject.getString("locationtype");
					
					YlocationTypeArray[i] = locationType;
					
					JSONArray location = oneObject.getJSONArray("location");
					YlocationArray = new String[location.length()];
					
					for(int z = 0; z < location.length(); z++)
					{
						YlocationArray[z] = location.getString(z);
					}
					
					YlocationMap.put(locationType, YlocationArray);
					
				}catch (JSONException e){
					
				}
			}
			
			JSONArray ORLocations = j.getJSONArray("ORLocations");
			ORlocationTypeArray = new String[ORLocations.length()];
			
			ORlocationMap = new HashMap<String,String[]>();
			
			for(int i = 0; i < ORLocations.length(); i++)
			{
				try{
					
					JSONObject oneObject = ORLocations.getJSONObject(i);
					
					String locationType = oneObject.getString("locationtype");
					
					ORlocationTypeArray[i] = locationType;
					
					JSONArray location = oneObject.getJSONArray("location");
					ORlocationArray = new String[location.length()];
					
					for(int z = 0; z < location.length(); z++)
					{
						ORlocationArray[z] = location.getString(z);
					}
					
					ORlocationMap.put(locationType, ORlocationArray);
					
				}catch (JSONException e){
					
				}
			}
			
			JSONArray ASLocations = j.getJSONArray("ASLocations");
			ASlocationTypeArray = new String[ASLocations.length()];
			
			ASlocationMap = new HashMap<String,String[]>();
			
			for(int i = 0; i < ASLocations.length(); i++)
			{
				try{
					
					JSONObject oneObject = ASLocations.getJSONObject(i);
					
					String locationType = oneObject.getString("locationtype");
					
					ASlocationTypeArray[i] = locationType;
					
					JSONArray location = oneObject.getJSONArray("location");
					ASlocationArray = new String[location.length()];
					
					for(int z = 0; z < location.length(); z++)
					{
						ASlocationArray[z] = location.getString(z);
					}
					
					ASlocationMap.put(locationType, ASlocationArray);
					
				}catch (JSONException e){
					
				}
			}
			
			for (int i=0; i < moveList.length(); i++)
			{
			    try {
			        JSONObject oneObject = moveList.getJSONObject(i);

			        // Pulling items from the array
			        int lev = oneObject.getInt("level");
			        levelArray[i] = " "+lev;
			        String mo = oneObject.getString("move");
			        levelMoveArray[i] = mo;
			        String ty = oneObject.getString("type");
			        levelTypeArray[i] = ty;
			        
			        
			        
			    } catch (JSONException e) {
			        // Oops
			    }    
			}
			
			for (int i=0; i < orasmovelist.length(); i++)
			{
			    try {
			        JSONObject oneObject = orasmovelist.getJSONObject(i);

			        // Pulling items from the array
			        int lev = oneObject.getInt("level");
			        ORASLevelArray[i] = " "+lev;
			        String mo = oneObject.getString("move");
			        ORASMoveArray[i] = mo;
			        String ty = oneObject.getString("type");
			        ORASTypeArray[i] = ty;
			        
			        
			        
			    } catch (JSONException e) {
			        // Oops
			    }    
			}
			
			
			
			for (int i=0; i < tmMoveList.length(); i++)
			{
			    try {
			        JSONObject oneObject = tmMoveList.getJSONObject(i);
			        // Pulling items from the array
			        String tm = oneObject.getString("tm");
			        tmArray[i] = " "+tm;
			        String mo = oneObject.getString("move");
			        tmArrayMoves[i] = mo;
			        String ty = oneObject.getString("type");
			        tmArrayTypes[i] = ty;
			    } catch (JSONException e) {
			        // Oops
			    }
			}
			
			for (int i=0; i < hmMoveList.length(); i++)
			{
			    try {
			        JSONObject oneObject = hmMoveList.getJSONObject(i);
			        // Pulling items from the array
			        String tm = oneObject.getString("hm");
			        tmArray[tmMoveList.length()+i] = " "+tm;
			        
			        String mo = oneObject.getString("move");
			        tmArrayMoves[tmMoveList.length()+i] = mo;
			        
			        String ty = oneObject.getString("type");
			        tmArrayTypes[tmMoveList.length()+i] = ty;
			    } catch (JSONException e) {
			        // Oops
			    }
			}
			
			for (int i=0; i < ORASTMMoveList.length(); i++)
			{
			    try {
			        JSONObject oneObject = ORASTMMoveList.getJSONObject(i);
			        // Pulling items from the array
			        String tm = oneObject.getString("tm");
			        ORASTMArray[i] = " "+tm;
			        String mo = oneObject.getString("move");
			        ORASTMMoveArray[i] = mo;
			        String ty = oneObject.getString("type");
			        ORASTMTypeArray[i] = ty;
			    } catch (JSONException e) {
			        // Oops
			    }
			}
			
			for (int i=0; i < ORASHMMoveList.length(); i++)
			{
			    try {
			        JSONObject oneObject = ORASHMMoveList.getJSONObject(i);
			        // Pulling items from the array
			        String tm = oneObject.getString("hm");
			        ORASTMArray[tmMoveList.length()+i] = " "+tm;
			        
			        String mo = oneObject.getString("move");
			        ORASTMMoveArray[tmMoveList.length()+i] = mo;
			        
			        String ty = oneObject.getString("type");
			        ORASTMTypeArray[tmMoveList.length()+i] = ty;
			    } catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < pre.length(); i++)
			{
				try{
					JSONObject oneObject = pre.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	preevolution.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < post.length(); i++)
			{
				try{
					JSONObject oneObject = post.getJSONObject(i);
		        	String x = oneObject.getString("pokemonName");
		        	postevolution.add(x);
				}catch (JSONException e) {
			        // Oops
			    }
			}
			
			for(int i = 0; i < evo.length(); i++){
				evolutionType.add(evo.getString(i));
			}
			
			for (int i=0; i < breedMoveList.length(); i++)
			{
			    try {
			        JSONObject oneObject = breedMoveList.getJSONObject(i);
			        // Pulling items from the array
			        String mo = oneObject.getString("move");
			        breedingMoves[i] = mo;
			        
			        String ty = oneObject.getString("type");
			        breedType[i] = ty;
			        
			        JSONArray pokemonArray = oneObject.getJSONArray("pokemon");
			        
			        pA = new ArrayList<String>();
			        
			        
			        for(int z = 0; z < pokemonArray.length(); z++)
			        {
			        	JSONObject pokemonList = pokemonArray.getJSONObject(z);
			        	String x = pokemonList.getString("pokemonName");
			        	pA.add(x);
			        }
			        
			        listOfPokemonArray.add(pA);
			    } catch (JSONException e) {
			        // Oops
			    }
			}
			
			
			for(int i = 0; i < tutorMoves.length(); i++)
			{
				setTutorMoves(tutorMoves.getString(i));
			}
			
			JSONArray sets = j.getJSONArray("sets");
			setName = new String[sets.length()];
			ability = new String[sets.length()];
			cc = new String[sets.length()];
			damc = new String[sets.length()];
			setEx = new String[sets.length()];
			pokemonList = new String[sets.length()];
			
			setCheck = j.getString("setCheck");
			
			for(int i = 0; i < sets.length(); i++)
			{
				try{
					JSONObject oneObject = sets.getJSONObject(i);
		        	String x = oneObject.getString("name");
		        	setName[i] = x;
		        	
		        	String y = oneObject.getString("ability");
		        	ability[i] = y;
		        	
		        	JSONArray itemArray = oneObject.getJSONArray("items");
		        	items = new ArrayList<String>();
		        	for(int j1 = 0; j1 < itemArray.length(); j1++)
		        	{
		        		items.add(itemArray.getString(j1));
		        	}
		        	allItems.add(items);
		        	
		        	JSONArray moveArray = oneObject.getJSONArray("moves");
		        	moves = new ArrayList<String>();
		        	for(int j1 = 0; j1 < moveArray.length(); j1++)
		        	{
		        		moves.add(moveArray.getString(j1));
		        	}
		        	allMoves.add(moves);
		        	
		        	JSONArray alternative = oneObject.getJSONArray("alternativemoves");
		        	alternativeMoves = new ArrayList<String>();
		        	for(int j1 = 0; j1 < alternative.length(); j1++)
		        	{
		        		alternativeMoves.add(alternative.getString(j1));
		        	}
		        	allAlternativeMoves.add(alternativeMoves);
		        	
		        	JSONArray naturesArray = oneObject.getJSONArray("nature");
		        	natures = new ArrayList<String>();
		        	for(int j1 = 0; j1 < naturesArray.length(); j1++)
		        	{
		        		natures.add(naturesArray.getString(j1));
		        	}
		        	allNatures.add(natures);
		        	
		        	JSONArray evArray = oneObject.getJSONArray("evs");
		        	ev = new ArrayList<String>();
		        	for(int j1 = 0; j1 < evArray.length(); j1++)
		        	{
		        		ev.add(evArray.getString(j1));
		        	}
		        	allEV.add(ev);
		        	
		        	String ex = oneObject.getString("setexplanation");
		        	setEx[i] = ex;
		        	
		        	String c = oneObject.getString("checksandcounters");
		        	cc[i] = c;
		        	
		        	
		        	pokemon = oneObject.getString("damagecalc");
		        	pokemonList[i] = pokemon;
		        	
		        	
				}catch (JSONException e) {
					e.printStackTrace();
			    }
			}
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setTypes(String typePokemon1)
	{
		if (types[0].isEmpty()) types[0] = typePokemon1;
		
		else if (!typePokemon1.isEmpty()) types[1] = typePokemon1;
	}
	
	public String[] getPokemonList()
	{
		return pokemonList;
	}
	
	public void setEggGroups(String egg)
	{
		if (breedGroup[0].isEmpty()) breedGroup[0] = egg;
		
		
		
		else if (!egg.isEmpty()) breedGroup[1] = egg;
	}
	
	public String[] getTypes()
	{
		return types;
	}
	
	public String[] getTutorGame()
	{
		return tutorGame;
	}
	
	public String getType1()
	{
		return types[0];
	}
	
	public String[] getXLocationTypeArray()
	{
		return XlocationTypeArray;
	}
	
	public HashMap<String,String[]> getXLocationMap()
	{
		return XlocationMap;
	}
	
	public String[] getYLocationTypeArray()
	{
		return YlocationTypeArray;
	}
	
	public HashMap<String,String[]> getYLocationMap()
	{
		return YlocationMap;
	}
	
	public String[] getORLocationTypeArray()
	{
		return ORlocationTypeArray;
	}
	
	public HashMap<String,String[]> getORLocationMap()
	{
		return ORlocationMap;
	}
	
	public String[] getASLocationTypeArray()
	{
		return ASlocationTypeArray;
	}
	
	public HashMap<String,String[]> getASLocationMap()
	{
		return ASlocationMap;
	}
	
	public String[] getTutorMoves()
	{
		return tutorArray;
	}
	
	public String[] getTutorTypes()
	{
		return tutorType;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String[] getLevelArray()
	{
		return levelArray; 
	}
	
	public String[] getLevelMoveArray()
	{
		return levelMoveArray;
	}
	
	public String[] getLevelTypeArray()
	{
		return levelTypeArray;
	}
	
	public String[] getORASlevel()
	{
		return ORASLevelArray; 
	}
	
	public String[] getORASMove()
	{
		return ORASMoveArray;
	}
	
	public String[] getORASType()
	{
		return ORASTypeArray
				;
	}
	
	public String[] getTMArray()
	{
		return tmArray;
	}
	
	public String[] getTMMoveArray()
	{
		return tmArrayMoves;
	}
	
	public String[] getTMTypeArray()
	{
		return tmArrayTypes;
	}
	
	public String[] getBreedMoves()
	{
		return breedingMoves;
	}
	
	public ArrayList<ArrayList<String>> getPokemonArray()
	{
		return listOfPokemonArray;
	}
	
	public String[] getSetNames()
	{
		return setName;
	}
	
	public String[] getAbility()
	{
		return ability;
	}
	
	public String[] getSetExplanation()
	{
		return setEx;
	}
	
	public String[] getChecksandCounters()
	{
		return cc;
	}
	
	public ArrayList<ArrayList<String>> getItemArray()
	{
		return allItems;
	}
	
	public ArrayList<String> getPreEvolutions(){
		return preevolution;
	}
	
	public ArrayList<String> getPostEvolutions(){
		return postevolution;
	}
	
	public ArrayList<String> getEvolutionType(){
		return evolutionType;
	}
	
	public ArrayList<ArrayList<String>> getMovesArray()
	{
		return allMoves;
	}

	public ArrayList<ArrayList<String>> getEVArray()
	{
		return allEV;
	}
	
	public ArrayList<ArrayList<String>> getNaturesArray()
	{
		return allNatures;
	}
	
	public ArrayList<ArrayList<String>> getAlternativeMoves()
	{
		return allAlternativeMoves;
	}
	
	public void setTutorMoves(String m)
	{
		tutorMoves.add(m);
	}
	
	public void setStats (int h,int a,int d, int sa, int sd, int s)
	{
		hp = h;
		att = a;
		def = d;
		spa = sa;
		spd = sd;
		spe = s;
	}
	
	public int[] getStats()
	{
		int[] stats = {hp,att,def,spa,spd,spe};
		return stats;
	}
	
	public String getPokedexNumber()
	{
		return pokedexNumber;
	}
	
	public String getHatchTime()
	{
		return hatchTime;
	}
	
	public String getLevelingRate()
	{
		return levelingRate;
	}
	
	public String getHeight()
	{
		return height;
	}
	
	public String getWeight()
	{
		return weight;
	}
	
	public String[] getEVYield()
	{
		return evYield;
	}
	
	public String[] getORASTMArray()
	{
		return ORASTMArray;
	}
	
	public String[] getORASTMMove()
	{
		return ORASTMMoveArray;
	}
	
	public String[] getORASTMType()
	{
		return ORASTMTypeArray;
	}
	
	public String getCheck()
	{
		return setCheck;
	}
	
	public ArrayList<String> getAbilities()
	{
		return abilities;
	}

	public String[] getBreedTypes()
	{
		return breedType;
	}

	public String[] getBreedGroups() {
		return breedGroup;
	}

}
