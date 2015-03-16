package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;


public class Natures extends Activity{
	
	String[] neutralNature;
	String[] positiveNature;
	TextView text;
	GridView neutralGrid;
	GridView positiveGrid;
	ArrayAdapter<String> neutralArray;
	ArrayAdapter<String> positiveArray;
	Context ctx;
	
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.natures);
		
		ctx = getBaseContext();
		
		positiveGrid = (GridView) findViewById(R.id.natureGV);
		text = (TextView) findViewById(R.id.natureIntro);
		
		text.setText(Html.fromHtml("Natures are, in short, a Pokemon's personality. They also affect two stats, one positively and one negatively. <br /><br />The positive stat will have a 10% increase, and negative will be 10% decrease, and there are 5 natures that don't do anything at all. <br /><br />The natures that don't do anything are: <b>Bashful</b>, <b>Docile</b>, <b>Hardy</b>, <b>Quirky</b>, and <b>Serious</b>. Here are all the natures, in order of the beneficial stat:"));
		
		positiveNature = getResources().getStringArray(R.array.positive_natures);
		
		positiveArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,positiveNature);
		
		StatTrainingAdapter adapter = new StatTrainingAdapter(ctx,positiveNature);
		
		
	    
	    ViewGroup.LayoutParams params2 = positiveGrid.getLayoutParams();
	    params2.height = 8*47;
	    positiveGrid.setLayoutParams(params2);
	    positiveGrid.requestLayout();
		
		positiveGrid.setAdapter(adapter);
		
		
		positiveGrid.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						Natures.this);
				
				LayoutInflater inflater = (LayoutInflater)   getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
				View viewTV = inflater.inflate(R.layout.dialog_text_view, null);
				
				TextView tv = (TextView) viewTV.findViewById(R.id.dialog_tv);
				
				alertDialogBuilder.setTitle(positiveNature[position]);

				alertDialogBuilder
					.setCancelable(true)
					.setNegativeButton("Close", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			                dialog.cancel();
			            }
					  });
				
				if(position == 0) tv.setText(Html.fromHtml("+ Attack<br /><br />- Defense"));
				if(position == 1) tv.setText(Html.fromHtml("+ Attack<br /><br />- Special Attack"));
				if(position == 2) tv.setText(Html.fromHtml("+ Attack<br /><br />- Special Defense"));
				if(position == 3) tv.setText(Html.fromHtml("+ Attack<br /><br />- Speed"));
				if(position == 4) tv.setText(Html.fromHtml("+ Defense<br /><br />- Attack"));
				if(position == 5) tv.setText(Html.fromHtml("+ Defense<br /><br />- Special Attack"));
				if(position == 6) tv.setText(Html.fromHtml("+ Defense<br /><br />- Special Defense"));
				if(position == 7) tv.setText(Html.fromHtml("+ Defense<br /><br />- Speed"));
				if(position == 8) tv.setText(Html.fromHtml("+ Special Attack<br /><br />- Attack"));
				if(position == 9) tv.setText(Html.fromHtml("+ Special Attack<br /><br />- Defense"));
				if(position == 10) tv.setText(Html.fromHtml("+ Special Attack<br /><br />- Special Defense"));
				if(position == 11) tv.setText(Html.fromHtml("+ Special Attack<br /><br />- Speed"));
				if(position == 12) tv.setText(Html.fromHtml("+ Special Defense<br /><br />- Attack"));
				if(position == 13) tv.setText(Html.fromHtml("+ Special Defense<br /><br />- Defense"));
				if(position == 14) tv.setText(Html.fromHtml("+ Special Defense<br /><br />- Special Attack"));
				if(position == 15) tv.setText(Html.fromHtml("+ Special Defense<br /><br />- Speed"));
				if(position == 16) tv.setText(Html.fromHtml("+ Speed<br /><br />- Attack"));
				if(position == 17) tv.setText(Html.fromHtml("+ Speed<br /><br />- Defense"));
				if(position == 18) tv.setText(Html.fromHtml("+ Speed<br /><br />- Special Attack"));
				if(position == 19) tv.setText(Html.fromHtml("+ Speed<br /><br />- Special Defense"));
				
				alertDialogBuilder.setView(viewTV);
				
					AlertDialog alertDialog = alertDialogBuilder.create();

					alertDialog.show();
				
			}
			
		});
	}

}
