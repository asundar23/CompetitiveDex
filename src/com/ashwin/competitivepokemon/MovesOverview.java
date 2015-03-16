package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MovesOverview extends Fragment{
	
	MovesJSON move;
	Context ctx;
	String name;
	View rootView;
	TextView nametv;
	TextView typetv;
	TextView powertv;
	TextView accuracytv;
	TextView summarytv;
	TextView viabilitytv;
	TextView categorytv;
	TextView pptv;
	int[] backgroundColors;
	String temp;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
	{
		rootView = inflater.inflate(R.layout.moves_screen, container, false);
		
		ctx = getActivity().getApplicationContext();
		bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name");
        temp = name;
        
        move = new MovesJSON(ctx,name);
        
        nametv = (TextView) rootView.findViewById(R.id.moveTextView);
        typetv = (TextView) rootView.findViewById(R.id.moveTypeTextView);
        powertv = (TextView) rootView.findViewById(R.id.movePowerNumber);
        accuracytv = (TextView) rootView.findViewById(R.id.moveAccuracyNumber);
        summarytv = (TextView) rootView.findViewById(R.id.moveSummaryDesc);
        viabilitytv = (TextView) rootView.findViewById(R.id.viabilitySummary);
        categorytv = (TextView) rootView.findViewById(R.id.moveCategoryNumber);
        pptv = (TextView) rootView.findViewById(R.id.movePPNumber);
        
        
        
        backgroundColors = getActivity().getResources().getIntArray(R.array.typeArray);
        
        setTextViews();
		
		return rootView;
	}
	
	public void setTextViews()
	{
		nametv.setText(temp);
		typetv.setText(move.getType());
		powertv.setText(move.getPower());
		accuracytv.setText(move.getAccuracy());
		summarytv.setText(move.getSummary());
		viabilitytv.setText(move.getViability());
		categorytv.setText(move.getCategory());
		pptv.setText(move.getPP());
		
		
		if(move.getType().equals(" Bug ")) typetv.setBackgroundColor(backgroundColors[0]);
        if(move.getType().equals(" Dark ")) typetv.setBackgroundColor(backgroundColors[1]);
        if(move.getType().equals(" Dragon ")) typetv.setBackgroundColor(backgroundColors[2]);
        if(move.getType().equals(" Electric ")) typetv.setBackgroundColor(backgroundColors[3]);
        if(move.getType().equals(" Fairy ")) typetv.setBackgroundColor(backgroundColors[4]);
        if(move.getType().equals(" Fighting ")) typetv.setBackgroundColor(backgroundColors[5]);
        {
        	
        }
        if(move.getType().equals(" Fire ")) typetv.setBackgroundColor(backgroundColors[6]);
        if(move.getType().equals(" Flying ")) typetv.setBackgroundColor(backgroundColors[7]);
        if(move.getType().equals(" Ghost ")) typetv.setBackgroundColor(backgroundColors[8]);
        if(move.getType().equals(" Grass ")) typetv.setBackgroundColor(backgroundColors[9]);
        if(move.getType().equals(" Ground ")) typetv.setBackgroundColor(backgroundColors[10]);
        if(move.getType().equals(" Ice ")) typetv.setBackgroundColor(backgroundColors[11]);
        if(move.getType().equals(" Normal ")) typetv.setBackgroundColor(backgroundColors[12]);
        if(move.getType().equals(" Poison ")) typetv.setBackgroundColor(backgroundColors[13]);
        if(move.getType().equals(" Psychic ")) typetv.setBackgroundColor(backgroundColors[14]);
        if(move.getType().equals(" Rock ")) typetv.setBackgroundColor(backgroundColors[15]);
        if(move.getType().equals(" Steel ")) typetv.setBackgroundColor(backgroundColors[16]);
        if(move.getType().equals(" Water ")) typetv.setBackgroundColor(backgroundColors[17]);
	}

}
