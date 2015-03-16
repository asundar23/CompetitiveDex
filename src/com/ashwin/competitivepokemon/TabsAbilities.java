package com.ashwin.competitivepokemon;
import com.ashwin.competitivepokemon.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;


public class TabsAbilities extends FragmentActivity implements TabListener {
	
    ViewPager pager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.tabs_2);
        
    
        
        pager = (ViewPager) findViewById(R.id.pager);
        
        
        pager.setOffscreenPageLimit(1);
        pager.setAdapter(new ViewPagerAdapterAbilities(getSupportFragmentManager()));
        
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
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Overview");
        tab1.setTabListener(this);
        
        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Pokemon");
        tab2.setTabListener(this);
        
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        
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

class ViewPagerAdapterAbilities extends FragmentPagerAdapter
{

	public ViewPagerAdapterAbilities(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		
		Fragment fragment = null;
		
		if(arg0==0) fragment = new Abilities();
		if(arg0==1) fragment = new PokemonAbilities();
			
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}
