package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MoveAdapter extends BaseAdapter{
	Context ctx;
	String[] listMoves;
	TypeBackgrounds tb;
	List<String> list;
	MovedexList theMoveList;
	String[] listTypeMoves;
	String[] movePower;
	String[] moveAccuracy;
	String type;
	
	public MoveAdapter(Context c,String[] s,String[] p, String[] x,String[] a)
	{
		ctx = c;
		tb = new TypeBackgrounds(ctx);
		listMoves = s;
		listTypeMoves = p;
		movePower = x;
		moveAccuracy = a;
		theMoveList = new MovedexList(listMoves,listTypeMoves,movePower,moveAccuracy);
		
	}

	@Override
	public int getCount() {
		return listMoves.length;
	}

	@Override
	public Object getItem(int position) {
		return listMoves[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater li;
		RelativeLayout rl;
		TextView tv;
		TextView type1;
		TextView power;
		TextView accuracy;
		
		list = (List<String>) theMoveList.getTypes(position);
		
		if(list == null) Log.d("tag", "This is a null list for "+ listMoves[position]);
		
		
		rl = (RelativeLayout) convertView;
		
		if (rl == null) {
            li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.movedex_text_view, rl, true);
            
            
            type1 = (TextView) rl.findViewById(R.id.type);
            power = (TextView) rl.findViewById(R.id.power_of_moves);
            accuracy = (TextView) rl.findViewById(R.id.accuracy_of_moves);
        }
		
		tv = (TextView) rl.findViewById(R.id.movedex_text_view);
		type1 = (TextView) rl.findViewById(R.id.type);
		power = (TextView) rl.findViewById(R.id.power_of_moves);
		accuracy = (TextView) rl.findViewById(R.id.accuracy_of_moves);
		
		type1.setBackgroundColor(tb.getBackgroundColor(list.get(0)));
		
		tv.setText(listMoves[position]);
		type1.setText(list.get(0));
		power.setText(list.get(1));
		accuracy.setText(list.get(2));
		
		return rl;
	}
}
