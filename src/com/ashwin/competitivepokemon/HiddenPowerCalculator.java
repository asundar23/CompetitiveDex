package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HiddenPowerCalculator extends Activity{
	
	TextView text;
	EditText hp_edit;
	EditText att_edit;
	EditText def_edit;
	EditText spa_edit;
	EditText spd_edit;
	EditText spe_edit;
	Button button;
	
	String hiddenpower;
	
	int hp;
	int att;
	int def;
	int spa;
	int spd;
	int spe;
	
	String chp;
	
	int finalNumber;
	
	public void onCreate(Bundle bundle){
		
		super.onCreate(bundle);
		setContentView(R.layout.hiddenpower_calc);
		
		text = (TextView) findViewById(R.id.hiddenpower);
		button = (Button) findViewById(R.id.buttonHP);
		hp_edit = (EditText) findViewById(R.id.hp_edit3);
		att_edit = (EditText) findViewById(R.id.att_edit3);
		def_edit = (EditText) findViewById(R.id.def_edit3);
		spa_edit = (EditText) findViewById(R.id.spa_edit3);
		spd_edit = (EditText) findViewById(R.id.spd_edit3);
		spe_edit = (EditText) findViewById(R.id.spe_edit3);
		
		finalNumber = 0;
		
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				try{
					hp = Integer.parseInt(hp_edit.getText().toString());
					att = Integer.parseInt(att_edit.getText().toString());
					def = Integer.parseInt(def_edit.getText().toString());
					spa = Integer.parseInt(spa_edit.getText().toString());
					spd = Integer.parseInt(spd_edit.getText().toString());
					spe = Integer.parseInt(spe_edit.getText().toString());
					
					finalNumber = (int) (((hp % 2) + 2*(att % 2) + 4*(def % 2) + 8*(spa % 2) + 16*(spd % 2) + 32*(spe % 2)) * 15)/63;
					
					if(finalNumber==0) hiddenpower = "Fighting";
					if(finalNumber==1) hiddenpower = "Flying";
					if(finalNumber==2) hiddenpower = "Poison";
					if(finalNumber==3) hiddenpower = "Ground";
					if(finalNumber==4) hiddenpower = "Rock";
					if(finalNumber==5) hiddenpower = "Bug";
					if(finalNumber==6) hiddenpower = "Ghost";
					if(finalNumber==7) hiddenpower = "Steel";
					if(finalNumber==8) hiddenpower = "Fire";
					if(finalNumber==9) hiddenpower = "Water";
					if(finalNumber==10) hiddenpower = "Bug";
					if(finalNumber==11) hiddenpower = "Electric";
					if(finalNumber==12) hiddenpower = "Psychic";
					if(finalNumber==13) hiddenpower = "Ice";
					if(finalNumber==14) hiddenpower = "Dragon";
					if(finalNumber==15) hiddenpower = "Dark";
					
					text.setText("Your Hidden Power type is " + hiddenpower);
					text.setTextColor(Color.WHITE);
					
					if(finalNumber < 0 || 
							finalNumber > 15 ||
							hp < 0 ||
							hp > 31 ||
							att < 0 ||
							att > 31 ||
							def < 0 ||
							def > 31 ||
							spa < 0 ||
							spa > 31 ||
							spd < 0 ||
							spd > 31 ||
							spe < 0 ||
							spe > 31){
						text.setText("IV's have a maximum of 31 and a minimum of 0, so your Hidden Power type could not be determined.");
						text.setTextColor(Color.RED);
					}
				}
				catch (NumberFormatException e){
					text.setText("Invalid input. Your Hidden Power type could not be determined.");
					text.setTextColor(Color.RED);
				}
				
				
			}
			
		});
		
	}

}
