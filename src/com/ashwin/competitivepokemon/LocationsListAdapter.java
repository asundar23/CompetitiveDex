package com.ashwin.competitivepokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class LocationsListAdapter extends BaseAdapter{
	
	String[] lists;
	Context ctx;
	
	public LocationsListAdapter(String[] n, Context c)
	{
		lists = n;
		ctx = c;
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lists[position];
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater li;
		RelativeLayout rl;
		TextView a;
		
		rl = (RelativeLayout) convertView;
		
		if(rl == null)
		{
			li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.locationslistview, rl, true);
		}
		
		a = (TextView) rl.findViewById(R.id.locationTextView);
		
		a.setText(lists[position]);
		
		return rl;
	}
	

}
