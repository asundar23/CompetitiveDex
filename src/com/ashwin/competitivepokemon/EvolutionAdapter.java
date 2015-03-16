package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class EvolutionAdapter extends BaseAdapter{
	
	Context ctx;
	ImageView preevolution;
	ImageView postevolution;
	TextView evolutionType;
	String name;
	int i;
	Pokemon pokemon;
	
	public EvolutionAdapter(Context c,String n){
		
		ctx = c;
		name = n;
		pokemon = new Pokemon(ctx,name);
	}
	
	public Drawable getImage(String n) {
		
		return ctx.getResources().getDrawable(
	            ctx.getResources().getIdentifier(n, "drawable",
	                    ctx.getPackageName()));    
		
	}

	@Override
	public int getCount() {
		return pokemon.getPreEvolutions().size();
	}

	@Override
	public Object getItem(int position) {
		return pokemon.getPostEvolutions().get(position);
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
		
		ArrayList<String> pre = new ArrayList<String>();
		ArrayList<String> post = new ArrayList<String>();
		ArrayList<String> type = new ArrayList<String>();
		
		pre = pokemon.getPreEvolutions();
		post = pokemon.getPostEvolutions();
		type = pokemon.getEvolutionType();
		
		
		
		String one;
		String two;
		
		rl = (RelativeLayout) convertView;
		
		if(rl == null)
		{
			li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.evolution_list_view, rl, true);
		}
		
		preevolution = (ImageView) rl.findViewById(R.id.preevolution);
		postevolution = (ImageView) rl.findViewById(R.id.postevolution);
		evolutionType = (TextView) rl.findViewById(R.id.evolutiontype);
		
		evolutionType.setText(type.get(position));
		
		one = pre.get(position);
		two = post.get(position);
		
		if(one.equals("Flabébé")) one = "flabebe";
		else if(one.equals("Nidoran♀")) two = "nidoranf";
		else if(one.equals("Nidoran♂")) one = "nidoranm";
		else if(one.equals("Farfetch'd")) one = "farfetchd";
		else if(one.equals("Mr. Mime")) one = "mrmime";
		else if (one.equals("Mime Jr.")) one = "mimejr";
		else{
        
	        Pattern pattern = Pattern.compile("\\s");
	        Matcher matcher = pattern.matcher(one);
	        boolean found = matcher.find();

	        if(found == true)
	        {
	        	String myArray[] = one.split(" ");
	            if(myArray.length == 2) one = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
	            else if(myArray.length == 3) one = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH)
	            		+myArray[2].toLowerCase(Locale.ENGLISH);
	            
	        }
	        
	        pattern = Pattern.compile("-");
	        matcher = pattern.matcher(one);
	        found = matcher.find();
	        
	        if(found == true)
	        {
	        	String myArray[] = one.split("-");
	            one = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
	        }
		}
		
		if(two.equals("Flabébé")) two = "flabebe";
		else if(two.equals("Farfetch'd")) two = "farfetchd";
		else if(two.equals("Mr. Mime")) two = "mrmime";
		else if(two.equals("Nidoran♀")) two = "nidoranf";
		else if(two.equals("Nidoran♂")) one = "nidoranm";
		else if (two.equals("Mime Jr.")) two = "mimejr";
		else{
        
	        Pattern pattern = Pattern.compile("\\s");
	        Matcher matcher = pattern.matcher(two);
	        boolean found = matcher.find();

	        if(found == true)
	        {
	        	String myArray[] = two.split(" ");
	            if(myArray.length == 2) two = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
	            else if(myArray.length == 3) two = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH)
	            		+myArray[2].toLowerCase(Locale.ENGLISH);
	            
	        }
	        
	        pattern = Pattern.compile("-");
	        matcher = pattern.matcher(two);
	        found = matcher.find();
	        
	        if(found == true)
	        {
	        	String myArray[] = two.split("-");
	            two = myArray[0].toLowerCase(Locale.ENGLISH)+""+myArray[1].toLowerCase(Locale.ENGLISH);
	        }
		}
		
		preevolution.setImageDrawable(getImage(one.toLowerCase(Locale.ENGLISH)+"_pic"));
		postevolution.setImageDrawable(getImage(two.toLowerCase(Locale.ENGLISH)+"_pic"));
		
		
		
		i = position;
		
		switch(i){
		
		case 0:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(0));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(0));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			break;
		}
		
		case 1:{
				preevolution.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(ctx, Tabs.class);
						Log.d("i is now ",i+"");
						intent.putExtra("name", pokemon.getPreEvolutions().get(1));
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		                ctx.startActivity(intent);	
					}
				});
				
				postevolution.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(ctx, Tabs.class);
						Log.d("i is now ",i+"");
						intent.putExtra("name", pokemon.getPostEvolutions().get(1));
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		                ctx.startActivity(intent);	
					}
				});
				
				break;
			}
			
		case 2:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(2));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(2));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			break;
		}
		
		case 3:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(3));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(3));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			break;
		}
		
		case 4:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(4));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(4));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			break;
		}
		
		case 5:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(5));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(5));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			break;
		}
		
		case 6:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(6));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(6));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			break;
		}
		
		case 7:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(7));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(7));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			break;
		}
		
		case 8:{
			preevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPreEvolutions().get(8));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);	
				}
			});
			
			postevolution.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ctx, Tabs.class);
					intent.putExtra("name", pokemon.getPostEvolutions().get(8));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	                ctx.startActivity(intent);
	                ((Activity) ctx).finish();
				}
			});
			
			break;
		}
		}
		
		
		
		
		return rl;
	}
		
		

}
