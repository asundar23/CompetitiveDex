package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.app.Activity;


public class TitleScreen extends Activity 
{
	
	ImageView lugia;
	Context ctx;
	
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.title_screen);

		
		int SPLASH_TIME_OUT = 4000;
		
		new Handler().postDelayed(new Runnable() {
 
            @Override
            public void run() {
                Intent i = new Intent(TitleScreen.this, MainActivity.class);
                startActivity(i);
 
                finish();
            }
        }, SPLASH_TIME_OUT);
	}

}
