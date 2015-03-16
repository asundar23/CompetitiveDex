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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;


public class MoveDexView extends Fragment{
	
	Spinner typeSpinner;
	Spinner physical_special_Spinner;
	Button submit;
	String[] listMoves;
	String[] listTypeMoves;
	MoveAdapter moveAdapter;
	MoveAdapter newMoveAdapter;
	ListView movedexListView;
	MovedexList mL;
	String[] newList;
	String[] newTypeList;
	boolean isAllMoves = false;
	boolean isAllTypeOfMoves = false;
	String[] powerMoves;
	String[] newPowerMoves;
	String[] accuracyMoves;
	String[] newAccuracyMoves;
	Context ctx;
	
	String[] newList2;
	String[] newTypeList2;
	String[] newPowerMoves2;
	String[] newAccuracyMoves2;
	View rootView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup
			container, Bundle bundle)
	{
		rootView = inflater.inflate(R.layout.movedex_view, container,false);
		ctx = getActivity();
		
		populateListMovesArray(isAllMoves,isAllTypeOfMoves);
		addItemsOnSpinner1();
		addItemsOnSpinner2();
		addListenerOnButton();
		
		return rootView;
	}

	

	private void populateListMovesArray(boolean f,boolean p) {
		if((f==true && p==true) ||
				(f==false && p==true)||
				(f==true && p==false))
		{
			listMoves = newList;
			listTypeMoves = newTypeList;
			powerMoves = newPowerMoves;
			accuracyMoves = newAccuracyMoves;
		}
		
		if(f==false && p==false)
		{
			listMoves = getResources().getStringArray(R.array.moves);
			listTypeMoves = getResources().getStringArray(R.array.type_moves);
			powerMoves = getResources().getStringArray(R.array.all_moves_power);
			accuracyMoves = getResources().getStringArray(R.array.accuracy_all);
		}
		
		//Log.d("tag", "The 500th element of listMoves is " + listMoves[500]);
		//Log.d("tag", "The 500th element of listTypeMoves is " + listTypeMoves[500]);
		
		mL = new MovedexList(listMoves,listTypeMoves,powerMoves,accuracyMoves);
		mL.mapList();
		
		moveAdapter = new MoveAdapter (ctx,listMoves,listTypeMoves,powerMoves,accuracyMoves);
		
		movedexListView = (ListView) rootView.findViewById(R.id.moveListView);
		movedexListView.setAdapter(moveAdapter);
		
		registerOnClickListener();
		
		
	}

	private void registerOnClickListener() {
		movedexListView = (ListView) rootView.findViewById(R.id.moveListView);
		movedexListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(ctx, TabsMoves.class);
				intent.putExtra("name", moveAdapter.getItem(position).toString());
                startActivity(intent);
			}
		});	
	}

	private void addItemsOnSpinner1() {
		typeSpinner = (Spinner) rootView.findViewById(R.id.pokedex_type_spinner);
		CustomSpinnerType typeAdapter = new CustomSpinnerType(ctx);
		typeSpinner.setAdapter(typeAdapter);
		
	}

	private void addItemsOnSpinner2() {
		physical_special_Spinner = (Spinner) rootView.findViewById(R.id.pokedex_pos_spinner);
		ArrayAdapter<CharSequence> physical_special_Adapter = ArrayAdapter.createFromResource(ctx,
		        R.array.pos, android.R.layout.simple_spinner_item);
		
		physical_special_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		physical_special_Spinner.setAdapter(physical_special_Adapter);
		
	}

	private void addListenerOnButton() {
		typeSpinner = (Spinner) rootView.findViewById(R.id.pokedex_type_spinner);
		physical_special_Spinner = (Spinner) rootView.findViewById(R.id.pokedex_pos_spinner);

		
		typeSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if(String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem()).equals("All (Category)"))
				{
					isAllMoves = false;
					isAllTypeOfMoves = false;
				}
				else if(String.valueOf(typeSpinner.getSelectedItem())!=("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem()).equals("All (Category)"))
				{
					
					isAllMoves = true;
					isAllTypeOfMoves = false;
					trueFalse();
				}
				else if(String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem())!=("All (Category)"))
				{
					isAllMoves = false;
					isAllTypeOfMoves = true;
					falseTrue();
				}
				else if(String.valueOf(typeSpinner.getSelectedItem())!=("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem())!=("All (Category)"))
				{
					isAllMoves = true;
					isAllTypeOfMoves = true;
					trueTrue();
				}
				
				populateListMovesArray(isAllMoves,isAllTypeOfMoves);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		physical_special_Spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if(String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem()).equals("All (Category)"))
				{
					isAllMoves = false;
					isAllTypeOfMoves = false;
				}
				else if(String.valueOf(typeSpinner.getSelectedItem())!=("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem()).equals("All (Category)"))
				{
					
					isAllMoves = true;
					isAllTypeOfMoves = false;
					trueFalse();
				}
				else if(String.valueOf(typeSpinner.getSelectedItem()).equals("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem())!=("All (Category)"))
				{
					isAllMoves = false;
					isAllTypeOfMoves = true;
					falseTrue();
				}
				else if(String.valueOf(typeSpinner.getSelectedItem())!=("All (Type)") &&
						String.valueOf(physical_special_Spinner.getSelectedItem())!=("All (Category)"))
				{
					isAllMoves = true;
					isAllTypeOfMoves = true;
					trueTrue();
				}
				
				populateListMovesArray(isAllMoves,isAllTypeOfMoves);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	private void trueTrue() {
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Bug"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.bug_status);
				newTypeList = getResources().getStringArray(R.array.status_type_bug);
				newPowerMoves = getResources().getStringArray(R.array.bug_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.bug_status_accuracy);
				
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.bug_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_bug);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_bug);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damaging_bug);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fire"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.fire_status);
				newTypeList = getResources().getStringArray(R.array.status_type_fire);
				newPowerMoves = getResources().getStringArray(R.array.fire_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.fire_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.fire_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_fire);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_fire);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_fire);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fighting"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.fighting_status);
				newTypeList = getResources().getStringArray(R.array.status_type_fighting);
				newPowerMoves = getResources().getStringArray(R.array.fighting_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.fighting_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.fighting_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_fighting);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_fighting);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_fighting);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Normal"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.normal_status);
				newTypeList = getResources().getStringArray(R.array.status_type_normal);
				newPowerMoves = getResources().getStringArray(R.array.normal_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.normal_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.normal_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_normal);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_normal);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_normal);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Water"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.water_status);
				newTypeList = getResources().getStringArray(R.array.status_type_water);
				newPowerMoves = getResources().getStringArray(R.array.water_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.water_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.water_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_water);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_water);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_water);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fairy"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.fairy_status);
				newTypeList = getResources().getStringArray(R.array.status_type_fairy);
				newPowerMoves = getResources().getStringArray(R.array.fairy_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.fairy_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.fairy_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_fairy);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_fairy);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_fairy);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Poison"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.poison_status);
				newTypeList = getResources().getStringArray(R.array.status_type_poison);
				newPowerMoves = getResources().getStringArray(R.array.poison_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.poison_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.poison_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_poison);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_poison);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_poison);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Steel"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.steel_status);
				newTypeList = getResources().getStringArray(R.array.status_type_steel);
				newPowerMoves = getResources().getStringArray(R.array.steel_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.steel_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.steel_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_steel);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_steel);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_steel);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Rock"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.rock_status);
				newTypeList = getResources().getStringArray(R.array.status_type_rock);
				newPowerMoves = getResources().getStringArray(R.array.rock_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.rock_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.rock_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_rock);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_rock);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_rock);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ground"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.ground_status);
				newTypeList = getResources().getStringArray(R.array.status_type_ground);
				newPowerMoves = getResources().getStringArray(R.array.ground_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.ground_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.ground_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_ground);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_ground);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_ground);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Psychic"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.psychic_status);
				newTypeList = getResources().getStringArray(R.array.status_type_psychic);
				newPowerMoves = getResources().getStringArray(R.array.psychic_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.psychic_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.psychic_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_psychic);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_psychic);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_psychic);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Steel"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.steel_status);
				newTypeList = getResources().getStringArray(R.array.status_type_steel);
				newPowerMoves = getResources().getStringArray(R.array.steel_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.steel_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.steel_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_steel);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_steel);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_steel);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ghost"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.ghost_status);
				newTypeList = getResources().getStringArray(R.array.status_type_ghost);
				newPowerMoves = getResources().getStringArray(R.array.ghost_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.ghost_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.ghost_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_ghost);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_ghost);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_ghost);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dark"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.dark_status);
				newTypeList = getResources().getStringArray(R.array.status_type_dark);
				newPowerMoves = getResources().getStringArray(R.array.dark_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.dark_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.dark_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_dark);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_dark);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_dark);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Electric"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.electric_status);
				newTypeList = getResources().getStringArray(R.array.status_type_electric);
				newPowerMoves = getResources().getStringArray(R.array.electric_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.electric_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.electric_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_electric);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_electric);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_electric);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dragon"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.dragon_status);
				newTypeList = getResources().getStringArray(R.array.status_type_dragon);
				newPowerMoves = getResources().getStringArray(R.array.dragon_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.dragon_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.dragon_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_dragon);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_dragon);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_dragon);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ice"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.ice_status);
				newTypeList = getResources().getStringArray(R.array.status_type_ice);
				newPowerMoves = getResources().getStringArray(R.array.ice_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.ice_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.ice_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_ice);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_ice);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_ice);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Grass"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.grass_status);
				newTypeList = getResources().getStringArray(R.array.status_type_grass);
				newPowerMoves = getResources().getStringArray(R.array.grass_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.grass_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.grass_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_grass);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_grass);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_grass);
			}
		}
		
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Flying"))
		{
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
			{
				newList = getResources().getStringArray(R.array.flying_status);
				newTypeList = getResources().getStringArray(R.array.status_type_flying);
				newPowerMoves = getResources().getStringArray(R.array.flying_status_power);
				newAccuracyMoves = getResources().getStringArray(R.array.flying_status_accuracy);
			}
			if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
			{
				newList = getResources().getStringArray(R.array.flying_damaging);
				newTypeList = getResources().getStringArray(R.array.type_moves_flying);
				newPowerMoves = getResources().getStringArray(R.array.power_damaging_flying);
				newAccuracyMoves = getResources().getStringArray(R.array.accuracy_damagin_flying);
			}
		}
	}
	
	public void falseTrue()
	{
		if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Status"))
		{
			newList = getResources().getStringArray(R.array.statusmoves);
			newTypeList = getResources().getStringArray(R.array.status_moves_types);
			newPowerMoves = getResources().getStringArray(R.array.status_power);
			newAccuracyMoves = getResources().getStringArray(R.array.status_accuracy);
		}
		if(String.valueOf(physical_special_Spinner.getSelectedItem()).equals("Damaging"))
		{
			newList = getResources().getStringArray(R.array.damage_moves);
			newTypeList = getResources().getStringArray(R.array.damage_type);
			newPowerMoves = getResources().getStringArray(R.array.damage_power);
			newAccuracyMoves = getResources().getStringArray(R.array.damage_accuracy);
		}
	}
	
	public void trueFalse()
	{
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Bug"))
		{
			newList = getResources().getStringArray(R.array.bug_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_bug);
			newPowerMoves = getResources().getStringArray(R.array.bugpower);
			newAccuracyMoves = getResources().getStringArray(R.array.bugaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dark")) 
		{
			newList = getResources().getStringArray(R.array.dark_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_dark);
			newPowerMoves = getResources().getStringArray(R.array.darkpower);
			newAccuracyMoves = getResources().getStringArray(R.array.darkaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Dragon")) 
		{
			newList = getResources().getStringArray(R.array.dragon_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_dragon);
			newPowerMoves = getResources().getStringArray(R.array.dragonpower);
			newAccuracyMoves = getResources().getStringArray(R.array.dragonaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fire")) 
		{
			newList = getResources().getStringArray(R.array.fire_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_fire);
			newPowerMoves = getResources().getStringArray(R.array.firepower);
			newAccuracyMoves = getResources().getStringArray(R.array.fireaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fighting")) 
		{
			newList = getResources().getStringArray(R.array.fighting_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_fighting);
			newPowerMoves = getResources().getStringArray(R.array.fightingpower);
			newAccuracyMoves = getResources().getStringArray(R.array.fightingaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Fairy")) 
		{
			newList = getResources().getStringArray(R.array.fairy_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_fairy);
			newPowerMoves = getResources().getStringArray(R.array.fairypower);
			newAccuracyMoves = getResources().getStringArray(R.array.fairyaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Grass")) 
		{
			newList = getResources().getStringArray(R.array.grass_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_grass);
			newPowerMoves = getResources().getStringArray(R.array.grasspower);
			newAccuracyMoves = getResources().getStringArray(R.array.grassaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ground")) 
		{
			newList = getResources().getStringArray(R.array.ground_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_ground);
			newPowerMoves = getResources().getStringArray(R.array.groundpower);
			newAccuracyMoves = getResources().getStringArray(R.array.groundaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ghost")) 
		{
			newList = getResources().getStringArray(R.array.ghost_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_ghost);
			newPowerMoves = getResources().getStringArray(R.array.ghostpower);
			newAccuracyMoves = getResources().getStringArray(R.array.ghostaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Flying")) 
		{
			newList = getResources().getStringArray(R.array.flying_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_flying);
			newPowerMoves = getResources().getStringArray(R.array.flyingpower);
			newAccuracyMoves = getResources().getStringArray(R.array.flyingaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Water")) 
		{
			newList = getResources().getStringArray(R.array.water_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_water);
			newPowerMoves = getResources().getStringArray(R.array.waterpower);
			newAccuracyMoves = getResources().getStringArray(R.array.wateraccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Poison")) 
		{
			newList = getResources().getStringArray(R.array.poison_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_poison);
			newPowerMoves = getResources().getStringArray(R.array.poisonpower);
			newAccuracyMoves = getResources().getStringArray(R.array.poisonaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Electric")) 
		{
			newList = getResources().getStringArray(R.array.electric_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_electric);
			newPowerMoves = getResources().getStringArray(R.array.electricpower);
			newAccuracyMoves = getResources().getStringArray(R.array.electricaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Psychic")) 
		{
			newList = getResources().getStringArray(R.array.psychic_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_psychic);
			newPowerMoves = getResources().getStringArray(R.array.psychicpower);
			newAccuracyMoves = getResources().getStringArray(R.array.psychicaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Rock")) 
		{
			newList = getResources().getStringArray(R.array.rock_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_rock);
			newPowerMoves = getResources().getStringArray(R.array.rockpower);
			newAccuracyMoves = getResources().getStringArray(R.array.rockaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Ice")) 
		{
			newList = getResources().getStringArray(R.array.ice_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_ice);
			newPowerMoves = getResources().getStringArray(R.array.icepower);
			newAccuracyMoves = getResources().getStringArray(R.array.iceaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Steel")) 
		{
			newList = getResources().getStringArray(R.array.steel_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_steel);
			newPowerMoves = getResources().getStringArray(R.array.steelpower);
			newAccuracyMoves = getResources().getStringArray(R.array.steelaccuracy);
		}
		if(String.valueOf(typeSpinner.getSelectedItem()).equals("Normal")) 
		{
			newList = getResources().getStringArray(R.array.normal_moves);
			newTypeList = getResources().getStringArray(R.array.type_moves_normal);
			newPowerMoves = getResources().getStringArray(R.array.normalpower);
			newAccuracyMoves = getResources().getStringArray(R.array.normalaccuracy);
		}
	}
}
