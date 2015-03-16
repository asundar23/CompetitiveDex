package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CheckClassFragment extends Fragment{
	
	TextView text;
	
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle bundle)
	{
		super.onCreate(bundle);
		
		View rootView = inflater.inflate(R.layout.check, 
				container, false);
		
		text = (TextView) rootView.findViewById(R.id.checkText);
		
		text.setText(Html.fromHtml("Data is not currently available for this. Development is still in progress; expect a beta version " +
				"of the Pokemon Competitive Dex soon! <br /><br />Meanwhile, feel " +
				"free to email suggestions to the " +
				"developer at <i>asundar1130@gmail.com</i>."));
		
		return rootView;
	}

}
