package com.ashwin.competitivepokemon;

import java.util.Locale;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MovesPokemon extends Fragment {
	
	Context ctx;
	String name;
	int[] levels;
	String[] moves;
	String[] types;
	int[] typeBackgrounds;
	String[] levelArray;
	String[] levelMoveArray;
	String[] levelTypeArray;
	
	TextView note;
	
	ListView screen;
	LevelMoveAdapter lA;
	Spinner moveSpinner;
	Pokemon pokemon;
	TextView level;
	TextView type_of_move;
	
	Button xyButton;
	Button orasButton;
	
	TextView nameHeader;
	TextView typeHeader;
	TextView lastColumnHeader;
	
	String[] tmArray;
	String[] tmMoveArray;
	String[] tmTypeArray;
	
	String[] tutorArray;
	String[] tutorTypeArray;
	String[] tutorGameArray;
	
	String[] oraslevel;
	String[] orasmove;
	String[] orastype;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle bundle)
	{
		super.onCreate(bundle);
		View rootView = inflater.inflate(R.layout.level_screen, container,false);
		
		
		bundle = getActivity().getIntent().getExtras();
        name = bundle.getString("name");
        
        xyButton = (Button) rootView.findViewById(R.id.xyButton);
        orasButton = (Button) rootView.findViewById(R.id.ORASButton);
        
        ctx = getActivity().getApplicationContext();
        
        pokemon = new Pokemon (ctx,name);
		
		levelArray = pokemon.getLevelArray();
		levelMoveArray = pokemon.getLevelMoveArray();
		levelTypeArray = pokemon.getLevelTypeArray();
		
		oraslevel = pokemon.getORASlevel();
		orasmove = pokemon.getORASMove();
		orastype = pokemon.getORASType();
		
		tmArray = pokemon.getTMArray();
		tmMoveArray = pokemon.getTMMoveArray();
		tmTypeArray = pokemon.getTMTypeArray();
		
		tutorArray = pokemon.getTutorMoves();
		tutorTypeArray = pokemon.getTutorTypes();
		tutorGameArray = pokemon.getTutorGame();
		
		note = (TextView) rootView.findViewById(R.id.note2);
		nameHeader = (TextView) rootView.findViewById(R.id.nameHeader);
		typeHeader = (TextView) rootView.findViewById(R.id.theTypeMove);
		lastColumnHeader = (TextView) rootView.findViewById(R.id.level);
		
		typeBackgrounds = getActivity().getResources().getIntArray(R.array.typeArray);
		
		type_of_move = (TextView) rootView.findViewById(R.id.the_level);
		
		screen = (ListView) rootView.findViewById(R.id.movePokemonlistview);
		
		level = (TextView) rootView.findViewById(R.id.level);
		level.setText("Level");
		
		addItemsOnSpinner(rootView);
		
		setLevelButtons();
		
		return rootView;
	}
	
	private void setLevelButtons() {
		
		xyButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				lA = new LevelMoveAdapter(ctx,levelArray,levelMoveArray,levelTypeArray,typeBackgrounds,name);
				
				screen.setAdapter(lA);
				lA.notifyDataSetChanged();
			}
		});
		
		orasButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				lA = new LevelMoveAdapter(ctx,oraslevel,orasmove,orastype,typeBackgrounds,name);
				
				screen.setAdapter(lA);
				lA.notifyDataSetChanged();
			}
		});
		
		
	}

	private void addItemsOnSpinner(View view) {
		moveSpinner = (Spinner) view.findViewById(R.id.move_spinner_pokemon);
		
		ArrayAdapter<CharSequence> typeMove = ArrayAdapter.createFromResource(ctx,
		        R.array.level_tm_hm_egg_tutor, android.R.layout.simple_spinner_item);
		
		
		typeMove.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		moveSpinner.setAdapter(typeMove);
		
		
		
		moveSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(String.valueOf(moveSpinner.getSelectedItem()).equals("Level"))
				{
					chooseLevel();
					setLevelButtons();
					
				}
				if(String.valueOf(moveSpinner.getSelectedItem()).equals("TM and HM"))
				{
					chooseTM();
				}
				if(String.valueOf(moveSpinner.getSelectedItem()).equals("Tutor"))
				{
					chooseTutor();
				}
			}


			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub		
			}
			
		});
	}
	
	public void chooseTM()
	{
		level.setText("TM/HM");
		lA = new LevelMoveAdapter(ctx,tmArray,tmMoveArray,tmTypeArray,typeBackgrounds,name);
		
		
		ViewGroup.LayoutParams params = screen.getLayoutParams();
	    params.height = tmArray.length*90;
	    screen.setLayoutParams(params);
	    screen.requestLayout();
	    
	    if(tmArray.length == 0)
	    {
	    	screen.setAlpha((float) .20);
	    	note.setText(name+" does not learn any TM moves.");
	    	note.setVisibility(View.VISIBLE);
	    	nameHeader.setVisibility(View.GONE);
	    	typeHeader.setVisibility(View.GONE);
	    	lastColumnHeader.setVisibility(View.GONE);
	    }
	    else
	    {
	    	screen.setAlpha(1);
	    	note.setVisibility(View.GONE);
	    }
		
		screen.setAdapter(lA);
		
		screen.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent intent = new Intent(ctx, TabsMoves.class);
				intent.putExtra("name", tmArray[position]);
                startActivity(intent);
				
			}
			
		});
	}
	
	public void chooseTutor() 
	{
		level.setText("Game");
		lA = new LevelMoveAdapter(ctx,tutorGameArray,tutorArray,tutorTypeArray,typeBackgrounds,name);
		
		ViewGroup.LayoutParams params = screen.getLayoutParams();
	    params.height = tutorArray.length*90;
	    screen.setLayoutParams(params);
	    screen.requestLayout();
	    
	    if(tutorArray.length == 0)
	    {
	    	screen.setAlpha((float) .20);
	    	note.setText(name+" does not learn any Tutor moves.");
	    	note.setVisibility(View.VISIBLE);
	    	nameHeader.setVisibility(View.GONE);
	    	typeHeader.setVisibility(View.GONE);
	    	lastColumnHeader.setVisibility(View.GONE);
	    }
	    else
	    {
	    	screen.setAlpha(1);
	    	note.setVisibility(View.GONE);
	    }
		
		screen.setAdapter(lA);
		
		screen.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent intent = new Intent(ctx, TabsMoves.class);
				intent.putExtra("name", tutorArray[position]);
                startActivity(intent);
				
			}
			
		});
	}
	
	public void chooseLevel()
	{
		level.setText("Level");
		lA = new LevelMoveAdapter(ctx,levelArray,levelMoveArray,levelTypeArray,typeBackgrounds,name);
		
		ViewGroup.LayoutParams params = screen.getLayoutParams();
	    params.height = levelArray.length*90;
	    screen.setLayoutParams(params);
	    screen.requestLayout();
	    
	    if(levelMoveArray.length == 0)
	    {
	    	screen.setAlpha((float) .20);
	    	
	    	note.setText(name+" does not learn any Level-Up moves.");
	    	note.setVisibility(View.VISIBLE);
	    	nameHeader.setVisibility(View.GONE);
	    	typeHeader.setVisibility(View.GONE);
	    	lastColumnHeader.setVisibility(View.GONE);
	    }
	    else
	    {
	    	screen.setAlpha(1);
	    	note.setVisibility(View.GONE);
	    }
		
		screen.setAdapter(lA);
		
		screen.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent intent = new Intent(ctx, TabsMoves.class);
				intent.putExtra("name", levelMoveArray[position]);
                startActivity(intent);
				
			}
			
		});
	}
	
}
