package com.ashwin.competitivepokemon;

import com.ashwin.competitivepokemon.R;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class CustomSpinnerType extends BaseAdapter{
	
	Context ctx;
	String[] listPokemon = {
			"All (Type)",
			"Bug",
			"Dark",
			"Dragon",
			"Electric",
			"Fairy",
			"Fighting",
			"Fire",
			"Flying",
			"Ghost",
			"Grass",
			"Ground",
			"Ice",
			"Normal",
			"Poison",
			"Psychic",
			"Rock",
			"Steel",
			"Water"
		};
	TypeBackgrounds tb;
	List<String> list;
	pokedexList thePokedexList;
	
	
	public CustomSpinnerType(Context c)
	{
		ctx = c;
	}

	@Override
	public int getCount() {
		return listPokemon.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listPokemon[position];
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
		TextView tv;
		
		rl = (RelativeLayout) convertView;
		
		if (rl == null) {
            li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.type_spinner_custom, rl, true);
        }		
		
		tv = (TextView) rl.findViewById(R.id.type);

		tv.setText(listPokemon[position]);
		
		switch(position)
		{
		case 0:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.dark_purple));
			break;
		case 1:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.bug));
			break;
		case 2:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.dark));
			break;
		case 3:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.dragon));
			break;
		case 4:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.electric));
			break;
		case 5:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.fairy));
			break;
		case 6:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.fighting));
			break;
		case 7:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.fire));
			break;
		case 8:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.flying));
			break;
		case 9:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.ghost));
			break;
		case 10:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.grass));
			break;
		case 11:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.ground));
			break;
		case 12:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.ice));
			break;
		case 13:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.normal));
			break;
		case 14:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.poison));
			break;
		case 15:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.psychic));
			break;
		case 16:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.rock));
			break;
		case 17:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.steel));
			break;
		case 18:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.water));
			break;
		default:
			tv.setBackgroundColor(ctx.getResources().getColor(R.color.black));
		}
		
		return rl;
	}
	
}
