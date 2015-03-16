package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class ButtonTabs extends Fragment {
	
	ListView list;
	Context ctx;
	Intent intent;
	View rootView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup
			container, Bundle bundle)
	{
		rootView = inflater.inflate(R.layout.stat_training, container,false);
		ctx = getActivity();
		
		String[] statTrainingArray = { "Hidden Power Calculator (With IV's)", "Hidden Power Calculator (No IV's)", "IV Calculator" };
		
		list = (ListView) rootView.findViewById(R.id.statTrainingLV);
		
		StatTrainingAdapter adapter = new StatTrainingAdapter(ctx,statTrainingArray);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(position == 0) intent = new Intent(ctx,HiddenPowerCalculator.class);
				if(position == 1) intent = new Intent (ctx,HiddenPower.class);
				if(position == 2) intent = new Intent(ctx,IVCalculator.class);
				
				startActivity(intent);
				
			}
			
		});
		
		return rootView;
		
	}

}
