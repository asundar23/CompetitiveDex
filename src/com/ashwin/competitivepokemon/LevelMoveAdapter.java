package com.ashwin.competitivepokemon;


import java.util.Arrays;
import java.util.HashMap;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class LevelMoveAdapter extends BaseAdapter{
	
	Context ctx;
	
	String[] levels;
	String[] moves;
	String[] types;
	int backgroundColors[];
	Spinner moveSpinner;
	String note;
	String name;
	Pokemon pokemon;
	String[] damagingMoves;
	
	public LevelMoveAdapter(Context c, String[] l,
			String[] m, String[] t,int[] b, String n)
	{
		ctx = c;
		
		levels = l;
		moves = m;
		types = t;
		backgroundColors=b;
		name = n;
		
		damagingMoves= new String[]{
				"Absorb",

				"Acid",

				"Acid Spray",

				"Acrobatics",

				"Aerial Ace",

				"Aeroblast",

				"Air Cutter",

				"Air Slash",

				"Ancient Power",

				"Aqua Jet",

				"Aqua Tail",

				"Arm Thrust",

				"Assurance",

				"Astonish",

				"Attack Order",

				"Aura Sphere",

				"Aurora Beam",

				"Avalanche",

				"Barrage",

				"Beat Up",

				"Belch",

				"Bide",

				"Bind",

				"Bite",

				"Blast Burn",

				"Blaze Kick",

				"Blizzard",

				"Blue Flare",

				"Body Slam",

				"Bolt Strike",

				"Bone Club",

				"Bone Rush",

				"Bonemerang",

				"Boomburst",

				"Bounce",

				"Brave Bird",

				"Brick Break",

				"Brine",

				"Bubble",

				"Bubble Beam",

				"Bug Bite",

				"Bug Buzz",

				"Bulldoze",

				"Bullet Punch",

				"Bullet Seed",

				"Charge Beam",

				"Chatter",

				"Chip Away",

				"Circle Throw",

				"Clamp",

				"Clear Smog",

				"Close Combat",

				"Comet Punch",

				"Confusion",

				"Constrict",

				"Counter",

				"Covet",

				"Crabhammer",

				"Cross Chop",

				"Cross Poison",

				"Crunch",

				"Crush Claw",

				"Crush Grip",

				"Cut",

				"Dark Pulse",

				"Dazzling Gleam",

				"Dig",

				"Disarming Voice",

				"Discharge",

				"Dive",

				"Dizzy Punch",

				"Doom Desire",

				"Double Hit",

				"Double Kick",

				"Double-Edge",

				"Double Slap",

				"Draco Meteor",

				"Dragon Claw",

				"Dragon Pulse",

				"Dragon Rage",

				"Dragon Rush",

				"Dragon Tail",

				"Dragon Breath",

				"Drain Punch",

				"Draining Kiss",

				"Dream Eater",

				"Drill Peck",

				"Drill Run",

				"Dual Chop",

				"Dynamic Punch",

				"Earth Power",

				"Earthquake",

				"Echoed Voice",

				"Egg Bomb",

				"Electro Ball",

				"Electroweb",

				"Ember",

				"Endeavor",

				"Energy Ball",

				"Eruption",

				"Explosion",

				"Extrasensory",

				"Extreme Speed",

				"Facade",

				"Fairy Wind",

				"Fake Out",

				"False Swipe",

				"Feint",

				"Feint Attack",

				"Fell Stinger",

				"Fiery Dance",

				"Final Gambit",

				"Fire Blast",

				"Fire Fang",

				"Fire Pledge",

				"Fire Punch",

				"Fire Spin",

				"Flail",

				"Flame Burst",

				"Flame Charge",

				"Flame Wheel",

				"Flamethrower",

				"Flare Blitz",

				"Flash Cannon",

				"Fling",

				"Fly",

				"Flying Press",

				"Focus Blast",

				"Focus Punch",

				"Force Palm",

				"Foul Play",

				"Freeze-Dry",

				"Freeze Shock",

				"Frenzy Plant",

				"Frost Breath",

				"Frustration",

				"Fury Attack",

				"Fury Cutter",

				"Fury Swipes",

				"Fusion Bolt",

				"Fusion Flare",

				"Future Sight",

				"Gear Grind",

				"Giga Drain",

				"Giga Impact",

				"Glaciate",

				"Grass Knot",

				"Grass Pledge",

				"Gunk Shot",

				"Gust",

				"Gyro Ball",

				"Hammer Arm",

				"Head Charge",

				"Head Smash",

				"Headbutt",

				"Heart Stamp",

				"Heat Crash",

				"Heat Wave",

				"Heavy Slam",

				"Hex",

				"High Jump",

				"Hidden Power",
				
				"High Jump Kick",

				"Hold Back",

				"Horn Attack",

				"Horn Leech",

				"Hurricane",

				"Hydro Cannon",

				"Hydro Pump",

				"Hyper Beam",

				"Hyper Fang",

				"Hyper Voice",

				"Ice Ball",

				"Ice Beam",

				"Ice Burn",

				"Ice Fang",

				"Ice Punch",

				"Ice Shard",

				"Icicle Crash",

				"Icicle Spear",

				"Icy Wind",

				"Incinerate",

				"Inferno",

				"Infestation",

				"Iron Head",

				"Iron Tail",

				"Judgment",

				"Jump Kick",

				"Karate Chop",

				"Knock Off",

				"Land's Wrath",

				"Last Resort",

				"Lava Plume",

				"Leaf Blade",

				"Leaf Storm",

				"Leaf Tornado",

				"Leech Life",

				"Lick",

				"Low Kick",

				"Low Sweep",

				"Luster Purge",

				"Mach Punch",

				"Magical Leaf",

				"Magma Storm",

				"Magnet Bomb",

				"Magnitude",

				"Me First",

				"Mega Drain",

				"Mega Kick",

				"Mega Punch",

				"Megahorn",

				"Metal Burst",

				"Metal Claw",

				"Meteor Mash",

				"Mirror Coat",

				"Mirror Shot",

				"Mist Ball",

				"Moonblast",

				"Mud Bomb",

				"Mud Shot",

				"Mud-Slap",

				"Muddy Water",

				"Mystical Fire",

				"Natural Gift",

				"Nature Power",

				"Needle Arm",

				"Night Daze",

				"Night Shade",

				"Night Slash",

				"Nuzzle",

				"Oblivion Wing",

				"Octazooka",

				"Ominous Wind",

				"Outrage",

				"Overheat",

				"Parabolic Charge",

				"Pay Day",

				"Payback",

				"Peck",

				"Petal Blizzard",

				"Petal Dance",

				"Phantom Force",

				"Pin Missile",

				"Play Rough",

				"Pluck",

				"Poison Fang",

				"Poison Jab",

				"Poison Sting",

				"Poison Tail",

				"Pound",

				"Powder Snow",

				"Power Gem",

				"Power-Up Punch",

				"Power Whip",

				"Present",

				"Psybeam",

				"Psychic",

				"Psycho Boost",

				"Psycho Cut",

				"Psyshock",

				"Psystrike",

				"Psywave",

				"Punishment",

				"Pursuit",

				"Quick Attack",

				"Rage",

				"Rapid Spin",

				"Razor Leaf",

				"Razor Shell",

				"Razor Wind",

				"Relic Song",

				"Retaliate",

				"Return",

				"Revenge",

				"Reversal",

				"Roar of",

				"Rock Blast",

				"Rock Climb",

				"Rock Slide",

				"Rock Smash",

				"Rock Throw",

				"Rock Tomb",

				"Rock Wrecker",

				"Rolling Kick",

				"Rollout",

				"Round",

				"Sacred Fire",

				"Sacred Sword",

				"Sand Tomb",

				"Scald",

				"Scratch",

				"Searing Shot",

				"Secret Power",

				"Secret Sword",

				"Seed Bomb",

				"Seed Flare",

				"Seismic Toss",

				"Self-Destruct",

				"Shadow Ball",

				"Shadow Claw",

				"Shadow Force",

				"Shadow Punch",

				"Shadow Sneak",

				"Shock Wave",

				"Signal Beam",

				"Silver Wind",

				"Skull Bash",

				"Sky Attack",

				"Sky Drop",

				"Sky Uppercut",

				"Slam",

				"Slash",

				"Sleep Talk",

				"Sludge",

				"Sludge Bomb",

				"Sludge Wave",

				"Smack Down",

				"Smelling Salts",

				"Smog",

				"Snarl",

				"Snore",

				"Solar Beam",

				"Sonic Boom",

				"Spacial Rend",

				"Spark",

				"Spike Cannon",

				"Spit Up",

				"Steamroller",

				"Steel Wing",

				"Stomp",

				"Stone Edge",

				"Stored Power",

				"Storm Throw",

				"Strength",

				"Struggle",

				"Struggle Bug",

				"Submission",

				"Sucker Punch",

				"Super Fang",

				"Superpower",

				"Surf",

				"Swift",

				"Synchronoise",

				"Tackle",

				"Tail Slap",

				"Take Down",

				"Techno Blast",

				"Thief",

				"Thrash",

				"Thunder",

				"Thunder Fang",

				"Thunder Punch",

				"Thunder Shock",

				"Thunderbolt",

				"Tri Attack",

				"Triple Kick",

				"Trump Card",

				"Twineedle",

				"Twister",

				"U-turn",

				"Uproar",

				"V-create",

				"Vacuum Wave",

				"Venoshock",

				"Vice Grip",

				"Vine Whip",

				"Vital Throw",

				"Volt Switch",

				"Volt Tackle",

				"Wake-Up Slap",

				"Water Gun",

				"Water Pledge",

				"Water Pulse",

				"Water Shuriken",

				"Water Spout",

				"Waterfall",

				"Weather Ball",

				"Whirlpool",

				"Wild Charge",

				"Wing Attack",

				"Wood Hammer",

				"Wrap",

				"Wring Out",

				"X-Scissor",

				"Zap Cannon",

				"Zen Headbutt"


		};
		
		pokemon = new Pokemon (ctx,name);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return levels.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return moves[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater li;
		RelativeLayout rl;
		TextView level;
		TextView move;
		TextView type;
		HashMap<String,Integer> colorMap = new HashMap<String,Integer>();
		
		String[] typesPokemon;
		
		String type1;
		String type2;
		
		typesPokemon = pokemon.getTypes();
		
		type1 = typesPokemon[0];
		type2 = typesPokemon[1];
		
		
		rl = (RelativeLayout) convertView;
		
		
		
		if (rl == null) {
            li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.level_screen_text_view, rl, true);
            
            level = (TextView) rl.findViewById(R.id.the_level);
            move = (TextView) rl.findViewById(R.id.the_move);
            type = (TextView) rl.findViewById(R.id.the_type);
            
        }
		
		 level = (TextView) rl.findViewById(R.id.the_level);
         move = (TextView) rl.findViewById(R.id.the_move);
         type = (TextView) rl.findViewById(R.id.the_type);
         
         level.setText(levels[position]);
         move.setText(moves[position]);
         type.setText(types[position]);
         
         
         
         colorMap.put(" Bug ", backgroundColors[0]);
         colorMap.put(" Dark ", backgroundColors[1]);
         colorMap.put(" Dragon ", backgroundColors[2]);
         colorMap.put(" Electric ", backgroundColors[3]);
         colorMap.put(" Fairy ", backgroundColors[4]);
         colorMap.put(" Fire ", backgroundColors[6]);
         colorMap.put(" Fighting ", backgroundColors[5]);
         colorMap.put(" Flying ", backgroundColors[7]);
         colorMap.put(" Ghost ", backgroundColors[8]);
         colorMap.put(" Grass ", backgroundColors[9]);
         colorMap.put(" Ground ", backgroundColors[10]);
         colorMap.put(" Ice ", backgroundColors[11]);
         colorMap.put(" Normal ", backgroundColors[12]);
         colorMap.put(" Poison ", backgroundColors[13]);
         colorMap.put(" Psychic ", backgroundColors[14]);
         colorMap.put(" Rock ", backgroundColors[15]);
         colorMap.put(" Steel ", backgroundColors[16]);
         colorMap.put(" Water ", backgroundColors[17]);
         
         if(types[position].equals(type1) && Arrays.asList(damagingMoves).contains(moves[position])){
        	 move.setTextColor(colorMap.get(type1));
         }
         
         else if(types[position].equals(type2) && Arrays.asList(damagingMoves).contains(moves[position])){
        	 move.setTextColor(colorMap.get(type2));
         }
         else move.setTextColor(Color.WHITE);
         
         if (type.getText().equals(" Bug ")) type.setBackgroundColor(backgroundColors[0]);
         if (type.getText().equals(" Dark ")) type.setBackgroundColor(backgroundColors[1]);
         if (type.getText().equals(" Dragon ")) type.setBackgroundColor(backgroundColors[2]);
         if (type.getText().equals(" Electric ")) type.setBackgroundColor(backgroundColors[3]);
         if (type.getText().equals(" Fairy ")) type.setBackgroundColor(backgroundColors[4]);
         if (type.getText().equals(" Fire ")) type.setBackgroundColor(backgroundColors[6]);
         if (type.getText().equals(" Fighting ")) type.setBackgroundColor(backgroundColors[5]);
         if (type.getText().equals(" Flying ")) type.setBackgroundColor(backgroundColors[7]);
         if (type.getText().equals(" Ghost ")) type.setBackgroundColor(backgroundColors[8]);
         if (type.getText().equals(" Grass ")) type.setBackgroundColor(backgroundColors[9]);
         if (type.getText().equals(" Ground ")) type.setBackgroundColor(backgroundColors[10]);
         if (type.getText().equals(" Ice ")) type.setBackgroundColor(backgroundColors[11]);
         if (type.getText().equals(" Normal ")) type.setBackgroundColor(backgroundColors[12]);
         if (type.getText().equals(" Poison ")) type.setBackgroundColor(backgroundColors[13]);
         if (type.getText().equals(" Psychic ")) type.setBackgroundColor(backgroundColors[14]);
         if (type.getText().equals(" Rock ")) type.setBackgroundColor(backgroundColors[15]);
         if (type.getText().equals(" Steel ")) type.setBackgroundColor(backgroundColors[16]);
         if (type.getText().equals(" Water ")) type.setBackgroundColor(backgroundColors[17]);
		
		
		return rl;
	}

}
