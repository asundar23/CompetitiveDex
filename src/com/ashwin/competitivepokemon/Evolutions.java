package com.ashwin.competitivepokemon;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.ashwin.competitivepokemon.R;



public class Evolutions extends Fragment {
	
	ListView list;
	String name;
	Context ctx;
	TextView t;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		
		View rootView = inflater.inflate(R.layout.list_view, container,false);
		
		ctx = getActivity().getApplicationContext();
		
		list = (ListView) rootView.findViewById(R.id.evolutionLV);
		t = (TextView) rootView.findViewById(R.id.exception);
		
		t.setVisibility(View.GONE);
		
		bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name");
        
        Pokemon pokemon = new Pokemon(ctx,name);
        
        if(pokemon.getEvolutionType().size() > 0){
        	EvolutionAdapter adapter = new EvolutionAdapter(ctx,name);
            list.setAdapter(adapter);
        }
        else
        {
        	list.setVisibility(View.GONE);
        	t.setVisibility(View.VISIBLE);
        }
        
		return rootView;
		
	}

}
