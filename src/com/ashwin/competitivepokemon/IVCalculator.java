package com.ashwin.competitivepokemon;

import java.util.Arrays;
import com.ashwin.competitivepokemon.R;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class IVCalculator extends Activity{

	Spinner pokemonName;
	EditText level;
	TextView baseHP;
	TextView baseAttack;
	TextView baseDefense;
	TextView baseSpA;
	TextView baseSpD;
	TextView baseSpeed;
	
	TextView error;
	
	double hpIV;
	double attIV;
	double defIV;
	double spaIV;
	double spdIV;
	double speIV;
	
	int typeColors[];
	
	int ev_HP;
	int ev_Att;
	int ev_Def;
	int ev_Spa;
	int ev_Spd;
	int ev_Spe;
	
	Pokemon pokemon;
	
	String[] natures;
	String theNature;
	String positive;
	String negative;
	
	int pos = 0;
	Context ctx;
	TextView iv_title;
	TextView hp;
	TextView attack;
	Spinner nature;
	TextView defense;
	TextView special_attack;
	TextView special_defense;
	TextView speed;
	String type;
	String poke;
	int[] stats;
	
	TextView high_hp;
	TextView high_att;
	TextView high_def;
	TextView high_spa;
	TextView high_spd;
	TextView high_spe;
	
	int theLevel;
	
	EditText ev_hp;
	EditText ev_att;
	EditText ev_def;
	EditText ev_spa;
	EditText ev_spd;
	EditText ev_spe;
	
	int current_HP;
	int current_Att;
	int current_Def;
	int current_Spa;
	int current_Spd;
	int current_Spe;
	
	TextView title2;
	
	EditText current_hp;
	EditText current_att;
	EditText current_def;
	EditText current_spa;
	EditText current_spd;
	EditText current_spe;
	String[] listPokemon;
	Spinner characteristic;
	String[] characteristics;
	Button characteristic_explanation;
	
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.ivcalculator);
		ctx = getBaseContext();

		pokemonName = (Spinner) findViewById(R.id.pokemonEdit);
		level = (EditText) findViewById(R.id.levelEdit);
		baseHP = (TextView) findViewById(R.id.change_HP);
		baseAttack = (TextView) findViewById(R.id.change_attack);
		baseDefense = (TextView) findViewById(R.id.change_defense);
		baseSpA = (TextView) findViewById(R.id.change_spa);
		baseSpD = (TextView) findViewById(R.id.change_spd);
		baseSpeed = (TextView) findViewById(R.id.change_spe);
		
		nature = (Spinner) findViewById(R.id.natureSpinner);
		
		error = (TextView) findViewById(R.id.error);
		error.setVisibility(View.GONE);
		
		ev_hp = (EditText) findViewById(R.id.hpev);
		ev_att = (EditText) findViewById(R.id.attev);
		ev_def = (EditText) findViewById(R.id.defev);
		ev_spa = (EditText) findViewById(R.id.spaev);
		ev_spd = (EditText) findViewById(R.id.spdev);
		ev_spe = (EditText) findViewById(R.id.speev);
		
		characteristic = (Spinner) findViewById(R.id.characteristic);
		characteristic_explanation = (Button) findViewById(R.id.characteristic_explanation);
		current_hp = (EditText) findViewById(R.id.HP_edit);
		current_att = (EditText) findViewById(R.id.att_edit);
		current_def = (EditText) findViewById(R.id.def_edit);
		current_spa = (EditText) findViewById(R.id.spa_edit);
		current_spd = (EditText) findViewById(R.id.spd_edit);
		current_spe = (EditText) findViewById(R.id.spe_edit);
		
		title2 = (TextView) findViewById(R.id.iv_title2);
		high_hp = (TextView) findViewById(R.id.hp_iv2);
		high_att = (TextView) findViewById(R.id.att_iv2);
		high_def = (TextView) findViewById(R.id.def_iv2);
		high_spa = (TextView) findViewById(R.id.spa_iv2);
		high_spd = (TextView) findViewById(R.id.spd_iv2);
		high_spe = (TextView) findViewById(R.id.spe_iv2);
		
		iv_title = (TextView) findViewById(R.id.iv_title);
		hp = (TextView) findViewById(R.id.hp_iv);
		attack = (TextView) findViewById(R.id.att_iv);
		defense = (TextView) findViewById(R.id.def_iv);
		special_attack = (TextView) findViewById(R.id.spa_iv);
		special_defense = (TextView) findViewById(R.id.spd_iv);
		speed = (TextView) findViewById(R.id.spe_iv);
		
		type = "Grass";
		
		String chp = current_hp.getText().toString();
		if(chp.equals("")){
			chp="0";
		}
		 current_HP = Integer.parseInt(chp);
		
		
		
		chp = current_att.getText().toString();
		if(chp.equals("")){
			chp="0";
		}
		 current_Att = Integer.parseInt(chp);
		
		
		
		chp = current_def.getText().toString();
		if(chp.equals("")){
			chp="0";
		}
		 current_Def = Integer.parseInt(chp);
		
		
		
		chp = current_spa.getText().toString();
		if(chp.equals("")){
			chp="0";
		}
		 current_Spa = Integer.parseInt(chp);
		
		
		
		chp = current_spd.getText().toString();
		if(chp.equals("")){
			chp="0";
		}
		 current_Spd = Integer.parseInt(chp);
		
		
		
		chp = current_spe.getText().toString();
		if(chp.equals("")){
			chp="0";
		}
		 current_Spe = Integer.parseInt(chp);
		
		
		
		
		characteristic.setPrompt("Characteristics");
		
		
		listPokemon = getResources().getStringArray(R.array.list_of_pokemon);
		Arrays.sort(listPokemon);
		
		ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listPokemon);
		pokemonName.setAdapter(spinAdapter);
		
		pokemonName.setPrompt("Choose Your Pokemon");
		
		poke = "Bulbasaur";
		pokemon = new Pokemon(ctx,poke);
		stats = pokemon.getStats();
		
		
		pokemonName.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				poke = listPokemon[position];
				pokemon = new Pokemon(ctx,poke);
				stats = pokemon.getStats();
				
				baseHP.setText(stats[0]+"");
				baseAttack.setText(stats[1]+"");
				baseDefense.setText(stats[2]+"");
				baseSpA.setText(stats[3]+"");
				baseSpD.setText(stats[4]+"");
				baseSpeed.setText(stats[5]+"");
				
				type = pokemon.getType1();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
			
			
		});
		
		typeColors = getResources().getIntArray(R.array.typeArray);
		
			String levelPokemon = level.getText().toString();
			if(levelPokemon.equals("")){
				levelPokemon="1";
			}
			
			theLevel = Integer.parseInt(levelPokemon);
			
			characteristics = getResources().getStringArray(R.array.characteristics);
			
			Arrays.sort(characteristics);
			
			ArrayAdapter<String> characteristicsAdapter = new ArrayAdapter<String>
					(this,android.R.layout.simple_spinner_item,characteristics);
			characteristic.setAdapter(characteristicsAdapter);
			
			characteristic.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					pos = position;
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			characteristic_explanation.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					
					CharacteristicExplanations ce = 
							new CharacteristicExplanations(
									characteristic.getItemAtPosition(pos).toString(),characteristics);
					String exp = ce.explanations();
					
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							IVCalculator.this);
					
					LayoutInflater inflater = (LayoutInflater)   getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
					View viewTV = inflater.inflate(R.layout.dialog_text_view, null);
					
					TextView tv = (TextView) viewTV.findViewById(R.id.dialog_tv);
					
					alertDialogBuilder.setTitle(characteristics[pos]);

					alertDialogBuilder
						.setCancelable(true)
						.setNegativeButton("Close", new DialogInterface.OnClickListener() {
				            public void onClick(DialogInterface dialog, int which) {
				                dialog.cancel();
				            }
						  });
					
					tv.setText(Html.fromHtml(exp));
					
					alertDialogBuilder.setView(viewTV);
					
					AlertDialog alertDialog = alertDialogBuilder.create();

					alertDialog.show();
					
				}
				
			});
			
			chp = ev_hp.getText().toString();
			if(chp.equals("")) chp = "0";
			 ev_HP = Integer.parseInt(chp);
			
			
			chp = ev_att.getText().toString();
			if(chp.equals("")) chp = "0";
			 ev_Att = Integer.parseInt(chp);
			
			
			chp = ev_def.getText().toString();
			if(chp.equals("")) chp = "0";
			 ev_Def = Integer.parseInt(chp);
			
			
			chp = ev_spa.getText().toString();
			if(chp.equals("")) chp = "0";
			 ev_Spa = Integer.parseInt(chp);
			
			
			chp = ev_spd.getText().toString();
			if(chp.equals("")) chp = "0";
			 ev_Spd = Integer.parseInt(chp);
			
			
			chp = ev_spe.getText().toString();
			if(chp.equals("")) chp = "0";
			 ev_Spe = Integer.parseInt(chp);
			
			natures = getResources().getStringArray(R.array.natures);
			Arrays.sort(natures);
			
			ArrayAdapter<String> natureAdapter = new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_dropdown_item,natures);
			nature.setAdapter(natureAdapter);
			
			theNature = "Adamant";
			positive = "attack";
			negative = "special_attack";
			
			nature.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					theNature = natures[position];
					
					if(theNature.equals("Adamant")){
						positive = "attack";
						negative = "special_attack";
					}
					
					if(theNature.equals("Hardy")){
						positive = "neutral";
						negative = "neutral";
					}
					if(theNature.equals("Lonely")){
						positive = "attack";
						negative = "defense";
					}
					if(theNature.equals("Brave")){
						positive = "attack";
						negative = "speed";
					}
					if(theNature.equals("Naughty")){
						positive = "attack";
						negative = "Special_defense";
					}
					if(theNature.equals("Bold")){
						positive = "defense";
						negative = "attack";
					}
					if(theNature.equals("Docile")){
						positive = "neutral";
						negative = "neutral";
					}
					if(theNature.equals("Relaxed")){
						positive = "defense";
						negative = "speed";
					}
					if(theNature.equals("Impish")){
						positive = "defense";
						negative = "special_attack";
					}
					if(theNature.equals("Lax")){
						positive = "defense";
						negative = "special_defense";
					}
					if(theNature.equals("Timid")){
						positive = "speed";
						negative = "attack";
					}
					if(theNature.equals("Hasty")){
						positive = "speed";
						negative = "defense";
					}
					if(theNature.equals("Serious")){
						positive = "neutral";
						negative = "neutral";
					}
					if(theNature.equals("Jolly")){
						positive = "speed";
						negative = "special_attack";
					}
					if(theNature.equals("Naive")){
						positive = "speed";
						negative = "special_defense";
					}
					if(theNature.equals("Modest")){
						positive = "special_attack";
						negative = "attack";
					}
					if(theNature.equals("Mild")){
						positive = "special_attack";
						negative = "defense";
					}
					if(theNature.equals("Quiet")){
						positive = "special_attack";
						negative = "speed";
					}
					if(theNature.equals("Bashful")){
						positive = "neutral";
						negative = "neutral";
					}
					if(theNature.equals("Rash")){
						positive = "special_attack";
						negative = "special_defense";
					}
					if(theNature.equals("Calm")){
						positive = "special_defense";
						negative = "attack";
					}
					if(theNature.equals("Gentle")){
						positive = "special_defense";
						negative = "defense";
					}
					if(theNature.equals("Sassy")){
						positive = "special_defense";
						negative = "speed";
					}
					if(theNature.equals("Careful")){
						positive = "special_defense";
						negative = "special_attack";
					}
					if(theNature.equals("Quirky")){
						positive = "neutral";
						negative = "neutral";
					}
					
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			 hpIV =  0;
			 attIV = 0;
			 defIV = 0;
			 spaIV = 0;
			 spdIV = 0;
			 speIV = 0;
			
			
			
			Button calculate = (Button) findViewById(R.id.calculate);
			
			
				calculate.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						
						try{
							theLevel = Integer.parseInt(level.getText().toString());
						
							current_HP = Integer.parseInt(current_hp.getText().toString());
							current_Att = Integer.parseInt(current_att.getText().toString());
							current_Def = Integer.parseInt(current_def.getText().toString());
							current_Spa = Integer.parseInt(current_spa.getText().toString());
							current_Spd = Integer.parseInt(current_spd.getText().toString());
							current_Spe = Integer.parseInt(current_spe.getText().toString());
							
							ev_HP = Integer.parseInt(ev_hp.getText().toString());
							ev_Att = Integer.parseInt(ev_att.getText().toString());
							ev_Def = Integer.parseInt(ev_def.getText().toString());
							ev_Spa = Integer.parseInt(ev_spa.getText().toString());
							ev_Spd = Integer.parseInt(ev_spd.getText().toString());
							ev_Spe = Integer.parseInt(ev_spe.getText().toString());
							
							
							
							hpIV =  (int) Math.ceil((((current_HP-10)*100) / theLevel) - (2*stats[0]) - (ev_HP / 4) - 100);
							
							
							if(positive.equals("attack")) attIV =  (int) Math.ceil((((Math.ceil(current_Att / 1.1) - 5) * 100 / theLevel) - 2 * stats[1] - Math.floor(ev_Att / 4)));
							else if(negative.equals("attack")) attIV = (int) Math.ceil((((Math.ceil(current_Att / 0.9) - 5) * 100 / theLevel) - 2 * stats[1] - Math.floor(ev_Att / 4)));
							else attIV =  (int)Math.ceil((((Math.ceil(current_Att / 1.0) - 5) * 100 / theLevel) - 2 * stats[1] - Math.floor(ev_Att / 4)));
							
							
							if(positive.equals("defense")) defIV = (int) Math.ceil((((Math.ceil(current_Def / 1.1) - 5) * 100 / theLevel) - 2 * stats[2] - Math.floor(ev_Def / 4)));
							else if(negative.equals("defense")) defIV = (int) Math.ceil((((Math.ceil(current_Def / 0.9) - 5) * 100 / theLevel) - 2 * stats[2] - Math.floor(ev_Def / 4)));
							else defIV = (int) Math.ceil((((Math.ceil(current_Def / 1.0) - 5) * 100 / theLevel) - 2 * stats[2] - Math.floor(ev_Def / 4)));
							
							
							if(positive.equals("special_attack")) spaIV = (int) Math.ceil((((Math.ceil(current_Spa / 1.1) - 5) * 100 / theLevel) - 2 * stats[3] - Math.floor(ev_Spa / 4)));
							else if(negative.equals("special_attack")) spaIV = (int) Math.ceil((((Math.ceil(current_Spa / 0.9) - 5) * 100 / theLevel) - 2 * stats[3] - Math.floor(ev_Spa / 4)));
							else spaIV = (int) Math.ceil((((Math.ceil(current_Spa / 1.0) - 5) * 100 / theLevel) - 2 * stats[3] - Math.floor(ev_Spa / 4)));
							
							
							if(positive.equals("special_defense")) spdIV = (int) Math.ceil((((Math.ceil(current_Spd / 1.1) - 5) * 100 / theLevel) - 2 * stats[4] - Math.floor(ev_Spd / 4)));
							else if(negative.equals("special_defense")) spdIV =  (int) Math.ceil((((Math.ceil(current_Spd / 0/9) - 5) * 100 / theLevel) - 2 * stats[4] - Math.floor(ev_Spd / 4)));
							else spdIV = (int) Math.ceil((((Math.ceil(current_Spd / 1.0) - 5) * 100 / theLevel) - 2 * stats[4] - Math.floor(ev_Spd / 4)));
							
							
							if(positive.equals("speed")) speIV = (int) Math.ceil((((Math.ceil(current_Spe / 1.1) - 5) * 100 / theLevel) - 2 * stats[5] - Math.floor(ev_Spe / 4)));
							else if(negative.equals("speed")) speIV = (int) Math.ceil((((Math.ceil(current_Spe / 0.9) - 5) * 100 / theLevel) - 2 * stats[5] - Math.floor(ev_Spe / 4)));
							else speIV =  (int) Math.ceil((((Math.ceil(current_Spe / 1.0) - 5) * 100 / theLevel) - 2 * stats[5] - Math.floor(ev_Spe / 4)));
							
							
							if(theLevel>=10 || theLevel < 20){
								
								high_hp.setText(hpIV + 8 + "");
								if(hpIV+8 > 31) high_hp.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_att.setText(attIV + 8 + "");
								if(attIV+8 > 31) high_att.setText(31+"");
								if(attIV < 0) high_att.setText("0");
								
								high_def.setText(defIV + 8 + "");
								if(defIV+8 > 31) high_def.setText(31+"");
								if(defIV < 0) high_def.setText("0");
								
								high_spa.setText(spaIV + 8 + "");
								if(spaIV+8 > 31) high_spa.setText(31+"");
								if(spaIV < 0) high_spa.setText("0");
								
								high_spd.setText(spdIV + 8 + "");
								if(spdIV+8 > 31) high_spd.setText(31+"");
								if(spdIV < 0) high_spd.setText("0");
								
								high_spe.setText(speIV + 8 + "");
								if(speIV+8 > 31) high_spe.setText(31+"");
								if(speIV < 0) high_spe.setText("0");
								
							}
							
							if(theLevel>=20 || theLevel < 29){
								
								high_hp.setText(hpIV + 4 + "");
								if(hpIV+4 > 31) high_hp.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_att.setText(attIV + 4 + "");
								if(attIV+4 > 31) high_att.setText(31+"");
								if(attIV < 0) high_att.setText("0");
								
								high_def.setText(defIV + 4 + "");
								if(defIV+4 > 31) high_def.setText(31+"");
								if(defIV < 0) high_def.setText("0");
								
								high_spa.setText(spaIV + 4 + "");
								if(spaIV+4 > 31) high_spa.setText(31+"");
								if(spaIV < 0) high_spa.setText("0");
								
								high_spd.setText(spdIV + 4 + "");
								if(spdIV+4 > 31) high_spd.setText(31+"");
								if(spdIV < 0) high_spd.setText("0");
								
								high_spe.setText(speIV + 4 + "");
								if(speIV+4 > 31) high_spe.setText(31+"");
								if(speIV < 0) high_spe.setText("0");
								
							}
							
							if(theLevel>=30 || theLevel < 39){
								
								high_hp.setText(hpIV + 2 + "");
								if(hpIV+2 > 31) high_hp.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_att.setText(attIV + 2 + "");
								if(attIV+2 > 31) high_att.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_def.setText(defIV + 2 + "");
								if(defIV+2 > 31) high_def.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_spa.setText(spaIV + 2 + "");
								if(spaIV+2 > 31) high_spa.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_spd.setText(spdIV + 2 + "");
								if(spdIV+2 > 31) high_spd.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_spe.setText(speIV + 2 + "");
								if(speIV+2 > 31) high_spe.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
							}
							
							if(theLevel>=40 || theLevel < 69){
								
								high_hp.setText(hpIV + 1 + "");
								if(hpIV+1 > 31) high_hp.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_att.setText(attIV + 1 + "");
								if(attIV+1 > 31) high_att.setText(31+"");
								if(attIV < 0) high_att.setText("0");
								
								high_def.setText(defIV + 1 + "");
								if(defIV+1 > 31) high_def.setText(31+"");
								if(defIV < 0) high_def.setText("0");
								
								high_spa.setText(spaIV + 1 + "");
								if(spaIV+1 > 31) high_spa.setText(31+"");
								if(spaIV < 0) high_spa.setText("0");
								
								high_spd.setText(spdIV + 1 + "");
								if(spdIV+1 > 31) high_spd.setText(31+"");
								if(spdIV < 0) high_spd.setText("0");
								
								high_spe.setText(speIV + 1 + "");
								if(speIV+1 > 31) high_spe.setText(31+"");
								if(speIV < 0) high_spe.setText("0");
								
							}
							
							if(theLevel>=70){
								high_hp.setText(hpIV+"");
								if(hpIV == 30) high_hp.setText(31+"");
								if(hpIV < 0) high_hp.setText("0");
								
								high_att.setText(attIV+"");
								if(attIV == 30) high_att.setText(31+"");
								if(attIV < 0) high_att.setText("0");
								
								high_def.setText(defIV+"");
								if(defIV == 30) high_def.setText(31+"");
								if(defIV < 0) high_def.setText("0");
								
								high_spa.setText(spaIV+"");
								if(spaIV == 30) high_spa.setText(31+"");
								if(spaIV < 0) high_spa.setText("0");
								
								high_spd.setText(spdIV+"");
								if(spdIV == 30) high_spd.setText(31+"");
								if(spdIV < 0) high_spd.setText("0");
								
								high_spe.setText(speIV+"");
								if(speIV == 30) high_spe.setText(31+"");
								if(speIV < 0) high_spe.setText("0");
							}
							
							
							hp.setText(hpIV+"");
							attack.setText(attIV+"");
							defense.setText(defIV+"");
							special_attack.setText(spaIV+"");
							special_defense.setText(spdIV+"");
							speed.setText(speIV+"");
							
							type = pokemon.getType1();
							
							error.setVisibility(View.GONE);
							
							setTypes(type);	
							
							if(hpIV < 0		   ||
									hpIV > 31  ||
									attIV < 0  ||
									attIV > 31 ||
									defIV < 0  ||
									defIV > 31 ||
									spaIV < 0  ||
									spaIV > 31 ||
									spdIV < 0  ||
									spdIV > 31 ||
									speIV < 0  ||
									speIV > 31 ){
								
								error.setVisibility(View.VISIBLE);
								error.setTextColor(Color.RED);
								error.setText("Invalid input. IV's must be between 0 and 31. Please enter the values again.");
							}
						}
						catch (NumberFormatException e){
							error.setVisibility(View.VISIBLE);
							error.setTextColor(Color.RED);
						}
					}
			
				});

		setTypes(type);
	}
	
	public void setTypes(String t){
		if(t.equals("Bug")){
			iv_title.setTextColor(typeColors[0]);
			hp.setTextColor(typeColors[0]);
			attack.setTextColor(typeColors[0]);
			defense.setTextColor(typeColors[0]);
			special_attack.setTextColor(typeColors[0]);
			special_defense.setTextColor(typeColors[0]);
			speed.setTextColor(typeColors[0]);
			title2.setTextColor(typeColors[0]);
			high_hp.setTextColor(typeColors[0]);
			high_att.setTextColor(typeColors[0]);
			high_def.setTextColor(typeColors[0]);
			high_spa.setTextColor(typeColors[0]);
			high_spd.setTextColor(typeColors[0]);
			high_spe.setTextColor(typeColors[0]);
		}
		if(t.equals("Dark")){
			iv_title.setTextColor(typeColors[1]);
			hp.setTextColor(typeColors[1]);
			attack.setTextColor(typeColors[1]);
			defense.setTextColor(typeColors[1]);
			special_attack.setTextColor(typeColors[1]);
			special_defense.setTextColor(typeColors[1]);
			speed.setTextColor(typeColors[1]);
			title2.setTextColor(typeColors[1]);
			high_hp.setTextColor(typeColors[1]);
			high_att.setTextColor(typeColors[1]);
			high_def.setTextColor(typeColors[1]);
			high_spa.setTextColor(typeColors[1]);
			high_spd.setTextColor(typeColors[1]);
			high_spe.setTextColor(typeColors[1]);
		}
		if(t.equals("Dragon")){
			iv_title.setTextColor(typeColors[2]);
			hp.setTextColor(typeColors[2]);
			attack.setTextColor(typeColors[2]);
			defense.setTextColor(typeColors[2]);
			special_attack.setTextColor(typeColors[2]);
			special_defense.setTextColor(typeColors[2]);
			speed.setTextColor(typeColors[2]);
			title2.setTextColor(typeColors[2]);
			high_hp.setTextColor(typeColors[2]);
			high_att.setTextColor(typeColors[2]);
			high_def.setTextColor(typeColors[2]);
			high_spa.setTextColor(typeColors[2]);
			high_spd.setTextColor(typeColors[2]);
			high_spe.setTextColor(typeColors[2]);
		}
		if(t.equals("Electric")){
			iv_title.setTextColor(typeColors[3]);
			hp.setTextColor(typeColors[3]);
			attack.setTextColor(typeColors[3]);
			defense.setTextColor(typeColors[3]);
			special_attack.setTextColor(typeColors[3]);
			special_defense.setTextColor(typeColors[3]);
			speed.setTextColor(typeColors[3]);
			title2.setTextColor(typeColors[3]);
			high_hp.setTextColor(typeColors[3]);
			high_att.setTextColor(typeColors[3]);
			high_def.setTextColor(typeColors[3]);
			high_spa.setTextColor(typeColors[3]);
			high_spd.setTextColor(typeColors[3]);
			high_spe.setTextColor(typeColors[3]);
		}
		if(t.equals("Fairy")){
			iv_title.setTextColor(typeColors[4]);
			hp.setTextColor(typeColors[4]);
			attack.setTextColor(typeColors[4]);
			defense.setTextColor(typeColors[4]);
			special_attack.setTextColor(typeColors[4]);
			special_defense.setTextColor(typeColors[4]);
			speed.setTextColor(typeColors[4]);
			title2.setTextColor(typeColors[4]);
			high_hp.setTextColor(typeColors[4]);
			high_att.setTextColor(typeColors[4]);
			high_def.setTextColor(typeColors[4]);
			high_spa.setTextColor(typeColors[4]);
			high_spd.setTextColor(typeColors[4]);
			high_spe.setTextColor(typeColors[4]);
		}
		if(t.equals("Fighting")){
			iv_title.setTextColor(typeColors[5]);
			hp.setTextColor(typeColors[5]);
			attack.setTextColor(typeColors[5]);
			defense.setTextColor(typeColors[5]);
			special_attack.setTextColor(typeColors[5]);
			special_defense.setTextColor(typeColors[5]);
			speed.setTextColor(typeColors[5]);
			title2.setTextColor(typeColors[5]);
			high_hp.setTextColor(typeColors[5]);
			high_att.setTextColor(typeColors[5]);
			high_def.setTextColor(typeColors[5]);
			high_spa.setTextColor(typeColors[5]);
			high_spd.setTextColor(typeColors[5]);
			high_spe.setTextColor(typeColors[5]);
		}
		if(t.equals("Fire")){
			iv_title.setTextColor(typeColors[6]);
			hp.setTextColor(typeColors[6]);
			attack.setTextColor(typeColors[6]);
			defense.setTextColor(typeColors[6]);
			special_attack.setTextColor(typeColors[6]);
			special_defense.setTextColor(typeColors[6]);
			speed.setTextColor(typeColors[6]);
			title2.setTextColor(typeColors[6]);
			high_hp.setTextColor(typeColors[6]);
			high_att.setTextColor(typeColors[6]);
			high_def.setTextColor(typeColors[6]);
			high_spa.setTextColor(typeColors[6]);
			high_spd.setTextColor(typeColors[6]);
			high_spe.setTextColor(typeColors[6]);
		}
		if(t.equals("Flying")){
			iv_title.setTextColor(typeColors[7]);
			hp.setTextColor(typeColors[7]);
			attack.setTextColor(typeColors[7]);
			defense.setTextColor(typeColors[7]);
			special_attack.setTextColor(typeColors[7]);
			special_defense.setTextColor(typeColors[7]);
			speed.setTextColor(typeColors[7]);
			title2.setTextColor(typeColors[7]);
			high_hp.setTextColor(typeColors[7]);
			high_att.setTextColor(typeColors[7]);
			high_def.setTextColor(typeColors[7]);
			high_spa.setTextColor(typeColors[7]);
			high_spd.setTextColor(typeColors[7]);
			high_spe.setTextColor(typeColors[7]);
		}
		
		if(t.equals("Ghost")){
			iv_title.setTextColor(typeColors[8]);
			hp.setTextColor(typeColors[8]);
			attack.setTextColor(typeColors[8]);
			defense.setTextColor(typeColors[8]);
			special_attack.setTextColor(typeColors[8]);
			special_defense.setTextColor(typeColors[8]);
			speed.setTextColor(typeColors[8]);
			title2.setTextColor(typeColors[8]);
			high_hp.setTextColor(typeColors[8]);
			high_att.setTextColor(typeColors[8]);
			high_def.setTextColor(typeColors[8]);
			high_spa.setTextColor(typeColors[8]);
			high_spd.setTextColor(typeColors[8]);
			high_spe.setTextColor(typeColors[8]);
		}
		if(t.equals("Grass")){
			iv_title.setTextColor(typeColors[9]);
			hp.setTextColor(typeColors[9]);
			attack.setTextColor(typeColors[9]);
			defense.setTextColor(typeColors[9]);
			special_attack.setTextColor(typeColors[9]);
			special_defense.setTextColor(typeColors[9]);
			speed.setTextColor(typeColors[9]);
			title2.setTextColor(typeColors[9]);
			high_hp.setTextColor(typeColors[9]);
			high_att.setTextColor(typeColors[9]);
			high_def.setTextColor(typeColors[9]);
			high_spa.setTextColor(typeColors[9]);
			high_spd.setTextColor(typeColors[9]);
			high_spe.setTextColor(typeColors[9]);
		}
		if(t.equals("Ground")){
			iv_title.setTextColor(typeColors[10]);
			hp.setTextColor(typeColors[10]);
			attack.setTextColor(typeColors[10]);
			defense.setTextColor(typeColors[10]);
			special_attack.setTextColor(typeColors[10]);
			special_defense.setTextColor(typeColors[10]);
			speed.setTextColor(typeColors[10]);
			title2.setTextColor(typeColors[10]);
			high_hp.setTextColor(typeColors[10]);
			high_att.setTextColor(typeColors[10]);
			high_def.setTextColor(typeColors[10]);
			high_spa.setTextColor(typeColors[10]);
			high_spd.setTextColor(typeColors[10]);
			high_spe.setTextColor(typeColors[10]);
		}
		if(t.equals("Ice")){
			iv_title.setTextColor(typeColors[11]);
			hp.setTextColor(typeColors[11]);
			attack.setTextColor(typeColors[11]);
			defense.setTextColor(typeColors[11]);
			special_attack.setTextColor(typeColors[11]);
			special_defense.setTextColor(typeColors[11]);
			speed.setTextColor(typeColors[11]);
			title2.setTextColor(typeColors[11]);
			high_hp.setTextColor(typeColors[11]);
			high_att.setTextColor(typeColors[11]);
			high_def.setTextColor(typeColors[11]);
			high_spa.setTextColor(typeColors[11]);
			high_spd.setTextColor(typeColors[11]);
			high_spe.setTextColor(typeColors[11]);
		}
		if(t.equals("Normal")){
			iv_title.setTextColor(typeColors[12]);
			hp.setTextColor(typeColors[12]);
			attack.setTextColor(typeColors[12]);
			defense.setTextColor(typeColors[12]);
			special_attack.setTextColor(typeColors[12]);
			special_defense.setTextColor(typeColors[12]);
			speed.setTextColor(typeColors[12]);
			title2.setTextColor(typeColors[12]);
			high_hp.setTextColor(typeColors[12]);
			high_att.setTextColor(typeColors[12]);
			high_def.setTextColor(typeColors[12]);
			high_spa.setTextColor(typeColors[12]);
			high_spd.setTextColor(typeColors[12]);
			high_spe.setTextColor(typeColors[12]);
		}
		if(t.equals("Poison")){
			iv_title.setTextColor(typeColors[13]);
			hp.setTextColor(typeColors[13]);
			attack.setTextColor(typeColors[13]);
			defense.setTextColor(typeColors[13]);
			special_attack.setTextColor(typeColors[13]);
			special_defense.setTextColor(typeColors[13]);
			speed.setTextColor(typeColors[13]);
			title2.setTextColor(typeColors[13]);
			high_hp.setTextColor(typeColors[13]);
			high_att.setTextColor(typeColors[13]);
			high_def.setTextColor(typeColors[13]);
			high_spa.setTextColor(typeColors[13]);
			high_spd.setTextColor(typeColors[13]);
			high_spe.setTextColor(typeColors[13]);
		}
		if(t.equals("Psychic")){
			iv_title.setTextColor(typeColors[14]);
			hp.setTextColor(typeColors[14]);
			attack.setTextColor(typeColors[14]);
			defense.setTextColor(typeColors[14]);
			special_attack.setTextColor(typeColors[14]);
			special_defense.setTextColor(typeColors[14]);
			speed.setTextColor(typeColors[14]);
			title2.setTextColor(typeColors[14]);
			high_hp.setTextColor(typeColors[14]);
			high_att.setTextColor(typeColors[14]);
			high_def.setTextColor(typeColors[14]);
			high_spa.setTextColor(typeColors[14]);
			high_spd.setTextColor(typeColors[14]);
			high_spe.setTextColor(typeColors[14]);
		}
		
		if(t.equals("Rock")){
			iv_title.setTextColor(typeColors[15]);
			hp.setTextColor(typeColors[15]);
			attack.setTextColor(typeColors[15]);
			defense.setTextColor(typeColors[15]);
			special_attack.setTextColor(typeColors[15]);
			special_defense.setTextColor(typeColors[15]);
			speed.setTextColor(typeColors[15]);
			title2.setTextColor(typeColors[15]);
			high_hp.setTextColor(typeColors[15]);
			high_att.setTextColor(typeColors[15]);
			high_def.setTextColor(typeColors[15]);
			high_spa.setTextColor(typeColors[15]);
			high_spd.setTextColor(typeColors[15]);
			high_spe.setTextColor(typeColors[15]);
		}
		if(t.equals("Steel")){
			iv_title.setTextColor(typeColors[16]);
			hp.setTextColor(typeColors[16]);
			attack.setTextColor(typeColors[16]);
			defense.setTextColor(typeColors[1]);
			special_attack.setTextColor(typeColors[16]);
			special_defense.setTextColor(typeColors[16]);
			speed.setTextColor(typeColors[16]);
			title2.setTextColor(typeColors[16]);
			high_hp.setTextColor(typeColors[16]);
			high_att.setTextColor(typeColors[16]);
			high_def.setTextColor(typeColors[16]);
			high_spa.setTextColor(typeColors[16]);
			high_spd.setTextColor(typeColors[16]);
			high_spe.setTextColor(typeColors[16]);
		}
		if(t.equals("Water")){
			iv_title.setTextColor(typeColors[17]);
			hp.setTextColor(typeColors[17]);
			attack.setTextColor(typeColors[17]);
			defense.setTextColor(typeColors[17]);
			special_attack.setTextColor(typeColors[17]);
			special_defense.setTextColor(typeColors[17]);
			speed.setTextColor(typeColors[17]);
			title2.setTextColor(typeColors[17]);
			high_hp.setTextColor(typeColors[17]);
			high_att.setTextColor(typeColors[17]);
			high_def.setTextColor(typeColors[17]);
			high_spa.setTextColor(typeColors[17]);
			high_spd.setTextColor(typeColors[17]);
			high_spe.setTextColor(typeColors[17]);
		}
	}

}
