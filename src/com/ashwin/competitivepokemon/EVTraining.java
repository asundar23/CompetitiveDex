package com.ashwin.competitivepokemon;

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
import com.ashwin.competitivepokemon.R;

public class EVTraining extends Activity{
	
	ImageView image;
	TextView text;
	Button previous;
	Button next;
	int pageNumber;
	String x;
	Spinner spinner;
	TextView title;
	String[] chapters;
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
		
		chapters = getResources().getStringArray(R.array.EVChapters);
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
					title.setText("Power Items");
					image.startAnimation(fadeOutAnimation);
					text.startAnimation(fadeOutAnimation);
					pageNumber = 6;
					setStuff("lanturn");
					pageNumberTV.setText(pageNumber+"");
					image.startAnimation(fadeInAnimation);
					text.startAnimation(fadeInAnimation);
				}
				if(position == 2){
					title.setText("Pokérus");
					image.startAnimation(fadeOutAnimation);
					text.startAnimation(fadeOutAnimation);
					pageNumber = 8;
					setStuff("clefable");
					pageNumberTV.setText(pageNumber+"");
					image.startAnimation(fadeInAnimation);
					text.startAnimation(fadeInAnimation);
					
				}
				if(position == 3){
					title.setText("Battling Wild Pokémon");
					image.startAnimation(fadeOutAnimation);
					text.startAnimation(fadeOutAnimation);
					pageNumber = 10;
					setStuff("muk");
					pageNumberTV.setText(pageNumber+"");
					image.startAnimation(fadeInAnimation);
					text.startAnimation(fadeInAnimation);
				}
				
				if(position == 4){
					title.setText("Super Training");
					image.startAnimation(fadeOutAnimation);
					text.startAnimation(fadeOutAnimation);
					pageNumber = 12;
					setStuff("eastseagastrodon_shiny");
					pageNumberTV.setText(pageNumber+"");
					image.startAnimation(fadeInAnimation);
					text.startAnimation(fadeInAnimation);
				}
				
				if(position == 5){
					title.setText("Horde Battles");
					image.startAnimation(fadeOutAnimation);
					text.startAnimation(fadeOutAnimation);
					pageNumber = 16;
					setStuff("megacharizardy");
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
				if(pageNumber==19) pageNumber = 1;
				
				setPages();
				pageNumberTV.setText(pageNumber+"");
			}
			
		});
		
		previous.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				--pageNumber;
				if(pageNumber==0) pageNumber = 18;
				
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
			spinner.setSelection(0);
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
			title.setText("Introduction");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber == 5)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("cinccino");
			title.setText("Introduction");
			
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber == 6)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("lanturn");
			spinner.setSelection(1);
			title.setText("Power Items");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		
		if(pageNumber ==7)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("igglybuff");
			title.setText("Power Items");
			
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 8)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("clefable");
			title.setText("Pokérus");
			spinner.setSelection(2);
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 9)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("whitekyurem");
			title.setText("Pokérus");
			
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 10)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("muk");
			title.setText("Battling Wild Pokémon");
			spinner.setSelection(3);
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 11)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("slurpuff");
			title.setText("Battling Wild Pokémon");
			
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 12)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("eastseagastrodon_shiny");
			title.setText("Super Training");
			spinner.setSelection(4);
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 13)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("westseagastrodon_shiny");
			title.setText("Super Training");
			
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 14)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("megamewtwox");
			title.setText("Super Training");
			
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 15)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("blastoise");
			title.setText("Super Training");
			
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 16)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("megacharizardy");
			title.setText("Horde Battles");
			spinner.setSelection(5);
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 17)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("excadrill");
			title.setText("Horde Battles");
			image.startAnimation(fadeInAnimation);
			text.startAnimation(fadeInAnimation);
		}
		if(pageNumber == 18)
		{
			image.startAnimation(fadeOutAnimation);
			text.startAnimation(fadeOutAnimation);
			setStuff("espurr");
			title.setText("Horde Battles");
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
			return "EV's stand for Effort Values, which are one of the two ways to train Pokémon. " +
					"<br /><br />" +
					"Effort Values, unlike IV's (Individual Values), are not determined by birth, " +
					"but instead are by battling and maximizing certain stats.";
		}
		
		if(p == 2){
			return "The maximum amount of total EV's you can give your Pokémon is 510, and the most you can give in a certain stat is 252. " +
					"<br /><br />" +
					"Every 4 EV's counts as 1 stat raise for the Pokémon, so 252 EV's would increase a certain stat by 63 points.";
		}
		
		if(p == 3){
			return "Knowing which stat to EV train in your Pokémon is dependent on two things: experience and knowledge of how stat distribution works. " +
					"<br /><br />" +
					"Not every Pokémon will necessarily have 252 EV's in a stat; sometimes they need 100, 152, 88, or any other number divisible by four. " +
					"<br /><br />" +
					"Figuring out what this number is is difficult, but can be achieved by using simulators such as Pokémon Showdown! to figure it out. ";
		}
		
		if(p==4){
			return "As a general rule of thumb, we can make certain rules for EV training Pokémon:" +
					"<br /><br />" +
					"• If a Pokémon has a very high Attack stat (say at least 85 base Attack), usually you want to use 252 Attack EV's." +
					"<br /><br />" +
					"• The inverse works for Special Attack as well." +
					"<br /><br />" +
					"• If they have decent HP and low Speed, use 252 HP EV's (at least base 60 HP)." +
					"<br /><br />" +
					"• If they are a fast Pokémon, use 252 EV's (at least 85 base Speed)." +
					"<br /><br />" +
					"• Defense and Special Defense are interesting cases, because sometimes a Pokémon excels in offense as well as defense. Sometimes, the Defense is extremely high, so investing in a mediocre Special Defense is the wiser choice. Maybe the Attack stat is really high, so investing in Attack is more important than investing in Defense. " +
					"<br /><br />" +
					"  Investing in the defenses is largely dependent on your team makeup and your preference for walls";
		}
		
		if(p==5){
			return "So now the question is: how do you EV train?" +
					"<br /><br />" +
					"Well, the question you have to then ask is: what items " +
					"are the Pokémon holding and does it have <font color='#FF5F5F'><font color='#FF5F5F'>Pokérus</font></font>?" +
					"<br /><br />" +
					"Before you get confused, allow me to elaborate" + 
					"<br /><br />" +
					"There are certain items that will boost your Pokémon's EV's when battling. ";
		}
		
		if(p==6){
			return 
					"These are called Power items, and there are 6 of them: " +
					"<font color='#FF5F5F'>Power Anklet</font> (for speed), <font color='#FF5F5F'>Power Bracer</font> " +
					"(for attack), <font color='#FF5F5F'>Power Weight</font>" +
					" (for HP), <font color='#FF5F5F'>Power Belt</font> (for Defense), <font color='#FF5F5F'>Power Lens</font> " +
					"(for Special Attack), <font color='#FF5F5F'>Power Band</font> (for Special Defense). " +
					"<br /><br />" +
					"There is also the <font color='#FF5F5F'>Macho Brace</font>" +
					", which is not a Power-item, but will double your Pokémon's gained EV's.";
		}
		
		if(p==7){
			return
					"The Power-items will let you gain an additional 4 EV's (or 1 stat raise) for that stat after each defeated Pokémon in battle. " +
					"<br /><br />" +
					"For example, in a Double battle you'll gain 8 EV's after defeating both Pokémon, and in Triples you'll get 12 EV's after all three Pokémon have been defeated. Power items are one of the best boosters for EV-training." +
					"<br /><br />" +
					"The <font color='#FF5F5F'>Macho Brace</font> isn't as used, but it doubles the gained EV's in a Pokémon. If you can't afford the Power-items, the Macho Brace is a good alternative.";
		}
		
		if(p==8){
			return
					"<font color='#FF5F5F'>Pokérus</font> is a virus that spreads in your Pokémon party. " +
					"<br /><br />" +
					"Don't worry: it's not a deadly virus. All it does is double the total EV's gained by the Pokémon. It essentially works as a Macho Brace without having to hold an item. " +
					"<br /><br />" +
					"<font color='#FF5F5F'>Pokérus</font> can be gained by spreading it from one Pokémon to another; getting a Pokémon with <font color='#FF5F5F'>Pokérus</font> initially is rare, but can be done with trading. " +
					"<br /><br />" +
					"Once you have one with the virus, you want to put the Pokémon you wish to affect next to the infected one in your party. Then after a few battles, your desired Pokémon should be infected too!";
		}
		
		if(p==9){
			return "Now that you know all this, there are three ways to EV train, each better than the last...";
		}
		
		if(p==10){
			return
					"Each Pokémon in the game will have a certain EV Yield, which is how many EV's your Pokémon will get from defeating it in battle. " +
					"<br /><br />" +
					"For example, <font color = '#A366A3'>Blissey</font>'s EV Yield is 3 HP, <font color = '#A366A3'>Stantler</font>'s is 1 Attack, and so on. ";
					
		}
		
		if(p==11){
			
			return
					"In addition, defeating or capturing (in Pokémon X&Y) a <font color = '#A366A3'>Stantler</font> will make your Pokémon gain 1 EV in Attack. " +
					"<br /><br />" +
					"This is incredibly tedious and will take hours, especially when you consider that finding the right Pokémon to defeat can be difficult. This way isn't recommended at all.";
		}
		
		if(p==12){
			return
					"The sixth generation brought about a much less painful way to EV train: <font color='#FF5F5F'>Super Training</font>. You can do this by scrolling the bottom screen till you get the screen titled “<font color='#FF5F5F'>Super Training</font>.” " +
					"<br /><br />" +
					"There are two game modes in this: <font color='#FF5F5F'>Super Training</font> Regimen and punching bags. ";
		}
		
		if(p==13){
			return
					"Punching bags can increase your EV count by either 1, 4, or 12 (depending if your Bag is small, medium, or large respectively); the bags can be representative of any stat. " +
					"<br /><br />" +
					"In addition, some bags can also be used for other purposes. Reset bags reset your EV total, Soothing bags increase your Pokémon's happiness, and Team Flare bag will allow you to find more bags. Finding bags is done by two ways: hitting the regular bag repeatedly or by beating the <font color='#FF5F5F'>Super Training</font> Regimen.";
		}
		
		if(p==14){
			return
					"There are five more bags, and they all have to do with the <font color='#FF5F5F'>Super Training</font> Regimen. This regiment is important because it is a much more reliable way to get EV's instead of hoping for the right bag to appear for you. The <font color='#FF5F5F'>Super Training</font> Regiment is distributed by the six stats, each by three levels. " +
					"<br /><br />" +
					"Level 1 will give you 4 EV's, Level 2 will give you 8 EV's, and Level 3 will give you 12 EV's. The idea of the regiment is to hit the target with a ball, which you control with the 3DS stylus. If you get to the target score in a certain amount of time, you win. The prize you win will be a Training Bag of that same stat (size is random).";
		}
		
		if(p==15){
			return
					"<font color='#FF5F5F'>Super Training</font> is a much quicker way of EV training, and some actually prefer it. It's important to note that Power-items and Pokérus don't affect <font color='#FF5F5F'>Super Training</font>; because of this there is one more way of EV-training, and it is the fastest one.";
		}
		
		if(p==16){
			return
					"In Pokémon X&Y a new type of battle was established: Horde Battles. This is when your Pokémon takes on 5 other Pokémon, and has to defeat them all. " +
					"<br /><br />" +
					"Since each Pokémon has a certain EV Yield, and in a Horde battle (most of the time) it will be the same Pokémon five times, you will be getting the EV Yield * 5 in that stat. If you have the appropriate power item, add that and Pokérus, and you have (EV Yield + 4) * 5 *2. " +
					"<br /><br />" +
					"If the opponent's EV Yield is 1, as with most horde battles, you will get a total of 50 EV's in just one battle! If the EV Yield is 2 (which there are a few later in the game), then that total becomes 60. " +
					"<br /><br />" +
					"<a href=\"https://www.smogon.com/forums/threads/a-guide-to-ev-training-with-hordes.3490052/\">Smogon</a> has a great thread on where to find your desired hordes.";
		}
		
		if(p==17){
			return
					"Some suggestions for Horde Battles:" +
					"<br /><br />" +
					"1. Turn on EXP Share. Make sure the Pokémon you are battling with has a very high level and a multi-foe hitting move (Surf, Dazzling Gleam, Incinerate, etc.)." +
					"<br /><br />" +
					"2. Use a Pokémon with Sweet Scent, as they initiate Horde battles. Sweet Scent can't be used if the weather is raining, so if that's the case EV train in a different stat, then come back.";
		}
		
		if(p==18){
			return "This is by far the best way to EV train, because if you get good enough at it, EV training takes about 20 minutes, tops. Super Training would take approximately a half hour, and regular battling will take about 90 minutes to 2 hours.";
		}

		return "";
	}

}
