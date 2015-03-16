package com.ashwin.competitivepokemon;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ashwin.competitivepokemon.R;

public class SetAdapter extends BaseAdapter{

	String[] array;
	Context ctx;
	
	public SetAdapter(Context ctx2, ArrayList<String> list) {
		ctx = ctx2;
		array = new String[list.size()];
		array = list.toArray(array);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return array.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return array[position];
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
		TextView thing;
		rl = (RelativeLayout) convertView;
		
		if (rl == null) {
            li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.setadapter, rl, true);
		}
		
		thing = (TextView) rl.findViewById(R.id.set_text_view);
		thing.setText(array[position]);
		
		return rl;
	}
}
