package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


public class Chart extends Fragment {
	
	Spinner spinner;
	ImageView image;
	View rootView;
	Context ctx;
	String x;
	
	public View onCreateView(Bundle bundle,LayoutInflater inflater, ViewGroup container){
		
		rootView = inflater.inflate(R.layout.typechart, container,false);
		
		String[] array = {
				"Bug",
				"Dark",
				"Dragon",
				"Electric",
				"Fairy",
				"Fighting",
				"Fire",
				"Flying",
				"Ghost",
				"Grass",
				"Ground",
				"Ice",
				"Normal",
				"Poison",
				"Psychic",
				"Rock",
				"Steel",
				"Water"
		};
		
		ctx = getActivity().getBaseContext();
		
		spinner = (Spinner) rootView.findViewById(R.id.typeSpinner);
		image = (ImageView) rootView.findViewById(R.id.typeImage);
		
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, array); //selected item will look like a spinner set from XML
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(spinnerArrayAdapter);
		
		spinnerItemsSelected();
		
		return rootView;
	}

	private void spinnerItemsSelected() {

		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
		
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(String.valueOf(spinner.getSelectedItem()).equals("Bug")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.bug));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Dark")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.dark));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Dragon")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.dragon));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Electric")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.electric));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Fire")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.fire));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Fighting")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.fighting));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Flying")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.flying));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Ghost")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.ghost));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Grass")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.grass));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Ground")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.ground));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Ice")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.ice));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Normal")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.normal));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Poison")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.poison));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Steel")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.steel));
				}
				else if(String.valueOf(spinner.getSelectedItem()).equals("Water")){
					image.setImageDrawable(getResources().getDrawable(R.drawable.water));
				}
				else
				{
					image.setImageDrawable(getResources().getDrawable(R.drawable.bug));
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}
