package com.ashwin.competitivepokemon;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class PokemonAbilitiesAdapter extends BaseAdapter{
	
	Context ctx;
	ImageView pokemonImage;
	TextView pokemonName;
	ArrayList<String> pokemonList;
	
	public PokemonAbilitiesAdapter(Context c,ArrayList<String> a)
	{
		ctx = c;
		pokemonList = a;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pokemonList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return pokemonList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater li;
		RelativeLayout rl;
		
		rl = (RelativeLayout) convertView;
		
		if (rl == null) {
            li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.gridview_adapter, rl, true);
        }

			pokemonImage = (ImageView) rl.findViewById(R.id.compatibleImageView);
			pokemonName = (TextView) rl.findViewById(R.id.compatibleName);
				if(pokemonList.get(position).equals("Farfetch'd"))
				{
					pokemonImage.setImageDrawable(getImage("farfetchd"));
				}
				else if(pokemonList.get(position).equals("Nidoran-♂"))
				{
					pokemonImage.setImageDrawable(getImage("nidoran_m"));
				}
				else if(pokemonList.get(position).equals("Mr. Mime"))
				{
					pokemonImage.setImageDrawable(getImage("mrmime"));
				}
				else
				{
					
					String pokemonName = pokemonList.get(position);
					Pattern pattern = Pattern.compile("\\s");
			        Matcher matcher = pattern.matcher(pokemonName);
			        boolean found = matcher.find();

			        if(found == true)
			        {
			        	String myArray[] = pokemonName.split(" ");
			            if(myArray.length == 2) pokemonName = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
			            else if(myArray.length == 3) pokemonName = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH)
			            		+myArray[2].toLowerCase(Locale.ENGLISH);
			            
			        }
			        
			        pattern = Pattern.compile("-");
			        matcher = pattern.matcher(pokemonName);
			        found = matcher.find();
			        
			        if(found == true)
			        {
			        	String myArray[] = pokemonName.split("-");
			        	pokemonName = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
			        }
			        Log.d("tag",pokemonName);
					pokemonImage.setImageDrawable(getImage(pokemonName.
							toLowerCase(Locale.ENGLISH)));
				}
				

				
				
				pokemonName.setTextSize(18);
				
				android.view.ViewGroup.LayoutParams layoutParams = pokemonImage.getLayoutParams();
				layoutParams.width = 175;
				layoutParams.height = 175;
				pokemonImage.setLayoutParams(layoutParams);
			
			
				pokemonName.setText(pokemonList.get(position));
			
		
		return rl;
	}
	
	public Drawable getImage(String name) {
		
		Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(name);
        boolean found = matcher.find();
        
        if(found == true)
        {
        	String myArray[] = name.split(" ");
            name = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
        }
        
        pattern = Pattern.compile("-");
        matcher = pattern.matcher(name);
        found = matcher.find();
        
        if(found == true)
        {
        	String myArray[] = name.split("-");
            name = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
        }
		
		return ctx.getResources().getDrawable(
	            ctx.getResources().getIdentifier(name, "drawable",
	                    ctx.getPackageName()));    
		
		
}

}
