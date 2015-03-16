package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Sets extends Fragment {
	
	Context ctx;
	String name;
	String[] strengths;
	String[] weaknesses;
	ListView setsButtons;
	TextView text;
	TextView strengthsTV;
	TextView weaknessesTV;
	TextView sets;
	ListView strengthsLV;
	ListView weaknessesLV;
	
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle bundle){
		View rootView = inflater.inflate(R.layout.sets_overview, container,false);
		
		ctx = getActivity().getApplicationContext(); 
		
		bundle = getActivity().getIntent().getExtras();
		name = bundle.getString("name");
		
		setsButtons = (ListView) rootView.findViewById(R.id.set_listView);
		strengthsTV = (TextView) rootView.findViewById(R.id.strengths);
		weaknessesTV = (TextView) rootView.findViewById(R.id.weaknesses);
		sets = (TextView) rootView.findViewById(R.id.sets_title);
		strengthsLV = (ListView) rootView.findViewById(R.id.strengthsLV);
		weaknessesLV = (ListView) rootView.findViewById(R.id.weaknessesLV);
		text = (TextView) rootView.findViewById(R.id.exceptionCase);
		text.setVisibility(View.GONE);
		
		Pokemon pokemon2 = new Pokemon (ctx,name);
		String setCheck = pokemon2.getCheck();
		
		if(setCheck.equals("0")){
			setsButtons.setVisibility(View.GONE);
			strengthsLV.setVisibility(View.GONE);
			weaknessesLV.setVisibility(View.GONE);
			strengthsTV.setVisibility(View.GONE);
			sets.setVisibility(View.GONE);
			weaknessesTV.setVisibility(View.GONE);
			text.setVisibility(View.VISIBLE);
		}
		else
		{
			ParseSetOverview overview = new ParseSetOverview(ctx,name);
			
			strengths = overview.getStrengths();
			weaknesses = overview.getWeaknesses();
			
			LocationsListAdapter l = new LocationsListAdapter(strengths,ctx);
			strengthsLV.setAdapter(l);
			
			LocationsListAdapter l2 = new LocationsListAdapter(weaknesses,ctx);
			weaknessesLV.setAdapter(l2);
			
			
			
			Pokemon pokemon = new Pokemon (ctx,name);
			String[] setNames = pokemon.getSetNames();
			
			ArrayAdapter<String> itemsAdapter = 
				    new ArrayAdapter<String>(ctx, 
				    		android.R.layout.simple_list_item_1, setNames);
			setsButtons.setAdapter(itemsAdapter);
			
			ViewGroup.LayoutParams params = setsButtons.getLayoutParams();
		    params.height = setNames.length*90;
		    setsButtons.setLayoutParams(params);
		    setsButtons.requestLayout();
		    
		    params = strengthsLV.getLayoutParams();
		    params.height = strengths.length*55;
		    strengthsLV.setLayoutParams(params);
		    strengthsLV.requestLayout();
		    
		    params = weaknessesLV.getLayoutParams();
		    params.height = weaknesses.length*55;
		    weaknessesLV.setLayoutParams(params);
		    weaknessesLV.requestLayout();
		    
		    setsButtons.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					Intent intent = new Intent(ctx,SpecificSet.class);
					intent.putExtra("position", position);
					intent.putExtra("name", name);
					startActivity(intent);
				}
		    	
		    });
		}
		
		
		return rootView;
	}

}
