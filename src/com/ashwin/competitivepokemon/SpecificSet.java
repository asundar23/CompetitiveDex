package com.ashwin.competitivepokemon;
import java.util.ArrayList;
import com.ashwin.competitivepokemon.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;



public class SpecificSet extends Activity{
	
	TextView title;
	TextView ability;
	ListView nature;
	TextView explanationtitle;
	ListView item;
	String[] pok;
	ListView ev;
	ListView moves;
	TextView movesTitle;
	int background[];
	ArrayList<String> natureArray;
	ArrayList<String> itemArray;
	ArrayList<String> evArray;
	ArrayList<String> moveArray;
	ArrayList<String> alternativeMoveArray;
	String set_title;
	String ability_title;
	Context ctx;
	int position;
	String name;
	String type;
	
	String se;
	String cc;
	String dc;
	
	TextView item_title;
	TextView nature_title;
	TextView ev_title;
	TextView ability_header;
	
	Button alternative;
	Button setexplanation;
	Button checksandcounters;
	Button damagecalcs;
	
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		setContentView(R.layout.pokemonset);
		
		natureArray = new ArrayList<String>();
		itemArray = new ArrayList<String>();
		evArray = new ArrayList<String>();
		alternativeMoveArray = new ArrayList<String>();
		
		item_title = (TextView) findViewById(R.id.item_choice);
		nature_title = (TextView) findViewById(R.id.nature);
		ev_title = (TextView) findViewById(R.id.ev);
		ability_header = (TextView) findViewById(R.id.ability);
		movesTitle = (TextView) findViewById(R.id.moves_list);
		
		setexplanation = (Button) findViewById(R.id.setexplanation);
		checksandcounters = (Button) findViewById(R.id.checksandcounters);
		damagecalcs = (Button) findViewById(R.id.damagecalcs);
		alternative = (Button) findViewById(R.id.alternativeButton);
		
		ctx = getBaseContext();
		bundle = getIntent().getExtras();
		position = bundle.getInt("position");
		name = bundle.getString("name");
		
		final Pokemon pokemon = new Pokemon (ctx,name);
		
		set_title = pokemon.setName[position];
		ability_title = pokemon.ability[position];
		natureArray = pokemon.allNatures.get(position);
		itemArray = pokemon.allItems.get(position);
		evArray = pokemon.allEV.get(position);
		moveArray = pokemon.allMoves.get(position);
		alternativeMoveArray = pokemon.allAlternativeMoves.get(position);
		
		alternative.setOnClickListener(new OnClickListener(){

			@SuppressLint("InflateParams") @Override
			public void onClick(View v) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						SpecificSet.this);
				
					alertDialogBuilder.setTitle("Alternative Moves");

					LayoutInflater inflater = (LayoutInflater)   getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
					View view = inflater.inflate(R.layout.popup, null);
					
					ListView listView = (ListView) view.findViewById(R.id.alternativeViews);
					
					ArrayAdapter<String>  arrayAdapter = new ArrayAdapter<String>(SpecificSet.this, android.R.layout.simple_list_item_1, alternativeMoveArray);
					
					listView.setAdapter(arrayAdapter);

					alertDialogBuilder
						.setView(view)
						.setCancelable(true)
						.setNegativeButton("Close", new DialogInterface.OnClickListener() {
				            public void onClick(DialogInterface dialog, int which) {
				                dialog.cancel();
				            }
						  });
					
						AlertDialog alertDialog = alertDialogBuilder.create();

						alertDialog.show();
				
			}
			
		});
		
		title = (TextView) findViewById(R.id.set_title);
		ability = (TextView) findViewById(R.id.abilityTV);
		nature = (ListView) findViewById(R.id.natureLV);
		item = (ListView) findViewById(R.id.itemList);
		ev = (ListView) findViewById(R.id.EVSpread);
		moves = (ListView) findViewById(R.id.movesSpread);
		
		ViewGroup.LayoutParams params = nature.getLayoutParams();
	    params.height = natureArray.size()*100;
	    nature.setLayoutParams(params);
	    nature.requestLayout();
	    
	    params = moves.getLayoutParams();
	    params.height = moveArray.size()*90;
	    moves.setLayoutParams(params);
	    moves.requestLayout();
	    
	    params = ev.getLayoutParams();
	    params.height = evArray.size()*90;
	    ev.setLayoutParams(params);
	    ev.requestLayout();
	    
	    params = item.getLayoutParams();
	    params.height = itemArray.size()*90;
	    item.setLayoutParams(params);
	    item.requestLayout();
		
		title.setText(set_title);
		ability.setText(ability_title);
		
		SetAdapter natureAdapter = new SetAdapter(ctx,natureArray);
		nature.setAdapter(natureAdapter);
		
		SetAdapter moveAdapter = new SetAdapter(ctx,moveArray);
		moves.setAdapter(moveAdapter);
		
		SetAdapter itemAdapter =  new SetAdapter(ctx, itemArray);
		item.setAdapter(itemAdapter);
		
		SetAdapter evAdapter =  new SetAdapter(ctx, evArray);	
		ev.setAdapter(evAdapter);
		
		String[] theTypes = pokemon.getTypes();
		if(theTypes[1].isEmpty()) type = theTypes[0];
		else type = theTypes[1];
		
		
		setexplanation.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						SpecificSet.this);
				
				LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(
					    Context.LAYOUT_INFLATER_SERVICE);
				
					View view = inflater.inflate( R.layout.spinnertv, null );

					alertDialogBuilder.setTitle("Set Explanation");
					
					TextView title = (TextView) view.findViewById(R.id.title);
					TextView sorw = (TextView) view.findViewById(R.id.sorw);
					
					se = pokemon.setEx[position];
					
					title.setText("Set Explanation");
					sorw.setText(Html.fromHtml(se));
			
					AlertDialog.Builder builder = new AlertDialog.Builder(SpecificSet.this);
					builder.setView(view);
					builder.show();
			}
			
		});
		
		checksandcounters.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						SpecificSet.this);
				
				LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(
					    Context.LAYOUT_INFLATER_SERVICE);
				
					View view = inflater.inflate( R.layout.spinnertv, null );

					alertDialogBuilder.setTitle("Set Explanation");
					
					TextView title = (TextView) view.findViewById(R.id.title);
					TextView sorw = (TextView) view.findViewById(R.id.sorw);
					
					cc = pokemon.cc[position];
					
					title.setText("Checks & Counters");
					sorw.setText(Html.fromHtml(cc));
			
					AlertDialog.Builder builder = new AlertDialog.Builder(SpecificSet.this);
					builder.setView(view);
					builder.show();
				
				
			}
			
		});
		
		damagecalcs.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						SpecificSet.this);
				
				LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(
					    Context.LAYOUT_INFLATER_SERVICE);
				
					View view = inflater.inflate( R.layout.spinnertv, null );

					alertDialogBuilder.setTitle("Set Explanation");
					
					TextView title = (TextView) view.findViewById(R.id.title);
					TextView sorw = (TextView) view.findViewById(R.id.sorw);
					
					dc = pokemon.pokemonList[position];
					
					title.setText("Damage Calculations");
					sorw.setText(Html.fromHtml(dc));
			
					AlertDialog.Builder builder = new AlertDialog.Builder(SpecificSet.this);
					builder.setView(view);
					builder.show();
			}
			
		});


		
		getColors(type);
	}
	
	public void getColors(String type)
	{
		background = getResources().getIntArray(R.array.typeArray);
		if(type.equals(" Bug "))
		{
			item_title.setTextColor(background[0]);
			nature_title.setTextColor(background[0]);
			ev_title.setTextColor(background[0]);
			ability_header.setTextColor(background[0]);
			title.setTextColor(background[0]);
			movesTitle.setTextColor(background[0]);
		}
		if(type.equals(" Dark "))
		{
			item_title.setTextColor(background[1]);
			nature_title.setTextColor(background[1]);
			ev_title.setTextColor(background[1]);
			ability_header.setTextColor(background[1]);
			title.setTextColor(background[1]);
			movesTitle.setTextColor(background[1]);
		}
		if(type.equals(" Dragon "))
		{
			item_title.setTextColor(background[2]);
			nature_title.setTextColor(background[2]);
			ev_title.setTextColor(background[2]);
			ability_header.setTextColor(background[2]);
			title.setTextColor(background[2]);
			movesTitle.setTextColor(background[2]);
		}
		if(type.equals(" Electric "))
		{
			item_title.setTextColor(background[3]);
			nature_title.setTextColor(background[3]);
			ev_title.setTextColor(background[3]);
			ability_header.setTextColor(background[3]);
			title.setTextColor(background[3]);
			movesTitle.setTextColor(background[3]);
		}
		if(type.equals(" Fairy "))
		{
			item_title.setTextColor(background[4]);
			nature_title.setTextColor(background[4]);
			ev_title.setTextColor(background[4]);
			ability_header.setTextColor(background[4]);
			title.setTextColor(background[4]);
			movesTitle.setTextColor(background[4]);
		}
		if(type.equals(" Fire "))
		{
			item_title.setTextColor(background[5]);
			nature_title.setTextColor(background[5]);
			ev_title.setTextColor(background[5]);
			ability_header.setTextColor(background[5]);
			title.setTextColor(background[5]);
			movesTitle.setTextColor(background[5]);
		}
		if(type.equals(" Fighting "))
		{
			item_title.setTextColor(background[6]);
			nature_title.setTextColor(background[6]);
			ev_title.setTextColor(background[6]);
			ability_header.setTextColor(background[6]);
			title.setTextColor(background[6]);
			movesTitle.setTextColor(background[6]);
		}
		if(type.equals(" Flying "))
		{
			item_title.setTextColor(background[7]);
			nature_title.setTextColor(background[7]);
			ev_title.setTextColor(background[7]);
			ability_header.setTextColor(background[7]);
			title.setTextColor(background[7]);
			movesTitle.setTextColor(background[7]);
		}
		if(type.equals(" Ghost "))
		{
			item_title.setTextColor(background[8]);
			nature_title.setTextColor(background[8]);
			ev_title.setTextColor(background[8]);
			ability_header.setTextColor(background[8]);
			title.setTextColor(background[8]);
			movesTitle.setTextColor(background[8]);
		}
		if(type.equals(" Grass "))
		{
			item_title.setTextColor(background[9]);
			nature_title.setTextColor(background[9]);
			ev_title.setTextColor(background[9]);
			ability_header.setTextColor(background[9]);
			title.setTextColor(background[9]);
			movesTitle.setTextColor(background[9]);
		}
		if(type.equals(" Ground "))
		{
			item_title.setTextColor(background[10]);
			nature_title.setTextColor(background[10]);
			ev_title.setTextColor(background[10]);
			ability_header.setTextColor(background[10]);
			title.setTextColor(background[10]);
			movesTitle.setTextColor(background[10]);
		}
		if(type.equals(" Ice "))
		{
			item_title.setTextColor(background[11]);
			nature_title.setTextColor(background[11]);
			ev_title.setTextColor(background[11]);
			ability_header.setTextColor(background[11]);
			title.setTextColor(background[11]);
			movesTitle.setTextColor(background[11]);
		}
		if(type.equals(" Normal "))
		{
			item_title.setTextColor(background[12]);
			nature_title.setTextColor(background[12]);
			ev_title.setTextColor(background[12]);
			ability_header.setTextColor(background[12]);
			title.setTextColor(background[12]);
			movesTitle.setTextColor(background[12]);
		}
		if(type.equals(" Poison "))
		{
			item_title.setTextColor(background[13]);
			nature_title.setTextColor(background[13]);
			ev_title.setTextColor(background[13]);
			ability_header.setTextColor(background[13]);
			title.setTextColor(background[13]);
			movesTitle.setTextColor(background[13]);
		}
		if(type.equals(" Psychic "))
		{
			item_title.setTextColor(background[14]);
			nature_title.setTextColor(background[14]);
			ev_title.setTextColor(background[14]);
			ability_header.setTextColor(background[14]);
			title.setTextColor(background[14]);
			movesTitle.setTextColor(background[14]);
		}
		if(type.equals(" Rock "))
		{
			item_title.setTextColor(background[15]);
			nature_title.setTextColor(background[15]);
			ev_title.setTextColor(background[15]);
			ability_header.setTextColor(background[15]);
			title.setTextColor(background[15]);
			movesTitle.setTextColor(background[15]);
		}
		if(type.equals(" Steel "))
		{
			item_title.setTextColor(Color.GRAY);
			nature_title.setTextColor(Color.GRAY);
			ev_title.setTextColor(Color.GRAY);
			ability_header.setTextColor(Color.GRAY);
			title.setTextColor(Color.GRAY);
			movesTitle.setTextColor(Color.GRAY);
		}
		if(type.equals(" Water "))
		{
			item_title.setTextColor(background[17]);
			nature_title.setTextColor(background[17]);
			ev_title.setTextColor(background[17]);
			ability_header.setTextColor(background[17]);
			title.setTextColor(background[17]);
			movesTitle.setTextColor(background[17]);
		}
	}

}
