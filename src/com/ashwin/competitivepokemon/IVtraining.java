package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class IVtraining extends Activity{
	
	ImageView image;
	TextView text;
	Button previous;
	Button next;
	int pageNumber;
	String x;
	Spinner spinner;
	TextView title;
	TextView pageNumberTV;
	ArrayAdapter<String> adapter;
	
	Animation fadeInAnimation;
	Animation fadeOutAnimation;
	
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.evtrainingguide);
		
		previous = (Button) findViewById(R.id.previous);
		next = (Button) findViewById(R.id.next);
		text = (TextView) findViewById(R.id.evText);
		image = (ImageView) findViewById(R.id.evimage);
		title = (TextView) findViewById(R.id.evTitle);
		spinner = (Spinner) findViewById(R.id.spinnerEv);
		pageNumberTV = (TextView) findViewById(R.id.pageNumber);
		
		text.setMovementMethod(LinkMovementMethod.getInstance());
		
		fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		//Now Set your animation
		
		String[] chapters = { "Introduction", "Getting Perfect IV's"};
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,chapters);
		spinner.setAdapter(adapter);
		
		spinner.setPrompt("Chapters");
		
		fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
		
		pageNumber = 1;
		pageNumberTV.setText(pageNumber+"");
		
		setStuff("ev_beginning");
		setSpinner();
		setButtons();
	}
	
	public void setSpinner()
	{
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(position == 0) {
					title.setText("Introduction");
					image.startAnimation(fadeOutAnimation);
					text.startAnimation(fadeOutAnimation);
					pageNumber = 1;
					setStuff("ev_beginning");
					pageNumberTV.setText(pageNumber+"");
					image.startAnimation(fadeInAnimation);
					text.startAnimation(fadeInAnimation);					
				}
				if(position == 1){
					title.setText("Getting Perfect IV's");
					image.startAnimation(fadeOutAnimation);
					text.startAnimation(fadeOutAnimation);
					pageNumber = 4;
					setStuff("azumarill_shiny");
					pageNumberTV.setText(pageNumber+"");
					image.startAnimation(fadeInAnimation);
					text.startAnimation(fadeInAnimation);
				}
				
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void setButtons()
	{
		next.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				pageNumber++;
				if(pageNumber==7) pageNumber = 1;
				
				setPages();
				pageNumberTV.setText(pageNumber+"");
			}
			
		});
		
		previous.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				--pageNumber;
				if(pageNumber==0) pageNumber = 6;
				
				setPages();
				pageNumberTV.setText(pageNumber+"");
			}
			
		});
		
		
	}
	
	public void setPages(){
		if(pageNumber == 1)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("ev_beginning");
			title.setText("Introduction");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber == 2)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			
			setStuff("abomasnow");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber == 3)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("megaabsol");
			title.setText("Introduction");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber == 4)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("azumarill_shiny");
			title.setText("Getting Perfect IV's");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber == 5)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("cinccino");
			title.setText("Getting Perfect IV's");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber == 6)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("lanturn");
			title.setText("Getting Perfect IV's");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
	}
	
	public void setStuff(String x)
	{
		text.setText(Html.fromHtml(setText(pageNumber)));
			
		int id = getResources().getIdentifier("com.example.competitivepokemon:drawable/" + x, null, null);
		image.setImageResource(id);
	}
	
	public String setText(int p)
	{
		if(p == 1){
			return "IV's are a lot more complicated than EV's. They stand for Individual Values, and are determined from when the Pokémon egg hatches. " +
					"<br /><br />" +
					"IV's can range from 0-31, with each IV counting as a stat point. A Pokémon with 31 is said to have a perfect IV in that stat, and you can get up to six perfect IV's. Getting six perfect IV's is incredibly unlikely, but getting five is very possible. ";
		}
		
		if(p == 2){
			return "You can check your IV's in Kilouide City, inside the Pokémon center. Talk to the person next to the change room, and they'll tell you which stats have good IV's and which aren't.";
		}
		
		if(p == 3){
			return "If you think about it, most Pokémon have a stat they don't need to maximize anyways. Physical sweepers won't need to have a good Special Attack, and vice versa. Bulky Pokémon sometimes won't need an amazing Speed IV, and walls won't need great Attack or Special Attack IV's." +
					"<br /><br />" +
					"To elaborate, getting a perfect IV in Special Attack for a Physical sweeper is highly unnecessary. You're better off getting them in HP, Attack, Defense, Special Defense, and Speed." +
					"<br /><br />" +
					"In addition, if you want to go that extra mile, you don't need perfect Defense and Special Defense IV's in a sweeper, but it's good to have in case. You <i>should</i> have perfect IV's in the stats you intend on utilizing, though.";
		}
		
		if(p==4){
			return "So how do you get perfect IV's in these 5 stats? We'll approach this from a cold to hot scale, with each point made will be better than the previous one. " +
					"<br /><br />" +
					"• There is just catching a Pokémon, but getting good IV's is simply not going to happen. Don't do this." +
					"<br /><br />" +
					"• You can go online and ask for Pokémon with good IV's. Good places to go on are <a href=\"http://www.reddit.com/r/Pokemontrades\">Pokémon Trades Subreddit</a> and <a href=\"http://www.pokebay.com/\">Pokebay</a>. Then again, you need a good IV'ed Pokémon to even trade for one in the first place. We're getting there, though." +
					"<br /><br />" +
					"• The Friend Safari in Pokémon X&Y is a good method to start IV training. Each Pokémon there, guaranteed, will always have at least two perfect IV's. It's a good place to start breeding and eventually get there." +
					"<br /><br />" +
					"• Breeding. This is the best way to go, and it heavily involves having a Pokémon with good IV's to begin with. For this to work, you'll need two items: " +
					"<br /><br />" +
					"<font color='#FF5F5F'>Destiny Knot</font> to pass down 5 IV's from the parents combined, and the <font color='#FF5F5F'>Everstone</font> to pass down the desired nature. If a compatible parent has pretty good IV's, you can breed it with your desired Pokémon (make sure either the desired one is female, or the compatible parent is a Ditto). ";
		}
		
		if(p==5){
			return 
					"The fastest way to do this is to collect eggs from the Daycare Center, and keep each one in the PC Box. Then, after you have five eggs, put them all in your party, and fly to the center of Lumoise City, where the gym is. " +
					"<br /><br />" +
					"Make sure your leading Pokémon has Flame Body, as this hatches the egg quicker. <font color = '#A366A3'>Talonflame</font> is the best Pokémon for this job, as it can Fly to Lumoise City and has Flame Body. ";
		}
		
		if(p==6){
			return
					"IV training is difficult, but it makes for the best competitive team. Many players like to just max the important stats, like HP, Attack, and Speed in a Physical sweeper. " +
					"<br /><br />" +
					"That's fine to do, but to go that extra mile for IV training is well worth it.";
		}

		return "";
	}

}
