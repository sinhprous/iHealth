package com.tungbk.ihealth;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tungbk.ihealth.fragment.DataFragment;
import com.tungbk.ihealth.fragment.DietFragment;
import com.tungbk.ihealth.fragment.ExerciseFragment;
import com.tungbk.ihealth.fragment.InformationFragment;
import com.tungbk.ihealth.fragment.MeasureFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), getApplicationContext());

        ViewPager viewPager = (ViewPager) findViewById(R.id.home_viewpager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_red_heart);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_chart);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_run);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_meal);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_user);

        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(5);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    tab.setIcon(R.drawable.ic_red_heart);
                } else if(tab.getPosition() == 1){
                    tab.setIcon(R.drawable.ic_red_chart);
                } else if(tab.getPosition() == 2){
                    tab.setIcon(R.drawable.ic_red_run);
                } else if(tab.getPosition() == 3){
                    tab.setIcon(R.drawable.ic_red_meal);
                } else if(tab.getPosition() == 4){
                    tab.setIcon(R.drawable.ic_red_user);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    tab.setIcon(R.drawable.ic_heart);
                } else if(tab.getPosition() == 1){
                    tab.setIcon(R.drawable.ic_chart);
                } else if(tab.getPosition() == 2){
                    tab.setIcon(R.drawable.ic_run);
                } else if(tab.getPosition() == 3){
                    tab.setIcon(R.drawable.ic_meal);
                } else if(tab.getPosition() == 4){
                    tab.setIcon(R.drawable.ic_user);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        if(getSupportActionBar() != null)
            getSupportActionBar().hide();

    }

    class PagerAdapter extends FragmentPagerAdapter {

        Context context;

        public PagerAdapter(FragmentManager fm, Context ctx) {
            super(fm);
            this.context = ctx;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MeasureFragment();
                case 1:
                    return new DataFragment();
                case 2:
                    return new ExerciseFragment();
                case 3:
                    return new DietFragment();
                case 4:
                    return new InformationFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

    }
}
