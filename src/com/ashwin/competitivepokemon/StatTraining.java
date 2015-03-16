package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class StatTraining extends Fragment {
	
	String[] statTrainingArray;
	ListView list;
	Context ctx;
	Intent intent;
	
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle bundle){
		
		View rootView = inflater.inflate(R.layout.stat_training, container,false);
		
		ctx = getActivity().getBaseContext();
		
		statTrainingArray = getActivity().getResources().getStringArray(R.array.stat_training);
		
		list = (ListView) rootView.findViewById(R.id.statTrainingLV);
		
		StatTrainingAdapter adapter = new StatTrainingAdapter(ctx,statTrainingArray);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(position == 0) intent = new Intent (ctx,EVTraining.class);
				else if(position == 1) intent = new Intent(ctx,IVtraining.class);
				else intent = new Intent (ctx,Natures.class);
				
				startActivity(intent);
				
			}
			
		});
		
		return rootView;
		
		
		
	}

}
