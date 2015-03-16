package com.ashwin.competitivepokemon;

import com.ashwin.competitivepokemon.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Abilities extends Fragment {
	
	View rootView;
	Context ctx;
	String name;
	AbilitiesJSON ability;
	TextView nametv;
	TextView summarytv;
	TextView viabilitytv;
	String temp;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle bundle)
	{
		super.onCreate(bundle);
		rootView = inflater.inflate(R.layout.abilities_screen, container,false);
        ctx = getActivity().getApplicationContext();
        
        bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name");
        temp = name;
        
        ability = new AbilitiesJSON (ctx,name);
        
        nametv = (TextView) rootView.findViewById(R.id.ability_name);
        summarytv = (TextView) rootView.findViewById(R.id.ability_summary_name);
        viabilitytv = (TextView) rootView.findViewById(R.id.viability_summary);
        
        setTexts();
        
        return rootView;
	}
	
	public void setTexts()
	{
		nametv.setText(temp);
		summarytv.setText(ability.getSummery());
		viabilitytv.setText(ability.getViability());
	}

}
