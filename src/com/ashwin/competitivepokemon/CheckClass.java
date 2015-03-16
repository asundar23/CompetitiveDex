package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;


public class CheckClass extends Activity{
	
	TextView text;
	
	public void onCreate( Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.check);
		
		text = (TextView) findViewById(R.id.checkText);
		
		text.setText(Html.fromHtml("Data is not currently available for this. Development is still in progress; expect a beta version " +
				"of the Pokemon Competitive Dex soon! <br /><br />Meanwhile, feel " +
				"free to email suggestions to the " +
				"developer at <i>asundar1130@gmail.com</i>."));
	}

}
