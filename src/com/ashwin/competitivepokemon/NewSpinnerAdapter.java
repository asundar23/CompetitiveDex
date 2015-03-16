package com.ashwin.competitivepokemon;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ashwin.competitivepokemon.R;


public class NewSpinnerAdapter extends BaseAdapter {
	
	Context c;
	String[] n;
	
	public NewSpinnerAdapter(Context c, String[] n)
	{
		this.c = c;
		this.n = n;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return n.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return n[position];
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
		TextView a;
		
		rl = (RelativeLayout) convertView;
		
		if(rl == null)
		{
			li  =  (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(c);
            li.inflate(R.layout.spinnertv, rl, true);
		}
		
		a = (TextView) rl.findViewById(R.id.sorw);
		
		a.setText(n[position]);
		return rl;
	}

}
