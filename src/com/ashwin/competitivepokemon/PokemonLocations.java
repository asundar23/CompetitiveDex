package com.ashwin.competitivepokemon;

import java.util.HashMap;
import com.ashwin.competitivepokemon.R;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;



public class PokemonLocations extends Fragment
{
	View rootView;
	Context ctx;
	String name;
	String temp;
	
	String[] routesListArray;
	String[] cityListArray;
	String[] otherListArray;
	
	String[] XlocationTypeArray;
	String[] XlocationArray;
	HashMap<String,String[]> XlocationMap;
	
	String[] YlocationTypeArray;
	String[] YlocationArray;
	HashMap<String,String[]> YlocationMap;
	
	String[] ORlocationTypeArray;
	String[] ORlocationArray;
	HashMap<String,String[]> ORlocationMap;
	
	String[] ASlocationTypeArray;
	String[] ASlocationArray;
	HashMap<String,String[]> ASlocationMap;
	
	Button x;
	Button y;
	Button or;
	Button as;
	
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle bundle)
	{
		super.onCreate(bundle);
		View rootView = inflater.inflate(R.layout.location, container,false);
		
		ctx = getActivity().getApplicationContext();
		
		bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name"); 
		
        
        x = (Button) rootView.findViewById(R.id.button1);
        y = (Button) rootView.findViewById(R.id.button2);
        or = (Button) rootView.findViewById(R.id.button3);
        as = (Button) rootView.findViewById(R.id.button4);
        
        Pokemon pokemon = new Pokemon(ctx,name);
        
        XlocationMap = new HashMap<String,String[]>();
        XlocationTypeArray = pokemon.getXLocationTypeArray();
        XlocationMap = pokemon.getXLocationMap();
        
        YlocationMap = new HashMap<String,String[]>();
        YlocationTypeArray = pokemon.getYLocationTypeArray();
        YlocationMap = pokemon.getYLocationMap();
        
        ORlocationMap = new HashMap<String,String[]>();
        ORlocationTypeArray = pokemon.getORLocationTypeArray();
        ORlocationMap = pokemon.getORLocationMap();
        
        ASlocationMap = new HashMap<String,String[]>();
        ASlocationTypeArray = pokemon.getASLocationTypeArray();
        ASlocationMap = pokemon.getASLocationMap();
		
        setOnClickListeners();
        
        return rootView;
	}

	private void setOnClickListeners() {
		// TODO Auto-generated method stub
		x.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
			
				LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(
					    Context.LAYOUT_INFLATER_SERVICE);
				
				View view = inflater.inflate( R.layout.location_popup, null );
				
				ListView routesListView = (ListView) view.findViewById(R.id.route_list);
				ListView cityListView = (ListView) view.findViewById(R.id.city_list);
				ListView otherListView = (ListView) view.findViewById(R.id.other_list);
				
				for(int i = 0; i < XlocationTypeArray.length; i++)
				{
					if(XlocationTypeArray[i].equals("Route"))
					{
						routesListArray = new String[XlocationMap.get(XlocationTypeArray[i]).length];
						routesListArray = XlocationMap.get(XlocationTypeArray[i]);
						LocationsListAdapter adapter = new LocationsListAdapter(routesListArray,ctx);
						routesListView.setAdapter(adapter);
					}
					
					if(XlocationTypeArray[i].equals("City"))
					{
						cityListArray = new String[XlocationMap.get(XlocationTypeArray[i]).length];
						cityListArray = XlocationMap.get(XlocationTypeArray[i]);
						LocationsListAdapter adapter2 = new LocationsListAdapter(cityListArray,ctx);
						cityListView.setAdapter(adapter2);
					}
					
					if(XlocationTypeArray[i].equals("Other"))
					{
						otherListArray = new String[XlocationMap.get(XlocationTypeArray[i]).length];
						otherListArray = XlocationMap.get(XlocationTypeArray[i]);
						LocationsListAdapter adapter3 = new LocationsListAdapter(otherListArray,ctx);
						otherListView.setAdapter(adapter3);
					}
				}
				
				ViewGroup.LayoutParams params = routesListView.getLayoutParams();
			    params.height = routesListArray.length*60;
			    routesListView.setLayoutParams(params);
			    routesListView.requestLayout();
			    
			    params = cityListView.getLayoutParams();
			    params.height = cityListArray.length*60;
			    cityListView.setLayoutParams(params);
			    cityListView.requestLayout();
			    
			    params = otherListView.getLayoutParams();
			    params.height = otherListArray.length*60;
			    otherListView.setLayoutParams(params);
			    otherListView.requestLayout();
			    
			
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setView(view);
				builder.show();
				
			}
			
		});
		
		y.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(
					    Context.LAYOUT_INFLATER_SERVICE);
				
				View view = inflater.inflate( R.layout.location_popup, null );
				
				ListView routesListView = (ListView) view.findViewById(R.id.route_list);
				ListView cityListView = (ListView) view.findViewById(R.id.city_list);
				ListView otherListView = (ListView) view.findViewById(R.id.other_list);
				
				for(int i = 0; i < YlocationTypeArray.length; i++)
				{
					if(YlocationTypeArray[i].equals("Route"))
					{
						routesListArray = new String[YlocationMap.get(YlocationTypeArray[i]).length];
						routesListArray = YlocationMap.get(YlocationTypeArray[i]);
						LocationsListAdapter adapter = new LocationsListAdapter(routesListArray,ctx);
						routesListView.setAdapter(adapter);
					}
					
					if(YlocationTypeArray[i].equals("City"))
					{
						cityListArray = new String[YlocationMap.get(YlocationTypeArray[i]).length];
						cityListArray = YlocationMap.get(YlocationTypeArray[i]);
						LocationsListAdapter adapter2 = new LocationsListAdapter(cityListArray,ctx);
						cityListView.setAdapter(adapter2);
					}
					
					if(YlocationTypeArray[i].equals("Other"))
					{
						otherListArray = new String[YlocationMap.get(YlocationTypeArray[i]).length];
						otherListArray = YlocationMap.get(YlocationTypeArray[i]);
						LocationsListAdapter adapter3 = new LocationsListAdapter(otherListArray,ctx);
						otherListView.setAdapter(adapter3);
					}
				}
				
				ViewGroup.LayoutParams params = routesListView.getLayoutParams();
			    params.height = routesListArray.length*60;
			    routesListView.setLayoutParams(params);
			    routesListView.requestLayout();
			    
			    params = cityListView.getLayoutParams();
			    params.height = cityListArray.length*60;
			    cityListView.setLayoutParams(params);
			    cityListView.requestLayout();
			    
			    params = otherListView.getLayoutParams();
			    params.height = otherListArray.length*60;
			    otherListView.setLayoutParams(params);
			    otherListView.requestLayout();
			    
			
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setView(view);
				builder.show();
				
			}
			
		});
		
		or.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(
					    Context.LAYOUT_INFLATER_SERVICE);
				
				View view = inflater.inflate( R.layout.location_popup, null );
				
				ListView routesListView = (ListView) view.findViewById(R.id.route_list);
				ListView cityListView = (ListView) view.findViewById(R.id.city_list);
				ListView otherListView = (ListView) view.findViewById(R.id.other_list);
				
				for(int i = 0; i < ORlocationTypeArray.length; i++)
				{
					if(ORlocationTypeArray[i].equals("Route"))
					{
						routesListArray = new String[ORlocationMap.get(ORlocationTypeArray[i]).length];
						routesListArray = ORlocationMap.get(ORlocationTypeArray[i]);
						LocationsListAdapter adapter = new LocationsListAdapter(routesListArray,ctx);
						routesListView.setAdapter(adapter);
					}
					
					if(ORlocationTypeArray[i].equals("City"))
					{
						cityListArray = new String[ORlocationMap.get(ORlocationTypeArray[i]).length];
						cityListArray = ORlocationMap.get(ORlocationTypeArray[i]);
						LocationsListAdapter adapter2 = new LocationsListAdapter(cityListArray,ctx);
						cityListView.setAdapter(adapter2);
					}
					
					if(ORlocationTypeArray[i].equals("Other"))
					{
						otherListArray = new String[ORlocationMap.get(ORlocationTypeArray[i]).length];
						otherListArray = ORlocationMap.get(ORlocationTypeArray[i]);
						LocationsListAdapter adapter3 = new LocationsListAdapter(otherListArray,ctx);
						otherListView.setAdapter(adapter3);
					}
				}
				
				ViewGroup.LayoutParams params = routesListView.getLayoutParams();
			    params.height = routesListArray.length*60;
			    routesListView.setLayoutParams(params);
			    routesListView.requestLayout();
			    
			    params = cityListView.getLayoutParams();
			    params.height = cityListArray.length*60;
			    cityListView.setLayoutParams(params);
			    cityListView.requestLayout();
			    
			    params = otherListView.getLayoutParams();
			    params.height = otherListArray.length*60;
			    otherListView.setLayoutParams(params);
			    otherListView.requestLayout();
			    
			
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setView(view);
				builder.show();
				
			}
			
		});
		
		as.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(
					    Context.LAYOUT_INFLATER_SERVICE);
				
				View view = inflater.inflate( R.layout.location_popup, null );
				
				ListView routesListView = (ListView) view.findViewById(R.id.route_list);
				ListView cityListView = (ListView) view.findViewById(R.id.city_list);
				ListView otherListView = (ListView) view.findViewById(R.id.other_list);
				
				
				
				for(int i = 0; i < ASlocationTypeArray.length; i++)
				{
					if(ASlocationTypeArray[i].equals("Route"))
					{
						routesListArray = new String[ASlocationMap.get(ASlocationTypeArray[i]).length];
						routesListArray = ASlocationMap.get(ASlocationTypeArray[i]);
						LocationsListAdapter adapter = new LocationsListAdapter(routesListArray,ctx);
						routesListView.setAdapter(adapter);
					}
					
					if(ASlocationTypeArray[i].equals("City"))
					{
						cityListArray = new String[ASlocationMap.get(ASlocationTypeArray[i]).length];
						cityListArray = ASlocationMap.get(ASlocationTypeArray[i]);
						LocationsListAdapter adapter2 = new LocationsListAdapter(cityListArray,ctx);
						cityListView.setAdapter(adapter2);
					}
					
					if(ASlocationTypeArray[i].equals("Other"))
					{
						otherListArray = new String[ASlocationMap.get(ASlocationTypeArray[i]).length];
						otherListArray = ASlocationMap.get(ASlocationTypeArray[i]);
						LocationsListAdapter adapter3 = new LocationsListAdapter(otherListArray,ctx);
						otherListView.setAdapter(adapter3);
					}
				}
				
				ViewGroup.LayoutParams params = routesListView.getLayoutParams();
			    params.height = routesListArray.length*60;
			    routesListView.setLayoutParams(params);
			    routesListView.requestLayout();
			    
			    params = cityListView.getLayoutParams();
			    params.height = cityListArray.length*60;
			    cityListView.setLayoutParams(params);
			    cityListView.requestLayout();
			    
			    params = otherListView.getLayoutParams();
			    params.height = otherListArray.length*60;
			    otherListView.setLayoutParams(params);
			    otherListView.requestLayout();
			    
			    
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setView(view);
				builder.show();
				
			}
			
		});
		
	}
}
