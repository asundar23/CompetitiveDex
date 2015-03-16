package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;


public class Tabs extends FragmentActivity implements TabListener {
	
    String name;
    Context ctx;
    ViewPager pager;
    int backgroundColors[];
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.tabs_2);
        
    
        
        pager = (ViewPager) findViewById(R.id.pager);
        
        
        pager.setOffscreenPageLimit(1);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        
        pager.setOnPageChangeListener(new OnPageChangeListener()
        {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}

			@Override
			public void onPageSelected(int arg0) {
				
				actionBar.setSelectedNavigationItem(arg0);
				
			}
        
        });
        
        actionBar = getActionBar();
        
        backgroundColors = getResources().getIntArray(R.array.typeArray);
        
        savedInstanceState = getIntent().getExtras();
        name = savedInstanceState.getString("name");
        
        ctx = getApplicationContext();
        
        Pokemon pokemon = new Pokemon (ctx,name);
        String type = pokemon.getType1();
        
        if(type.equals(" Bug ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[0]));
        if(type.equals(" Dark ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[1]));
        if(type.equals(" Dragon ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[2]));
        if(type.equals(" Electric ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[3]));
        if(type.equals(" Fairy ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[4]));
        if(type.equals(" Fighting ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[5]));
        if(type.equals(" Fire ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[6]));
        if(type.equals(" Flying ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[7]));
        if(type.equals(" Ghost ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[8]));
        if(type.equals(" Grass ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[9]));
        if(type.equals(" Ground ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[10]));
        if(type.equals(" Ice ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[11]));
        if(type.equals(" Normal ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[12]));
        if(type.equals(" Poison ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[13]));
        if(type.equals(" Psychic ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[14]));
        if(type.equals(" Rock ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[15]));
        if(type.equals(" Steel ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[16]));
        if(type.equals(" Water ")) actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColors[17]));
    
        
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Overview");
        tab1.setTabListener(this);
        
        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Abilities");
        tab2.setTabListener(this);
        
        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("Moves");
        tab3.setTabListener(this);
        
        ActionBar.Tab tab4 = actionBar.newTab();
        tab4.setText("Breeding");
        tab4.setTabListener(this);
        
        ActionBar.Tab tab5 = actionBar.newTab();
        tab5.setText("Locations");
        tab5.setTabListener(this);
        
        ActionBar.Tab tab6 = actionBar.newTab();
        tab6.setText("Evolution");
        tab6.setTabListener(this);
        
        ActionBar.Tab tab7 = actionBar.newTab();
        tab7.setText("Sets");
        tab7.setTabListener(this);
        
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        actionBar.addTab(tab4);
        actionBar.addTab(tab5);
        actionBar.addTab(tab6);
        actionBar.addTab(tab7);
        
        
        
        }

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}
}

class ViewPagerAdapter extends FragmentPagerAdapter
{

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		
		Fragment fragment = null;
		
		if(arg0==0) fragment = new PokemonScreenView();
		if(arg0==1) fragment = new AbilitiesPokemon();
		if(arg0==2) fragment = new MovesPokemon();
		if(arg0==3) fragment = new Breeding();
		if(arg0==4) fragment = new PokemonLocations();
		if(arg0==5) fragment = new Evolutions();
		if(arg0==6) fragment = new Sets();
			
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 7;
	}
	
}
