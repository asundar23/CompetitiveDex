package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class HiddenPower extends Activity{
	
	TextView text;
	RadioGroup group;
	RadioButton option1;
	int pos;
	Button go;
	String[] types = {"Bug","Dark","Dragon","Electric","Fighting","Fire","Flying","Ghost"
			,"Grass","Ground","Ice","Poison","Psychic","Rock","Steel","Water"};
	RadioButton option2;
	RadioButton option3;
	Spinner spinner;
	RadioButton option4;
	
	public void onCreate(Bundle bundle){
		
		super.onCreate(bundle);
		setContentView(R.layout.hiddenpowercalculator);
		
		text = (TextView) findViewById(R.id.question);
		group = (RadioGroup) findViewById(R.id.group);
		option1 = (RadioButton) findViewById(R.id.yes);
		option2 = (RadioButton) findViewById(R.id.no);
		option3 = (RadioButton) findViewById(R.id.maybe);
		option4 = (RadioButton) findViewById(R.id.option4);
		
		go = (Button) findViewById(R.id.go);
		go.setVisibility(View.GONE);
		
		option4.setVisibility(View.GONE);
		
		spinner = (Spinner) findViewById(R.id.spinnerTypes);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,types);
		spinner.setAdapter(adapter);
		
		spinner.setVisibility(View.GONE);
		option3.setVisibility(View.GONE);
		
		option1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				option1.setChecked(false);
				
				text.setText("Did the move hit Kecleon?");
				option1.setText("Yes");
				option2.setText("No");
				
				option1.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						go.setVisibility(View.VISIBLE);
						
						text.setText("What type did Kecleon turn into?");
						spinner.setVisibility(View.VISIBLE);
						option1.setVisibility(View.GONE);
						option2.setVisibility(View.GONE);
						option3.setVisibility(View.GONE);
						
						spinner.setPrompt("Choose the type");
						
						spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

							@Override
							public void onItemSelected(AdapterView<?> parent,
									View view, int position, long id) {
								
								pos = position;
								
								go.setOnClickListener(new OnClickListener(){
									@Override
									public void onClick(View v) {
										go.setVisibility(View.GONE);
										text.setGravity(Gravity.CENTER);
										spinner.setVisibility(View.GONE);
										text.setText("Your Hidden Power is "+ types[pos]);
										
									}
									
								});
								
								
							}

							@Override
							public void onNothingSelected(AdapterView<?> parent) {
								// TODO Auto-generated method stub
								
							}
							
						});
					}
					
				});
				
				option2.setOnClickListener(new OnClickListener(){
					
					

					@Override
					public void onClick(View v) {
						
						option2.setChecked(false);
						
						text.setVisibility(View.VISIBLE);
						text.setText("Your Hidden Power is Ghost.");
						option1.setVisibility(View.GONE);
						option2.setVisibility(View.GONE);
						option3.setVisibility(View.GONE);
						spinner.setVisibility(View.GONE);
					}
					
				});
				
			}
			
		});
		
		option2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				option2.setChecked(false);
				
				text.setText("Use Hidden Power on a pure Psychic type, like Gothorita or Wynaut. What does the move hit for?");
				option1.setText("Super Effective");
				option2.setText("Not Very Effective");
				
				option3.setVisibility(View.VISIBLE);
				option3.setText("Neutral Damage");
				
				option1.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						option1.setChecked(false);
						
						option1.setText("Use Hidden Power on a Normal/Flying type such as Pidgey, Hoothoot, or Taillow." +
								"What does the move hit for");
						
						option1.setText("Not Very Effective");
						option2.setText("Neutral Damage");
						option3.setText("Unaffected");
						
						option1.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								
								option1.setChecked(false);
								text.setVisibility(View.VISIBLE);
								text.setText("Your Hidden Power is Bug.");
								option1.setVisibility(View.GONE);
								option2.setVisibility(View.GONE);
								option3.setVisibility(View.GONE);
								spinner.setVisibility(View.GONE);
								
							}
							
						});
						
						option2.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								option2.setChecked(false);
								text.setVisibility(View.VISIBLE);
								text.setText("Your Hidden Power is Dark.");
								option1.setVisibility(View.GONE);
								option2.setVisibility(View.GONE);
								option3.setVisibility(View.GONE);
								spinner.setVisibility(View.GONE);
								
							}
							
						});
						
						option3.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								option3.setChecked(false);
								text.setVisibility(View.VISIBLE);
								text.setText("Your Hidden Power is Ghost.");
								option1.setVisibility(View.GONE);
								option2.setVisibility(View.GONE);
								option3.setVisibility(View.GONE);
								spinner.setVisibility(View.GONE);
								
							}
							
						});
						
					}
					
				});
				
				option2.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						option2.setChecked(false);
						option3.setVisibility(View.GONE);
						spinner.setVisibility(View.GONE);
						text.setText("Use Hidden Power on a monotype Poison type, like Weezing or Muk. " +
								"What does the move hit for?");
						option1.setText("Super Effective");
						option2.setText("Not Very Effective");
						
						option1.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								option1.setChecked(false);
								text.setVisibility(View.VISIBLE);
								text.setText("Your Hidden Power is Psychic.");
								option1.setVisibility(View.GONE);
								option2.setVisibility(View.GONE);
								option3.setVisibility(View.GONE);
								spinner.setVisibility(View.GONE);
								
							}
							
						});
						
						option2.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								option2.setChecked(false);
								text.setVisibility(View.VISIBLE);
								text.setText("Your Hidden Power is Fighting.");
								option1.setVisibility(View.GONE);
								option2.setVisibility(View.GONE);
								option3.setVisibility(View.GONE);
								spinner.setVisibility(View.GONE);
								
							}
							
						});
						
					}
					
				});
				
				option3.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						option3.setChecked(false);
						text.setText("Use Hidden Power on a pure-Bug type like Scatterbug." +
								"What is the damage output?");
						
						option1.setText("Super Effective");
						option2.setText("Not Very Effective");
						option3.setText("Neutral Damage");
						
						option1.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								
								option1.setChecked(false);
								
									text.setText("Use Hidden Power on a monotype Fire type, such as Heatmor." +
											"What does the move hit for?");
									
									option1.setText("Super Effective");
									option2.setText("Not Very Effective");
									option3.setText("Neutral Damage");
									
									option1.setOnClickListener(new OnClickListener(){

										@Override
										public void onClick(View v) {
											option1.setChecked(false);
											text.setVisibility(View.VISIBLE);
											text.setText("Your Hidden Power is Rock.");
											option1.setVisibility(View.GONE);
											option2.setVisibility(View.GONE);
											option3.setVisibility(View.GONE);
											spinner.setVisibility(View.GONE);
											
										}
										
									});
									option2.setOnClickListener(new OnClickListener(){

										@Override
										public void onClick(View v) {
											option2.setChecked(false);
											text.setVisibility(View.VISIBLE);
											text.setText("Your Hidden Power is Fire.");
											option1.setVisibility(View.GONE);
											option2.setVisibility(View.GONE);
											option3.setVisibility(View.GONE);
											spinner.setVisibility(View.GONE);
											
										}
										
									});
									option3.setOnClickListener(new OnClickListener(){

										@Override
										public void onClick(View v) {
											option3.setChecked(false);
											text.setVisibility(View.VISIBLE);
											text.setText("Your Hidden Power is Flying.");
											option1.setVisibility(View.GONE);
											option2.setVisibility(View.GONE);
											option3.setVisibility(View.GONE);
											spinner.setVisibility(View.GONE);
										}
										
									});
								
							}
							
						});
						option2.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								option2.setChecked(false);
								text.setText("Use Hidden Power on a monotype Fire type, such as Feraligatr or Milotic." +
										"What does the move hit for?");
								
								option1.setText("Super Effective");
								option2.setText("Neutral Damage");
								option3.setVisibility(View.GONE);
								
								option1.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										option1.setChecked(false);
										text.setVisibility(View.VISIBLE);
										text.setText("Your Hidden Power is Grass.");
										option1.setVisibility(View.GONE);
										option2.setVisibility(View.GONE);
										option3.setVisibility(View.GONE);
										spinner.setVisibility(View.GONE);
									}
									
								});
								
								option2.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										option2.setChecked(false);
										text.setVisibility(View.VISIBLE);
										text.setText("Your Hidden Power is Ground.");
										option1.setVisibility(View.GONE);
										option2.setVisibility(View.GONE);
										option3.setVisibility(View.GONE);
										spinner.setVisibility(View.GONE);
									}
									
								});
								
							}
							
						});
						
						option3.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								option3.setChecked(false);
								text.setVisibility(View.VISIBLE);
								option1.setVisibility(View.VISIBLE);
								option2.setVisibility(View.VISIBLE);
								option3.setVisibility(View.VISIBLE);
								
								text.setText("Use Hidden Power on a dual-type Rock/Ground type, such as Geodude" +
										" or Rhydon. " +
										"What does the move hit for?");
								
								option1.setText("Super Effective");
								option2.setText("Not Very Effective");
								option3.setText("Neutral Damage");
								
								option4.setVisibility(View.VISIBLE);
								option4.setText("Unaffected");
								
								option1.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										option1.setChecked(false);
										text.setVisibility(View.VISIBLE);
										text.setText("Your Hidden Power is Water.");
										option1.setVisibility(View.GONE);
										option2.setVisibility(View.GONE);
										option3.setVisibility(View.GONE);
										option4.setVisibility(View.GONE);
										spinner.setVisibility(View.GONE);
									}
									
								});
								
								option2.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										option2.setChecked(false);
										text.setVisibility(View.VISIBLE);
										text.setText("Your Hidden Power is Poison.");
										option1.setVisibility(View.GONE);
										option2.setVisibility(View.GONE);
										option3.setVisibility(View.GONE);
										option4.setVisibility(View.GONE);
										spinner.setVisibility(View.GONE);
									}
																	
								});
								
								option3.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										option3.setChecked(false);
										text.setVisibility(View.VISIBLE);
										text.setText("Your Hidden Power is Dragon.");
										option1.setVisibility(View.GONE);
										option2.setVisibility(View.GONE);
										option3.setVisibility(View.GONE);
										option4.setVisibility(View.GONE);
										spinner.setVisibility(View.GONE);
									}
									
								});
								
								option4.setOnClickListener(new OnClickListener(){

									@Override
									public void onClick(View v) {
										option4.setChecked(false);
										text.setVisibility(View.VISIBLE);
										text.setText("Your Hidden Power is Electric.");
										option1.setVisibility(View.GONE);
										option2.setVisibility(View.GONE);
										option3.setVisibility(View.GONE);
										option4.setVisibility(View.GONE);
										spinner.setVisibility(View.GONE);
									}
									
								});
								
							}
							
						});
						
					}
					
				});
			}
			
		});
		
	}

}
