package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class TeamBuilding extends Fragment {
	
	String[] statTrainingArray;
	ListView list;
	Context ctx;
	
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle bundle){
		
		View rootView = inflater.inflate(R.layout.stat_training, container,false);
		
		ctx = getActivity().getBaseContext();
		
		statTrainingArray = getActivity().getResources().getStringArray(R.array.teambuilding);
		
		list = (ListView) rootView.findViewById(R.id.statTrainingLV);
		
		StatTrainingAdapter adapter = new StatTrainingAdapter(ctx,statTrainingArray);
		
		list.setAdapter(adapter);
		
		return rootView;
		
	}

}
