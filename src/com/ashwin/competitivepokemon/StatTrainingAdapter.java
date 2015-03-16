package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class StatTrainingAdapter extends BaseAdapter{
	
	String[] stuff;
	Context ctx;
	TextView name;
	
	public StatTrainingAdapter (Context ctx, String[] stuff)
	{
		this.stuff = stuff;
		this.ctx = ctx;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return stuff.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return stuff[position];
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
            li.inflate(R.layout.stat_training_text_view, rl, true);
        }
		
		name = (TextView) rl.findViewById(R.id.stat_train_TV);
        
        name.setText(stuff[position]);
		
		return rl;
	}

}
